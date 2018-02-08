package at.gousoogames.dungeons.core.config;

import java.util.Properties;

import at.gousoogames.dungeons.core.gui.output.controller.Debug;

public class InputConfigurationManager {

	private static Properties controls;
	
	private final static String DEFAULT_KEY_STARTFIGHT = "F";
	private final static String DEFAULT_KEY_SHOWINVENTORY = "I";
	private final static String DEFAULT_KEY_SHOWCHARACTER = "C";
	private final static String DEFAULT_KEY_SHOWSKILLSET = "S";
	private final static String DEFAULT_KEY_GOBACK = "B";
	private final static String DEFAULT_KEY_EXIT = "EXIT";

	
	public static final String getKeyStartFight(){
		if (!check()) return DEFAULT_KEY_STARTFIGHT;
		final String key = ConfigManager.getControls().getProperty("START_FIGHT", DEFAULT_KEY_STARTFIGHT);
		return key;
	}
	
	public static final String getKeyShowInventory(){
		if (!check()) return DEFAULT_KEY_SHOWINVENTORY;
		final String key = ConfigManager.getControls().getProperty("SHOW_INVENTORY", DEFAULT_KEY_SHOWINVENTORY);
		return key;
	}
	
	public static final String getKeyShowCharacter(){
		if (!check()) return DEFAULT_KEY_SHOWCHARACTER;
		final String key = ConfigManager.getControls().getProperty("SHOW_CHARACTER", DEFAULT_KEY_SHOWCHARACTER);
		return key;
	}
	
	public static final String getKeyShowSkillset(){
		if (!check()) return DEFAULT_KEY_SHOWSKILLSET;
		final String key = ConfigManager.getControls().getProperty("SHOW_SKILLSET", DEFAULT_KEY_SHOWSKILLSET);
		return key;
	}
	
	public static final String getKeyGoBack(){
		if (!check()) return DEFAULT_KEY_GOBACK;
		final String key = ConfigManager.getControls().getProperty("GO_BACK", DEFAULT_KEY_GOBACK);
		return key;
	}
	
	public static final String getKeyExit(){
		if (!check()) return DEFAULT_KEY_EXIT;
		final String key = ConfigManager.getControls().getProperty("EXIT", DEFAULT_KEY_EXIT);
		return key;
	}
	
	
	
	public static boolean isKeyShowInventory(String input){
		String key = getKeyShowInventory();
		return isInputKey(input, key);
	}
	
	public static boolean isKeyStartFight(String input){
		String key = getKeyStartFight();
		return isInputKey(input, key);
	}
	
	public static boolean isKeyShowCharacter(String input){
		String key = getKeyShowCharacter();
		return isInputKey(input, key);
	}
	
	public static boolean isKeyShowSkillset(String input){
		String key = getKeyShowSkillset();
		return isInputKey(input, key);
	}
	
	public static boolean isKeyGoBack(String input){
		String key = getKeyGoBack();
		return isInputKey(input, key);
	}
	
	public static boolean isKeyExit(String input){
		String key = getKeyExit();
		return isInputKey(input, key);
	}
	
	private static boolean isInputKey(String input, String key){
		return input.equals(key) || input.toUpperCase().equals(key);
	}
	
	private static boolean check(){
		if (controls == null){
			controls = ConfigManager.getControls();
			if (controls == null) Debug.log("Controls Could not be loaded. Using Default Keys!");
			return controls != null;
		}
		return true;
	}

	
}
