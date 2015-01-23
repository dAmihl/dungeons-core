package at.gousoogames.dungeons.game.gamemodes;

public class GamemodeManager {

	private GamemodeManager(){}
	
	private static Gamemode currentGamemode;
	
	public static Gamemode getGamemode(){
		if (currentGamemode == null) currentGamemode = StandardGamemode.getGamemode();
		return currentGamemode;
	}
	
	
}
