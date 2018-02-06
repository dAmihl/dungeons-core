package at.gousoogames.dungeons.core.engine.character;

import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.skills.Skill;

public class CharacterStats extends Stats {
	

	private int currentHealthPoints = 0;
	private int currentManaPoints = 0;
	
	
	private Stats baseStats;
	
	
	public CharacterStats(int armor, int vit, int str, int agi, int intell){
		baseStats = new Stats();
		this.baseStats.armor = armor;
		this.baseStats.strength = str;
		this.baseStats.vitality = vit;
		this.baseStats.agility = agi;
		this.baseStats.intelligence = intell;
		
		this.armor = this.baseStats.armor;
		this.strength = this.baseStats.strength;
		this.vitality = this.baseStats.vitality;
		this.agility = this.baseStats.agility;
		this.intelligence = this.baseStats.intelligence;
		this.healthPoints = this.baseStats.healthPoints;
		this.manaPoints = this.baseStats.manaPoints;
		updateDerivedAttributes();
		this.healthPoints = baseStats.healthPoints;
		this.manaPoints = baseStats.manaPoints;
		this.currentHealthPoints = healthPoints;
		this.currentManaPoints = manaPoints;
	}
	
	
	public void addCumulative(Stats s){
		this.armor = this.baseStats.armor + s.armor;
		this.agility = this.baseStats.agility + s.agility;
		this.strength = this.baseStats.strength + s.strength;
		this.vitality = this.baseStats.vitality + s.vitality;
		this.intelligence = this.baseStats.intelligence + s.intelligence;
		this.evasionRating = this.baseStats.evasionRating + s.evasionRating;
		this.hitChance = this.baseStats.hitChance + s.hitChance;
		this.healthPoints = this.baseStats.healthPoints + s.healthPoints;
		this.manaPoints = this.baseStats.manaPoints + s.manaPoints;
	}
	
	/*
	 * Check given Requierements with local stats
	 */
	public boolean checkRequirements(Item i){
		StatRequirements req = i.getStatRequirements();
		if (this.baseStats.strength < req.getStrengthRequ()) return false;
		if (this.baseStats.vitality < req.getVitalityRequ()) return false;
		if (this.baseStats.agility  < req.getAgilityRequ()) return false;
		if (this.baseStats.intelligence < req.getIntelligenceRequ()) return false;
		
		return true;
	}
	
	public boolean checkRequirements(Skill i){
		StatRequirements req = i.getStatRequirements();
		if (this.baseStats.strength < req.getStrengthRequ()) return false;
		if (this.baseStats.vitality < req.getVitalityRequ()) return false;
		if (this.baseStats.agility  < req.getAgilityRequ()) return false;
		if (this.baseStats.intelligence < req.getIntelligenceRequ()) return false;
		
		return true;
	}
	
	/*Compute derived attributs*/
	public void updateDerivedAttributes(){
		StatsDeriveRules.deriveStats(this);
	}
	
	
	
	public void giveHealth(int i) {
		this.currentHealthPoints += i;
		if (this.currentHealthPoints > this.baseStats.healthPoints) this.currentHealthPoints = this.baseStats.healthPoints;
	}
	
	public void giveMana(int i) {
		this.currentManaPoints += i;
		if (this.currentManaPoints > this.baseStats.manaPoints) this.currentManaPoints = this.baseStats.manaPoints;
	}

	//TODO:  integer given is RawDamage from Skill class
	// compute effective Damage with reduction through armor, intelligence, whatever
	public void givePhysicalDamage(int i) {
		this.currentHealthPoints -= computePhysicalDamageWithReduction(i);
	}
	
	public void giveMagicalDamage(int i) {
		this.currentHealthPoints -= computeMagicalDamageWithReduction(i);
	}
	

	public void giveManaCosts(int manaCosts) {
		this.currentManaPoints -= manaCosts;
		if (currentManaPoints < 0) currentManaPoints = 0;
	}
	
	//TODO besser
	private int computePhysicalDamageWithReduction(int rawDmg){
		int effDmg = rawDmg;
		effDmg = effDmg - this.armor/2;
		effDmg = effDmg - this.strength/3;
		return effDmg;
	}
	
	//TODO besser
	private int computeMagicalDamageWithReduction(int rawDmg){
		int effDmg = rawDmg;
		effDmg = effDmg - this.armor/2;
		effDmg = effDmg - this.intelligence/3;
		return effDmg;
	}
	
	/*
	 * GETTERS AND SETTERS
	 */
	public int getStrength() {
		return strength;
	}



	public int getVitality() {
		return vitality;
	}



	public int getAgility() {
		return agility;
	}
	
	public int getArmor(){
		return armor;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public int getManaPoints() {
		return manaPoints;
	}
	
	public int getCurrentHealthPoints(){
		return currentHealthPoints;
	}
	
	public int getCurrentManaPoints(){
		return currentManaPoints;
	}

	public int getEvasionRating() {
		return evasionRating;
	}

	public int getHitChance() {
		return hitChance;
	}

	public void setHealthPoints(int healthPoints) {
		this.baseStats.healthPoints = healthPoints;
	}

	public void setManaPoints(int manaPoints) {
		this.baseStats.manaPoints = manaPoints;
	}

	public void setEvasionRating(int evasionRating) {
		this.evasionRating = evasionRating;
	}

	public void setHitChance(int hitChance) {
		this.hitChance = hitChance;
	}



	
}
