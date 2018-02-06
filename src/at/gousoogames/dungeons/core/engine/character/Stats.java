package at.gousoogames.dungeons.core.engine.character;

public class Stats {

	/*Basic attributs*/
	protected int strength = 0;
	protected int vitality	= 0;
	protected int agility	= 0;
	protected int intelligence	= 0;
	protected int armor	= 0;
	
	protected int charisma = 0;
	protected int critChance = 0;
	protected int firstHitChance = 0;
	
	protected int healthPoints = 0;
	protected int manaPoints	= 0;
	protected int evasionRating	= 0;
	protected int hitChance	= 0;
	
	
	
	
	
	public void addPhysicalBaseStats(int amount){
		addBaseStrength(1);
		addBaseAgility(1);
	}
	
	public void addMagicalBaseStats(int amount){
		addBaseIntelligence(1);
		addBaseAgility(1);
	}

	public void addSupportiveBaseStats(int amount){
		addBaseVitality(1);
		addBaseArmor(1);
	}
	
	
	public Stats addToBase(Stats s){
		this.armor += s.armor;
		this.agility += s.agility;
		this.strength += s.strength;
		this.vitality += s.vitality;
		this.intelligence += s.intelligence;
		this.evasionRating += s.evasionRating;
		this.hitChance += s.hitChance;
		this.healthPoints += s.healthPoints;
		this.manaPoints += s.manaPoints;
		return this;
	}
	
	
	
	
	public void addBaseVitality(int vit){
		this.vitality += vit;
	}
	
	public void addBaseStrength(int str){
		this.strength += str;
	}
	
	public void addBaseAgility(int agi){
		this.agility += agi;
	}
	
	public void addBaseArmor(int arm){
		this.armor += arm;
	}
	
	public void addBaseIntelligence(int intell){
		this.intelligence += intell;
	}
	
	
	
}
