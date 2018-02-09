package at.gousoogames.dungeons.core;

import at.gousoogames.dungeons.core.config.ConfigManager;
import at.gousoogames.dungeons.core.gui.console.GUIConsole;
import at.gousoogames.dungeons.core.tests.application.Application;

public class Dungeons{

	public static Dungeons instance;
	
	
	public static void main(String[] args) {
		
		//GUIConsole console = new GUIConsole();
		
		ConfigManager.loadControlsConfig();
		
		Application.startMainMenu();
		
	}
	

	
}
