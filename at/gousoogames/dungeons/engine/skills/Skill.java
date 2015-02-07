package at.gousoogames.dungeons.engine.skills;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.engine.generator.RandomNumberGenerator;
import at.gousoogames.dungeons.engine.skills.effects.SkillEffect;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;
import at.gousoogames.dungeons.gui.output.controller.Debug;

public abstract class Skill {

	
	private static final int NEXT_LEVEL_EXP_FACTOR = 1000;
	
	
	protected  static String STD_NAME = "Skill";
	protected  static int STD_REQUIREMENT_STR = 0;
	protected  static int STD_REQUIREMENT_INT = 0;
	protected  static int STD_REQUIREMENT_VIT = 0;
	protected  static int STD_REQUIREMENT_AGI = 0;
	protected  static StatRequirements STD_REQUS = new StatRequirements(
			STD_REQUIREMENT_STR, STD_REQUIREMENT_VIT, STD_REQUIREMENT_AGI, STD_REQUIREMENT_INT); 
	
	protected	 boolean MULTI_TARGET_SKILL = false;
	
	protected    int DAMAGE_RANGE_IN_PERCENT = 10;
	
	protected    int INIT_MANA_COST = 0;
	protected 	 float MANA_COST_LEVEL_SCALE = 0f;
	
	protected    int INIT_DAMAGE = 0;
	
	protected    int PHYSICAL_DAMAGE_PERCENTAGE	= 0;
	protected    int MAGICAL_DAMAGE_PERCENTAGE = 0;
	
	protected    float AGILITY_SCALE = 0f;
	protected    float STRENGTH_SCALE	= 0f;
	protected    float VITALITY_SCALE	= 0f;
	protected    float INTELLIGENCE_SCALE	= 0f;
	protected    float WEAPON_DMG_SCALE	= 0f;
	
	protected    float INIT_DAMAGE_LEVEL_BONUS = 0f;
	protected    float AGILITY_SCALE_LEVEL_BONUS = 0f;
	protected    float STRENGTH_SCALE_LEVEL_BONUS = 0f;
	protected    float VITALITY_SCALE_LEVEL_BONUS = 0f;
	protected    float INTELLIGENCE_SCALE_LEVEL_BONUS = 0f;
	protected    float WEAPON_DMG_LEVEL_BONUS	= 0f;
	
	
	protected   int SKILL_EFFECT_INIT_DAMAGE = 0;
	protected   int SKILL_EFFECT_DURATION = 0;
	protected   float SKILL_EFFECT_DURATION_LEVEL_BONUS = 0f;
	protected   float SKILL_EFFECT_DAMAGE_LEVEL_BONUS = 0f;
	
	private String skillName;
	private GameCharacter character;
	private int skillLevel;
	private int skillExp;
	private int nextLevelExpCap;
	protected SkillEffect skillEffect; // TODO: really everywhere a effect necessary?better solution?!
	private StatRequirements statRequirements;
	protected SkillOnUse onUse;
	
	public Skill(String name, StatRequirements req, SkillEffect eff){
		this.skillName = name;
		this.skillLevel = 1;
		this.skillExp = 0;
		this.skillEffect = eff;
		this.statRequirements = req;
		setNextLevelExpCap();
		
		
		this.onUse = new SkillOnUse(){

			@Override
			public void onUse(GameCharacter c) {
				
					int physDamage = computeRawPhysicalDamage();
					int magDamage = computeRawMagicalDamage();
					Debug.log("Skill "+this+" of "+character+" giving character "+c+" RawDamage. PhysDmg: "+physDamage+" and MagDmg: "+magDamage+".");
					c.givePhysicalDamage(character, physDamage);
					c.giveMagicalDamage(character, magDamage);
					c.getBuffs().addBuff(newSkillEffectInstance());			
			}
			
		};
	}
	
	
	public void addExp(int exp){
		this.skillExp += exp;
		Debug.log("Skill "+this.skillName+" of "+this.character+"received "+exp+" EXP: Now: "+this.skillExp);
		while (this.skillExp >= nextLevelExpCap){
			levelUp();
		}
		
	}
	
	private void levelUp(){
		this.skillExp -= nextLevelExpCap;
		this.skillLevel += 1;
		setNextLevelExpCap();
		Debug.log("Skill "+this.skillName+" of "+this.character+"level up: Now: "+this.skillLevel);
		this.character.skillLeveledUp(this);
	}
	
	
	private void setNextLevelExpCap(){
		this.nextLevelExpCap = (this.skillLevel) * NEXT_LEVEL_EXP_FACTOR;
	}
	
	

	
	
	public void useSkillOn(GameCharacter ... cs){
		int manaCosts = computeManaCosts();
		
		if (checkCharacterMana(manaCosts)){
		
			if (!MULTI_TARGET_SKILL){
				this.onUse.onUse(cs[0]);
			}else{
				for (GameCharacter c: cs)
					this.onUse.onUse(c);
			}
			this.addExp(GamemodeManager.getGamemode().computeExp(this, cs[0]));
			character.giveManaCosts(manaCosts);
		}else{
			//TODO
			Debug.log(character+" not enough Mana. Has: "+character.getStats().getCurrentManaPoints()+": Needs: "+manaCosts);
		}		
	}
	
	
	
	protected boolean checkCharacterMana(int costs){
		return costs < this.character.getStats().getCurrentManaPoints();
	}
	
	
	protected int computeManaCosts(){
		int manaCostsInit = INIT_MANA_COST;
		int manaCost = (int) (manaCostsInit + (this.skillLevel * MANA_COST_LEVEL_SCALE));
		return manaCost;
	}
	
	
	protected int computeRawDamage(){
		int initDamage = (int) (INIT_DAMAGE + (this.skillLevel * INIT_DAMAGE_LEVEL_BONUS));
		int damage = initDamage;
		damage += (int) (initDamage + (character.getStats().getVitality() * (VITALITY_SCALE +  (this.skillLevel * VITALITY_SCALE_LEVEL_BONUS))));
		damage += (int) (initDamage + (character.getStats().getAgility() * (AGILITY_SCALE +  (this.skillLevel * AGILITY_SCALE_LEVEL_BONUS))));
		damage += (int) (initDamage + (character.getStats().getStrength() * (STRENGTH_SCALE +  (this.skillLevel * STRENGTH_SCALE_LEVEL_BONUS))));
		damage += (int) (initDamage + (character.getStats().getIntelligence() * (INTELLIGENCE_SCALE +  (this.skillLevel * INTELLIGENCE_SCALE_LEVEL_BONUS))));
		damage += (int) (initDamage + ((
				character.getEquipment().getMainHandWeapon().getStats().getWeaponDmg() + character.getEquipment().getOffHandWeapon().getStats().getWeaponDmg())
				* (WEAPON_DMG_SCALE +  (this.skillLevel * WEAPON_DMG_LEVEL_BONUS))));

		float damageLow = damage * (1 - (0.01f * DAMAGE_RANGE_IN_PERCENT));
		float damageHigh= damage * (1 + (0.01f * DAMAGE_RANGE_IN_PERCENT));

		int resultingDamage = (int) RandomNumberGenerator.getRandomNumberBetween(damageLow, damageHigh);
		
		if (!this.character.checkRequirements(this)){
			resultingDamage = resultingDamage/2; // TODO scalable  requirement not met penalty
			Debug.log("Skill "+this+" is not very effective: Requirements not met");
		}
		
		return resultingDamage;
	}
	
	
	protected int computeRawPhysicalDamage(){
		int physDmg = (int) (computeRawDamage() * (0.01f * PHYSICAL_DAMAGE_PERCENTAGE));
		return physDmg;
	}
	
	protected int computeRawMagicalDamage(){
		int magDmg = (int) (computeRawDamage() * (0.01f * MAGICAL_DAMAGE_PERCENTAGE));
		return magDmg;
	}
	
	protected int computeSkillEffectDamage(){
		int damage = (int) (SKILL_EFFECT_INIT_DAMAGE + (SKILL_EFFECT_DAMAGE_LEVEL_BONUS * skillLevel));
		return damage;
	}
	
	protected int computeSkillEffectDuration(){
		int duration = (int) (SKILL_EFFECT_DURATION + (SKILL_EFFECT_DURATION_LEVEL_BONUS * skillLevel));
		Debug.log("Duration "+duration+" computed!!!!!!");
		return duration;
	}
	
	
	
	
	// TODO: skill using from gameManager or direct in skill class
	
	/*
	 * GETTESR AND SETTERS
	 */
	public String getSkillName() {
		return skillName;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public int getSkillExp() {
		return skillExp;
	}
	
	public GameCharacter getCharacter(){
		return character;
	}


	public SkillEffect getSkillEffect() {
		return skillEffect.reset();
	}


	public StatRequirements getStatRequirements() {
		return statRequirements;
	}
	
	public boolean isMultiTargetSkill(){
		return MULTI_TARGET_SKILL;
	}
	
	public void setCharacter(GameCharacter c){
		this.character = c;
	}
	
	
	public SkillEffect newSkillEffectInstance(){
		return SkillEffect.EMPTY_SKILL_EFFECT;
	}
	
	
}
