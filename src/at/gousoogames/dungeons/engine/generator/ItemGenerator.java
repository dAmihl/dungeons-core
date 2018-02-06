package at.gousoogames.dungeons.engine.generator;

import at.gousoogames.dungeons.engine.gameitems.Item;
import at.gousoogames.dungeons.engine.gameitems.Key;
import at.gousoogames.dungeons.engine.gameitems.armor.Armor;
import at.gousoogames.dungeons.engine.gameitems.usables.Usable;
import at.gousoogames.dungeons.engine.gameitems.weapons.Weapon;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;

public class ItemGenerator {

	
	public static Item generate(){
		
		int rarity = getItemRarity();
		
		int rangeArmorMin = 0;
		int rangeArmorMax = rangeArmorMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_DROPCHANCE();
		int rangeWeaponMin = rangeArmorMax + 1;
		int rangeWeaponMax = rangeWeaponMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_WEAPON_DROPCHANCE();
		int rangeUsableMin = rangeWeaponMax + 1;
		int rangeUsableMax = rangeUsableMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_DROPCHANCE();
		int rangeKeyMin = rangeUsableMax + 1;
		int rangeKeyMax = rangeKeyMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_KEY_DROPCHANCE();
		
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		
		if (rand > GamemodeManager.getGamemode().getGenerationConfig().getITEM_DROPCHANCE()) return Item.EMPTY_ITEM; // no item spawns
		
		// reroll for item decision
		rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeArmorMin, rangeArmorMax)){
			return generateArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeWeaponMin, rangeWeaponMax)){
			return generateWeapon(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand,  rangeUsableMin, rangeUsableMax)){
			return generateUsable(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeKeyMin, rangeKeyMax)){
			return generateKey();
		}else{
			return Item.EMPTY_ITEM;
		}
		
		
		
	}
	

	public static int getItemRarity(){

		int rangeNormalMin = 0;
		int rangeNormalMax = rangeNormalMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_NORMAL_DROPCHANCE();
		int rangeRareMin = rangeNormalMax + 1;
		int rangeRareMax = rangeRareMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_RARE_DROPCHANCE();
		int rangeEpicMin = rangeRareMax + 1;
		int rangeEpicMax = rangeEpicMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_EPIC_DROPCHANCE();
		int rangeLegendaryMin = rangeEpicMax + 1;
		int rangeLegendaryMax = rangeLegendaryMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_LEGENDARY_DROPCHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeNormalMin, rangeNormalMax)) return 0;
		else if (RandomNumberGenerator.checkNumberBetween(rand, rangeRareMin, rangeRareMax)) return 1;
		else if (RandomNumberGenerator.checkNumberBetween(rand, rangeEpicMin, rangeEpicMax)) return 2;
		else if (RandomNumberGenerator.checkNumberBetween(rand, rangeLegendaryMin, rangeLegendaryMax)) return 3;
		else return 0;
	}
	
	
	private static Armor generateArmor(int rarity){
		return ArmorGenerator.generateArmor(rarity);
	}
	
	private static Weapon generateWeapon(int rarity){
		return WeaponGenerator.generateWeapon(rarity);
	}
	
	private static Usable generateUsable(int rarity){
		return UsableGenerator.generateUsable(rarity);
	}
	
	private static Key generateKey(){
		return KeyGenerator.generateKey();
	}
	
	
	
}
