package at.gousoogames.dungeons.tests.application;

import at.gousoogames.dungeons.engine.character.Player;
import at.gousoogames.dungeons.game.game.SingleplayerGameManager;
import at.gousoogames.dungeons.gui.output.IOutput;
import at.gousoogames.dungeons.gui.output.OutputFactory;
import at.gousoogames.dungeons.tests.TestCases;

public class Application {

	public final static boolean DEBUG = true;
	public final static IOutput output = OutputFactory.getOutput();
	
	private static Player TestPlayer = null;
	
	public static void main(String[] args) {
		
		startMainMenu();
	
	}
	
	public static void startMainMenu(){
		IOutput out = OutputFactory.getOutput();

		out.showMainMenu();
	}
	
	public static void startTestScenario(){
		
		System.out.println("welcome to dungeons lel");
		
		if (true){
			if (TestPlayer == null)
				TestPlayer = TestCases.createTestcasePlayer();
			
			SingleplayerGameManager gm = TestCases.createTestcaseGame(TestPlayer);
			at.gousoogames.dungeons.game.game.Game.setGameManager(gm);
			gm.startGame();
			
		}
	}

}
