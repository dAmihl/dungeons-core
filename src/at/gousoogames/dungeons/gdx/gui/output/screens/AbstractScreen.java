package at.gousoogames.dungeons.gdx.gui.output.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

abstract class AbstractScreen implements Screen {

	
	Stage stage;
	SpriteBatch batch;
	BitmapFont font;
	public Game dungeonsGame;
	
	public AbstractScreen(Game gameApplication){
		this.dungeonsGame = gameApplication;
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}
	
}
