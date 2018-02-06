package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.core.engine.gameitems.WeaponStats;

public class NameGenerator {

	private static String rarityPrefix(int rarity){
		switch (rarity){
		case 0: return "Normal";
		case 1: return "Rare"; 
		case 2: return "Epic";
		case 3: return "Legendary";
		default: return "Normal";
		}
	}
	
	private static String statPostfix(ArmorStats s){
		int agi = s.getAgility();
		int arm = s.getArmor();
		int vit = s.getVitality();
		int str = s.getStrength();
		int intel = s.getIntelligence();
		if (agi >= arm && agi >= vit && agi >= str && agi >= intel) return "of Agility";
		if (str >= arm && str >= vit && str >= agi && str >= intel) return "of Strength";
		if (vit >= arm && vit >= agi && vit >= str && vit >= intel) return "of Vitality";
		if (intel >= arm && intel >= vit && intel >= str && intel >= agi) return "of Intelligence";
		if (arm >= agi && arm >= vit && arm >= str && arm >= intel) return "of Armor";

		else return "";
	}
	
	private static String statPostfix(WeaponStats s){
		int agi = s.getAgility();
		int arm = s.getArmor();
		int vit = s.getVitality();
		int str = s.getStrength();
		int intel = s.getIntelligence();
		if (agi >= arm && agi >= vit && agi >= str && agi >= intel) return "of Agility";
		if (str >= arm && str >= vit && str >= agi && str >= intel) return "of Strength";
		if (vit >= arm && vit >= agi && vit >= str && vit >= intel) return "of Vitality";
		if (intel >= arm && intel >= vit && intel >= str && intel >= agi) return "of Intelligence";
		if (arm >= agi && arm >= vit && arm >= str && arm >= intel) return "of Armor";

		else return "";
	}
	
	public static String generateHealpotName(int rarity){
		return rarityPrefix(rarity) + " Healpot";
	}
	
	
	public static String generateHeadArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Head Armor "+statPostfix(s);
	}
	
	public static String generateShoulderArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Shoulder Armor "+statPostfix(s);
	}
	
	public static String generateBreastArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Chest Armor "+statPostfix(s);
	}
	
	public static String generateLegArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Panties "+statPostfix(s);
	}
	
	public static String generateFootArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Shoes "+statPostfix(s);
	}
		
	public static String generateRingArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Ring "+statPostfix(s);
	}
	
	public static String generateAmuletArmorName(ArmorStats s, int rarity){
		return rarityPrefix(rarity)+" Amulet "+statPostfix(s);
	}

	public static String generateWeaponName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Weapon "+statPostfix(s);
	}
	
	public static String generateOneHandSwordName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Onehand Sword "+statPostfix(s);
	}
	
	public static String generateOneHandAxeName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Onehand Axe "+statPostfix(s);
	}
	
	public static String generateOneHandMaceName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Onehand Mace "+statPostfix(s);
	}
	
	public static String generateOneHandDaggerName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Onehand Dagger "+statPostfix(s);
	}
	
	public static String generateTwoHandSwordName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Twohand Sword "+statPostfix(s);
	}
	
	public static String generateTwoHandAxeName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Twohand Axe "+statPostfix(s);
	}
	
	public static String generateTwoHandMaceName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Twohand Mace "+statPostfix(s);
	}
	
	public static String generateTwoHandStaffName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Twohand Staff "+statPostfix(s);
	}
	
	public static String generateTwoHandBowName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Twohand Bow "+statPostfix(s);
	}
	
	public static String generateOffhandScepterName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Offhand Scepter "+statPostfix(s);
	}
	
	public static String generateOffhandShieldName(WeaponStats s, int rarity){
		return rarityPrefix(rarity)+" Offhand Shield "+statPostfix(s);
	}
}
