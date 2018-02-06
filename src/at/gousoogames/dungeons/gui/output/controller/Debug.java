package at.gousoogames.dungeons.gui.output.controller;

public class Debug {
	

	public static void log(String logtxt){
		if (at.gousoogames.dungeons.tests.application.Application.DEBUG)
			System.out.println("-------------DebugLog: "+logtxt);
	}
	
}
