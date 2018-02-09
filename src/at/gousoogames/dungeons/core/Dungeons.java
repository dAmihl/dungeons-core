package at.gousoogames.dungeons.core;



import at.gousoogames.dungeons.core.config.ConfigManager;
import at.gousoogames.dungeons.core.tests.application.Application;

public class Dungeons{

	public static Dungeons instance;
	
	
	public static void main(String[] args) {

			ConfigManager.loadControlsConfig();
			
			Application.startMainMenu();
			
	}
	

	
}
