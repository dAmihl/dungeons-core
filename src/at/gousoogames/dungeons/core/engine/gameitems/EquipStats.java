package at.gousoogames.dungeons.core.engine.gameitems;

import at.gousoogames.dungeons.core.engine.character.Stats;

public class EquipStats extends Stats {

	
	public EquipStats(int armor, int vit, int str, int agi, int intell){
		this.armor = armor;
		this.strength = str;
		this.vitality = vit;
		this.agility = agi;
		this.intelligence = intell;
	}

	public int getStrength() {
		return strength;
	}

	public int getVitality() {
		return vitality;
	}

	public int getAgility() {
		return agility;
	}

	public int getIntelligence() {
		return intelligence;
	}
	
	public int getArmor(){
		return armor;
	}
	
	
}
