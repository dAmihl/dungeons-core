package at.gousoogames.dungeons.core.gui.output.controller;

public class InputManagerFactory {

	private InputManagerFactory(){}
	
	private static IInputManager instance = null;
	
	public static IInputManager getInputManager(){
		if (instance == null) instance = new InputManagerText();
		return instance;
	}
	
}
