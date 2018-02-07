package at.gousoogames.dungeons.core.tests.application;

import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.game.game.SingleplayerGameManager;
import at.gousoogames.dungeons.core.gui.output.controller.IOutput;
import at.gousoogames.dungeons.core.gui.output.controller.OutputFactory;
import at.gousoogames.dungeons.core.tests.TestCases;

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
			else
				TestPlayer.giveHealth(200);
			
			SingleplayerGameManager gm = TestCases.createTestcaseGame(TestPlayer);
			at.gousoogames.dungeons.core.game.game.Game.setGameManager(gm);
			gm.startGame();
			
		}
	}

}
