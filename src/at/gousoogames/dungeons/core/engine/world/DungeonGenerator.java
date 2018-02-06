package at.gousoogames.dungeons.core.engine.world;

import at.gousoogames.dungeons.core.engine.generator.RandomNumberGenerator;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class DungeonGenerator {

	public static Dungeon generate(){
		int dungeonSize = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getDUNGEON_SIZE_ROOMS_MIN(), 
				GamemodeManager.getGamemode().getGenerationConfig().getDUNGEON_SIZE_ROOMS_MAX()
				);
		return new Dungeon(dungeonSize);
	}
	
}
