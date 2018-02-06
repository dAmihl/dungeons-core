package at.gousoogames.dungeons.engine.generator;

import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.engine.modules.Chest;
import at.gousoogames.dungeons.engine.modules.IModule;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;



public class ModuleGenerator {

	public static IModule generate(){
		int rangeEnemyMin = 0;
		int rangeEnemyMax = rangeEnemyMin + GamemodeManager.getGamemode().getGenerationConfig().getROOM_ENEMY_SPAWN_CHANCE();
		int rangeChestMin = rangeEnemyMax + 1;
		int rangeChestMax = rangeChestMin + GamemodeManager.getGamemode().getGenerationConfig().getROOM_CHEST_SPAWN_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeEnemyMin, rangeEnemyMax)){
			return generateEnemy();
		} else if (RandomNumberGenerator.checkNumberBetween(rand, rangeChestMin, rangeChestMax)){
			return generateChest();
		}else{
			//TODO: better than null? solution!
			return null;
		}
		
	}
	
	private static Enemy generateEnemy(){
		return EnemyGenerator.generate();
	}
	
	private static Chest generateChest(){
		return ChestGenerator.generate();
	}
	
	
}
