package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.gdx.gui.output.controller.Debug;

public class RandomNumberGenerator {

	public static int getRandomNumberPercentage(){
		int r = (int) (Math.random() * 100);
		Debug.log("Random percentage number generated: "+r);
		return r;
	}
	
	// TODO: rly random? btwn 2-3 always 2?
	public static int getRandomNumberBetween(int min, int max){
		int r = (int) (((Math.random() * 100) % (max-min)) + min);
		Debug.log("Random number generated between "+min+":"+max+" is "+r+".");
		return r;
	}
	
	public static float getRandomNumberBetween(float min, float max){
		int imin = (int) (min * 100);
		int imax = (int) (max * 100);
		int r = getRandomNumberBetween(imin, imax);
		float rf = (float) r / 100f;
		Debug.log("Random (float) number generated between "+min+":"+max+" is "+rf+".");
		return rf;
	}
	
	public static boolean checkNumberBetween(int num, int min, int max){
		return num <= max && num >= min;
	}
	
}
