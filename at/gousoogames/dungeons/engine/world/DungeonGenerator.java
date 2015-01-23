package at.gousoogames.dungeons.engine.world;

import at.gousoogames.dungeons.engine.generator.RandomNumberGenerator;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;

public class DungeonGenerator {

	public static Dungeon generate(){
		int dungeonSize = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getDUNGEON_SIZE_ROOMS_MIN(), 
				GamemodeManager.getGamemode().getGenerationConfig().getDUNGEON_SIZE_ROOMS_MAX()
				);
		return new Dungeon(dungeonSize);
	}
	
}
