package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.modules.Chest;
import at.gousoogames.dungeons.core.engine.modules.DiamondChest;
import at.gousoogames.dungeons.core.engine.modules.IronChest;
import at.gousoogames.dungeons.core.engine.modules.MagicChest;
import at.gousoogames.dungeons.core.engine.modules.WoodenChest;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class ChestGenerator {

	public static Chest generate(){
		
		int rangeWoodenMin = 0;
		int rangeWoodenMax = rangeWoodenMin + GamemodeManager.getGamemode().getGenerationConfig().getCHEST_WOODEN_SPAWN_CHANCE();
		int rangeIronMin = rangeWoodenMax + 1;
		int rangeIronMax = rangeIronMin + GamemodeManager.getGamemode().getGenerationConfig().getCHEST_IRON_SPAWN_CHANCE();
		int rangeMagicMin = rangeIronMax + 1;
		int rangeMagicMax = rangeMagicMin + GamemodeManager.getGamemode().getGenerationConfig().getCHEST_MAGIC_SPAWN_CHANCE();
		int rangeDiamondMin = rangeMagicMax + 1;
		int rangeDiamondMax = rangeDiamondMin + GamemodeManager.getGamemode().getGenerationConfig().getCHEST_DIAMOND_SPAWN_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeWoodenMin, rangeWoodenMax)){
			return generateWoodenChest();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeIronMin, rangeIronMax)){
			return generateIronChest();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeMagicMin, rangeMagicMax)){
			return generateMagicChest();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeDiamondMin, rangeDiamondMax)){
			return generateDiamondChest();
		}else{
			// TODO: better solution for null return!
			return null;
		}
		
	}
	
	private static WoodenChest generateWoodenChest(){
		int size = RandomNumberGenerator.getRandomNumberBetween(GamemodeManager.getGamemode().getGenerationConfig().getWOODEN_CHEST_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getWOODEN_CHEST_SIZE_MAX());
		return new WoodenChest(size);
	}
	
	private static IronChest generateIronChest(){
		int size = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getIRON_CHEST_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getIRON_CHEST_SIZE_MAX());
		return new IronChest(size);
	}
	
	private static MagicChest generateMagicChest(){
		int size = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getMAGIC_CHEST_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getMAGIC_CHEST_SIZE_MAX());
		return new MagicChest(size);
	}
	
	private static DiamondChest generateDiamondChest(){
		int size = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getDIAMOND_CHEST_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getDIAMOND_CHEST_SIZE_MAX());
		return new DiamondChest(size);
	}
	
}
