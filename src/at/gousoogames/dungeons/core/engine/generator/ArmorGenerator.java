package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.gameitems.armor.AmuletArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.Armor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.BreastArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.FootArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.HeadArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.LegArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.RingArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.ShoulderArmor;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class ArmorGenerator {
	
	
	public static Armor generateArmor(int rarity){
	
		int rangeHeadMin = 0;
		int rangeHeadMax = rangeHeadMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_HEAD_CHANCE();
		int rangeShoulderMin = rangeHeadMax + 1;
		int rangeShoulderMax = rangeShoulderMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_SHOULDER_CHANCE();
		int rangeBreastMin = rangeShoulderMax + 1;
		int rangeBreastMax = rangeBreastMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_CHEST_CHANCE();
		int rangePantsMin = rangeBreastMax + 1;
		int rangePantsMax = rangePantsMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_PANTS_CHANCE();
		int rangeShoesMin = rangePantsMax + 1;
		int rangeShoesMax = rangeShoesMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_SHOES_CHANCE();
		int rangeRingMin = rangeShoesMax + 1;
		int rangeRingMax = rangeRingMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_RING_CHANCE();
		int rangeAmuletMin = rangeRingMax + 1;
		int rangeAmuletMax = rangeAmuletMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_ARMOR_AMULET_CHANCE();
		
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeHeadMin, rangeHeadMax)){
			return generateHeadArmor(rarity);
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeShoulderMin, rangeShoulderMax)){
			return generateShoulderArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeBreastMin, rangeBreastMax)){
			return generateBreastArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangePantsMin, rangePantsMax)){
			return generateLegArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeShoesMin, rangeShoesMax)){
			return generateFootArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeRingMin, rangeRingMax)){
			return generateRingArmor(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeAmuletMin, rangeAmuletMax)){
			return generateAmuletArmor(rarity);
		}else{
			return (Armor) Item.EMPTY_ITEM;
		}
		
	}
	
	
	
	public static HeadArmor generateHeadArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateHeadArmorName(s, rarity);
		return new HeadArmor(name, s, req);
	}
	
	public static ShoulderArmor generateShoulderArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateShoulderArmorName(s, rarity);
		return new ShoulderArmor(name, s, req);
	}
	
	public static BreastArmor generateBreastArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateBreastArmorName(s, rarity);
		return new BreastArmor(name, s, req);
	}
	
	public static LegArmor generateLegArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateLegArmorName(s, rarity);
		return new LegArmor(name, s, req);
	}
	
	public static FootArmor generateFootArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateFootArmorName(s, rarity);
		return new FootArmor(name, s, req);
	}
	
	public static RingArmor generateRingArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateRingArmorName(s, rarity);
		return new RingArmor(name, s, req);
	}
	
	public static AmuletArmor generateAmuletArmor(int rarity){
		ArmorStats s = StatsGenerator.generateArmorStats(rarity);
		StatRequirements req = StatsGenerator.generateItemStatRequirements();
		String name = NameGenerator.generateAmuletArmorName(s, rarity);
		return new AmuletArmor(name, s, req);
	}
	
}
