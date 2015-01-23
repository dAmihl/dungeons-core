package at.gousoogames.dungeons.engine.generator;

import at.gousoogames.dungeons.engine.gameitems.DiamondKey;
import at.gousoogames.dungeons.engine.gameitems.IronKey;
import at.gousoogames.dungeons.engine.gameitems.Item;
import at.gousoogames.dungeons.engine.gameitems.Key;
import at.gousoogames.dungeons.engine.gameitems.MagicKey;
import at.gousoogames.dungeons.engine.gameitems.WoodenKey;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;

public class KeyGenerator {

	public static Key generateKey(){
		int rangeWoodenMin = 0;
		int rangeWoodenMax = rangeWoodenMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_KEY_WOODEN_CHANCE();
		int rangeIronMin = rangeWoodenMax + 1;
		int rangeIronMax = rangeIronMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_KEY_IRON_CHANCE();
		int rangeMagicMin = rangeIronMax + 1;
		int rangeMagicMax = rangeMagicMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_KEY_MAGIC_CHANCE();
		int rangeDiamondMin = rangeMagicMax + 1;
		int rangeDiamondMax = rangeDiamondMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_KEY_DIAMOND_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeWoodenMin, rangeWoodenMax)){
			return generateWoodenKey();
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeIronMin, rangeIronMax)){
			return generateIronKey();
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeMagicMin, rangeMagicMax)){
			return generateMagicKey();
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeDiamondMin, rangeDiamondMax)){
			return generateDiamondKey();
		} else{
			return (Key) Item.EMPTY_ITEM;
		}
	}
	
	public static WoodenKey generateWoodenKey(){
		return new WoodenKey("wooden key");
	}
	
	public static IronKey generateIronKey(){
		return new IronKey("iron key");
	}
	
	public static MagicKey generateMagicKey(){
		return new MagicKey("magic key");
	}
	
	public static DiamondKey generateDiamondKey(){
		return new DiamondKey("diamond key");
	}
	
}
