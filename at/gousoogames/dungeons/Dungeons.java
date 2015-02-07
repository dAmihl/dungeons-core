package at.gousoogames.dungeons;



import at.gousoogames.dungeons.gui.output.screens.WelcomeScreen;

import com.badlogic.gdx.Game;


public class Dungeons extends Game {

	public static Dungeons instance;

	@Override
	public void create () {
		instance = this;
		setScreen(new WelcomeScreen(this));
	}

}
