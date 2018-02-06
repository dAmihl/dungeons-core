package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.gameitems.WeaponStats;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OffhandScepter;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OffhandShield;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OffhandWeapon;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandAxe;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandDagger;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandMace;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandSword;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandWeapon;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandAxe;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandBow;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandMace;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandStaff;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandSword;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandWeapon;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.Weapon;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class WeaponGenerator {
	
	
	
	
	public static Weapon generateWeapon(int rarity){
		
		int rangeMainHandMin = 0;
		int rangeMainHandMax = rangeMainHandMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_MAINHAND_CHANCE();
		int rangeOffhandMin = rangeMainHandMax + 1;
		int rangeOffhandMax = rangeOffhandMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_OFFHAND_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeMainHandMin, rangeMainHandMax)){
			return generateMainHandWeapon(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeOffhandMin, rangeOffhandMax)){
			return generateOffhandWeapon(rarity);
		} else {
			return (Weapon) Item.EMPTY_ITEM;
		}		
		
	}
	
	public static Weapon generateMainHandWeapon(int rarity){
		int rangeOneHandMin = 0;
		int rangeOneHandMax = rangeOneHandMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_ONEHAND_CHANCE();
		int rangeTwoHandMin = rangeOneHandMax + 1;
		int rangeTwoHandMax = rangeTwoHandMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_TWOHAND_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeOneHandMin, rangeOneHandMax)){
			return generateOneHandWeapon(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeTwoHandMin, rangeTwoHandMax)){
			return generateTwoHandWeapon(rarity);
		}  else {
			return (Weapon) Item.EMPTY_ITEM;
		}
	}
	
	
	

	public static OneHandWeapon generateOneHandWeapon(int rarity){
		
		int rangeAxeMin = 0;
		int rangeAxeMax = rangeAxeMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_1H_AXE_CHANCE();
		int rangeSwordMin = rangeAxeMax + 1;
		int rangeSwordMax = rangeSwordMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_1H_SWORD_CHANCE();
		int rangeMaceMin = rangeSwordMax + 1;
		int rangeMaceMax = rangeMaceMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_1H_MACE_CHANCE();
		int rangeDaggerMin = rangeMaceMax + 1;
		int rangeDaggerMax = rangeDaggerMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_1H_DAGGER_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeAxeMin, rangeAxeMax)){
			return generateOneHandAxe(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeSwordMin, rangeSwordMax)){
			return generateOneHandSword(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeMaceMin, rangeMaceMax)){
			return generateOneHandMace(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeDaggerMin, rangeDaggerMax)){
			return generateOneHandDagger(rarity);
		}else{
			return (OneHandWeapon) Item.EMPTY_ITEM;
		}
		
		
	}
	
	public static TwoHandWeapon generateTwoHandWeapon(int rarity){
		int rangeAxeMin = 0;
		int rangeAxeMax = rangeAxeMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_2H_AXE_CHANCE();
		int rangeSwordMin = rangeAxeMax + 1;
		int rangeSwordMax = rangeSwordMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_2H_SWORD_CHANCE();
		int rangeMaceMin = rangeSwordMax + 1;
		int rangeMaceMax = rangeMaceMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_2H_MACE_CHANCE();
		int rangeStaffMin = rangeMaceMax + 1;
		int rangeStaffMax = rangeStaffMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_2H_STAFF_CHANCE();
		int rangeBowMin = rangeStaffMax + 1;
		int rangeBowMax = rangeBowMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_2H_BOW_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeAxeMin, rangeAxeMax)){
			return generateTwoHandAxe(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeSwordMin, rangeSwordMax)){
			return generateTwoHandSword(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeMaceMin, rangeMaceMax)){
			return generateTwoHandMace(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeStaffMin, rangeStaffMax)){
			return generateTwoHandStaff(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeBowMin, rangeBowMax)){
			return generateTwoHandBow(rarity);
		}else{
			return (TwoHandWeapon) Item.EMPTY_ITEM;
		}
	}
	
	public static OffhandWeapon generateOffhandWeapon(int rarity){
		int rangeScepterMin = 0;
		int rangeScepterMax = rangeScepterMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_OH_SCEPTER_CHANCE();
		int rangeShieldMin = rangeScepterMax + 1;
		int rangeShieldMax = rangeShieldMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_OH_SHIELD_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeScepterMin, rangeScepterMax)){
			return generateOffhandScepter(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeShieldMin, rangeShieldMax)){
			return generateOffhandShield(rarity);
		}else{
			return (OffhandWeapon) Item.EMPTY_ITEM;
		}
		
	}
	
	/************************************************/
	
	public static OneHandSword generateOneHandSword(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOneHandSwordName(s, rarity);
		return new OneHandSword(name, s, req);
	}
	
	public static OneHandAxe generateOneHandAxe(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOneHandAxeName(s, rarity);
		return new OneHandAxe(name, s, req);
	}
	
	public static OneHandMace generateOneHandMace(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOneHandMaceName(s, rarity);
		return new OneHandMace(name, s, req);
	}
	
	public static OneHandDagger generateOneHandDagger(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOneHandDaggerName(s, rarity);
		return new OneHandDagger(name, s, req);
	}
	
	
	/************************************************/

	
	public static TwoHandSword generateTwoHandSword(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateTwoHandSwordName(s, rarity);
		return new TwoHandSword(name, s, req);
	}
	
	public static TwoHandAxe generateTwoHandAxe(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateTwoHandAxeName(s, rarity);
		return new TwoHandAxe(name, s, req);
	}
	
	public static TwoHandMace generateTwoHandMace(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateTwoHandMaceName(s, rarity);
		return new TwoHandMace(name, s, req);
	}
	
	public static TwoHandStaff generateTwoHandStaff(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateTwoHandStaffName(s, rarity);
		return new TwoHandStaff(name, s, req);
	}
	
	public static TwoHandBow generateTwoHandBow(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateTwoHandBowName(s, rarity);
		return new TwoHandBow(name, s, req);
	}
	
	
	
	/************************************************/

	
	public static OffhandScepter generateOffhandScepter(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOffhandScepterName(s, rarity);
		return new OffhandScepter(name, s, req);
	}
	
	public static OffhandShield generateOffhandShield(int rarity){
		WeaponStats s = StatsGenerator.generateWeaponStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateOffhandShieldName(s, rarity);
		return new OffhandShield(name, s, req);
	}
	
}
