package at.gousoogames.dungeons.core.gui.output.controller;

public class GameLog {

	public static void combatLog(String logtxt){
		if (at.gousoogames.dungeons.core.tests.application.Application.COMBATLOG)
			System.out.println("++CombatLog++: "+logtxt);
	}
	
}
