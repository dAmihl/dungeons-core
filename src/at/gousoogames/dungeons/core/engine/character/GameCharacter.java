package at.gousoogames.dungeons.core.engine.character;

import at.gousoogames.dungeons.core.engine.gameitems.Equipable;
import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.gameitems.usables.Usable;
import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.engine.skills.magical.MagicalSkill;
import at.gousoogames.dungeons.core.engine.skills.physical.PhysicalSkill;
import at.gousoogames.dungeons.core.engine.skills.supportive.SupportiveSkill;
import at.gousoogames.dungeons.core.gui.output.controller.Debug;
import at.gousoogames.dungeons.core.gui.output.controller.OutputFactory;

public class GameCharacter implements IModule {

	private String characterName;
	private int characterLevel;
	private Inventory inventory;
	private Equipment equipment;
	private Skillset skillset;
	private CharacterStats stats;
	private Buffs buffs;
	
	private boolean isAbleToAction = true;
	private boolean isDead = false;
	
	public GameCharacter(String name, Inventory i, Equipment eq, Skillset sk, CharacterStats st, Buffs b){
		this.characterName = name;
		this.characterLevel = 1;
		this.inventory = i;
		this.equipment = eq;
		this.skillset = sk;
		this.stats = st;
		this.buffs = b;
	}
	
	
	private void updateStats(){
		Stats allCumul = new Stats();
		allCumul.addToBase(this.equipment.getCumulativeStats());
		allCumul.addToBase(this.buffs.getCumulativeStats());
		this.stats.addCumulative(allCumul);
//		this.stats.addCumulative(this.equipment.getCumulativeStats());
//		this.stats.addCumulative(this.buffs.getCumulativeStats());
		this.stats.updateDerivedAttributes();
	}
	

	
	
	public void equipItem(Equipable eq){
		if (checkRequirements(eq)){
			Item old = this.equipment.equipItem(eq);
			this.inventory.swapItems(eq, old);
			this.updateStats();
		}else{
			OutputFactory.getOutput().showErrorMessage("Item "+eq.getItemName()+" not equipped: Requirements not met.");
		}
	}
	
	public void skillLeveledUp(Skill s){
		if (this.skillset.skillLeveledUpNewAverageLevel(s)){
			if (s instanceof PhysicalSkill){
				addPhysicalBaseStats();
			}else if (s instanceof MagicalSkill){
				addMagicalBaseStats();
			}else if (s instanceof SupportiveSkill){
				addSupportiveBaseStats();
			}
		}
		
	}
	
	private void addPhysicalBaseStats(){
		this.stats.addPhysicalBaseStats(1);
	}
	
	private void addMagicalBaseStats(){
		this.stats.addMagicalBaseStats(1);

	}

	private void addSupportiveBaseStats(){
		this.stats.addSupportiveBaseStats(1);
	}
	
	public void learnSkill(Skill s){
			this.skillset.learnSkill(s);
			s.setCharacter(this);
	}
	
	private void computeCharacterLevel(){
		// Character level depends on skill levels
		int level = 0;
		int temp = 0;
		for (Skill s: skillset.learnedSkills){
			temp += s.getSkillLevel();
		}
		int numSkills = skillset.learnedSkills.size() == 0 ? 1 : skillset.learnedSkills.size();
		level = temp / numSkills;
		this.characterLevel = level;
	}
	
	public void tickBuffs(){
		if (!this.checkBeforePassiveAction()) return;
		this.updateStats(); // TODO: very inefficient. only BUFF stats?
		this.buffs.tick(this);
	}
	
	public boolean checkRequirements(Item i){
		return this.stats.checkRequirements(i);
	}
	
	public boolean checkRequirements(Skill s){
		return this.stats.checkRequirements(s);
	}
	
	
	public void giveHealth(int i) {
		if (!this.checkBeforePassiveAction()) return;
		this.stats.giveHealth(i);
	}
	
	public void giveMana(int i){
		if (!this.checkBeforePassiveAction()) return;
		this.stats.giveMana(i);
	}


	public void givePhysicalDamage(IModule source, int i) {
		if (!this.checkBeforePassiveAction()) return;
		this.stats.givePhysicalDamage(i);
		this.checkDeath();
	}
	
	public void giveMagicalDamage(IModule source, int i){
		if (!this.checkBeforePassiveAction()) return;
		this.stats.giveMagicalDamage(i);
		this.checkDeath();
	}
	
	public void giveHeal(int points){
		if (!this.checkBeforePassiveAction()) return;
		this.giveHealth(points);
	}
	
	

	public void giveManaCosts(int manaCosts) {
		this.stats.giveManaCosts(manaCosts);
		
	}
	
	
	protected void checkDeath(){
		if (this.stats.getCurrentHealthPoints() <= 0){
			this.stats.setCurrentHealthToZeroIfBelow();
			this.onDeath();
		}
	}
	
	protected void onDeath(){
		this.setAbleToAction(false);
		this.setIsDead(true);
	}
	
	private boolean checkBeforePassiveAction(){
		if (this.isDead()){
			Debug.log("GameCharacter "+this+" is dead. Buffs can not tick!");
			return false;
		}
		return true;
	}
	
	private boolean checkBeforeActiveAction(){
		if (!this.isAbleToAction()){
			Debug.log("GameCharacter "+this+" is not able to action!");
			return false;
		}
		return true;
	}
	
	/*
	 * Loot
	 */
	
	public void lootItems(Item... items){
		if (!this.checkBeforeActiveAction()) return;
		for (Item i: items){
			this.inventory.addItem(i);
			Debug.log(this.getCharacterName()+" got Item: "+i.getItemName());
		}
	}
	
	public void lootInventory(Inventory i){
		if (!this.checkBeforeActiveAction()) return;
		this.inventory.addGold(i.getCurrentGold());
		this.lootItems(i.getInventoryArray());
	}
	
	
	
	public boolean useItemOfInventory(Item i){
		if (!this.checkBeforeActiveAction()) return false;
		if (i instanceof Usable){
			((Usable)i).useOn(this);
			this.inventory.removeItem(i);
			return true;
		}else if (i instanceof Equipable){
			equipItem((Equipable) i);
			return true;
		}
		return false;
	}
	
	
	/*
	 * GETTERS AND SETTERS
	 */

	public String getCharacterName() {
		return characterName;
	}
	
	public boolean isAlive(){
		return this.stats.getCurrentHealthPoints() > 0;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public Skillset getSkillset() {
		return skillset;
	}

	public CharacterStats getStats() {
		return stats;
	}


	public Buffs getBuffs() {
		return buffs;
	}
	
	public int getCharacterLevel(){
		computeCharacterLevel();
		return this.characterLevel;
	}


	public boolean isAbleToAction() {
		return isAbleToAction;
	}


	private void setAbleToAction(boolean isAbleToAction) {
		this.isAbleToAction = isAbleToAction;
	}


	public boolean isDead() {
		return isDead;
	}


	private void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}




	
	
	
	
	
}
