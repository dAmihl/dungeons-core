package at.gousoogames.dungeons.gui.output;

public class OutputFactory {

	private OutputFactory(){}
	
	private static IOutput instance = null;
	
	public static IOutput getOutput(){
		if (instance == null) instance = new OutputText();
		return instance;
	}
	
	
}
