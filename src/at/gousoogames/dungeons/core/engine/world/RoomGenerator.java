package at.gousoogames.dungeons.core.engine.world;

import at.gousoogames.dungeons.core.engine.generator.ModuleGenerator;
import at.gousoogames.dungeons.core.engine.generator.RandomNumberGenerator;
import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;
import at.gousoogames.dungeons.gdx.gui.output.controller.Debug;

public class RoomGenerator {

	public static Room generate(){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		int smallRoomMin = 0;
		int smallRoomMax = smallRoomMin + GamemodeManager.getGamemode().getGenerationConfig().getSMALL_ROOM_CHANCE();
		int medRoomMin = smallRoomMax + 1;
		int medRoomMax = medRoomMin + GamemodeManager.getGamemode().getGenerationConfig().getMEDIUM_ROOM_CHANCE();
		int largeRoomMin = medRoomMax + 1;
		int largeRoomMax = largeRoomMin + GamemodeManager.getGamemode().getGenerationConfig().getLARGE_ROOM_CHANCE();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, smallRoomMin, smallRoomMax)){
			return generateSmallRoom();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, medRoomMin, medRoomMax)){
			return generateMediumRoom();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, largeRoomMin, largeRoomMax)){
			return generateLargeRoom();
		}else{
			return null;
		}
	}
	
	
	private static SmallRoom generateSmallRoom(){
		Debug.log("Generating small room");
		int roomSize = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getSMALL_ROOM_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getSMALL_ROOM_SIZE_MAX()
				);
		IModule[] modules = generateModules(roomSize);
		
		return new SmallRoom(roomSize,modules);
	}
	
	private static MediumRoom generateMediumRoom(){
		Debug.log("Generating medium room");

		int roomSize = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getMEDIUM_ROOM_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getMEDIUM_ROOM_SIZE_MAX()
				);
		
		IModule[] modules = generateModules(roomSize);
		
		return new MediumRoom(roomSize,modules);
	}
	
	private static LargeRoom generateLargeRoom(){
		Debug.log("Generating large room");

		int roomSize = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getLARGE_ROOM_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getLARGE_ROOM_SIZE_MAX()
				);
		
		IModule[] modules = generateModules(roomSize);
		
		return new LargeRoom(roomSize,modules);
	}
	
	private static IModule[] generateModules(int num){
		IModule[] modules = new IModule[num];
		for (int i = 0; i < num; i++){
			modules[i] = generateModule();
		}
		return modules;
	}
	
	private static IModule generateModule(){
		IModule mod = ModuleGenerator.generate();
		return mod;
	}
}
