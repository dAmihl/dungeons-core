package at.gousoogames.dungeons.gdx.gui.output.controller;

public class Debug {
	

	public static void log(String logtxt){
		if (at.gousoogames.dungeons.core.tests.application.Application.DEBUG)
			System.out.println("-------------DebugLog: "+logtxt);
	}
	
}
