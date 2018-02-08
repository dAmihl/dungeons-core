package at.gousoogames.dungeons.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import at.gousoogames.dungeons.core.gui.output.controller.Debug;

public class ConfigManager {

	
	private static String INPUT_CONFIG_FILE_LOCATION = "./config/controls.cfg";
	
	private static Properties controlsProps;
	
	public static boolean loadControlsConfig(){
		try {
			controlsProps = new Properties();
			FileInputStream in = new FileInputStream(INPUT_CONFIG_FILE_LOCATION);
			controlsProps.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		Debug.log("Loaded Controls Configuration File from: "+INPUT_CONFIG_FILE_LOCATION);
		return true;
	}
	
	
	public static Properties getControls(){
		if (controlsProps == null){
			if (loadControlsConfig()){
				return controlsProps;
			}else{
				Debug.log("Could not load Controls Configuration File!");
				return null;
			}
		}
		return controlsProps;
	}
	
	public static void setControlsConfigFile(String path){
		INPUT_CONFIG_FILE_LOCATION = path;
	}
	
	
}
