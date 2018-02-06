package at.gousoogames.dungeons.core.game.game;

public class Game {

	private static SingleplayerGameManager gm;
	
	public static void setGameManager(SingleplayerGameManager gamemanager){
		Game.gm = gamemanager;
	}
	
	public static GameManager getGameManager(){
		return gm;
	}
	
}
