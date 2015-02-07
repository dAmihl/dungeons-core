package at.gousoogames.dungeons.gui.output.screens;

import at.gousoogames.dungeons.gui.output.controller.InputManagerFactory;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class WelcomeScreen extends AbstractScreen {

	
	public WelcomeScreen(Game gameApplication) {
		super(gameApplication);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Welcome to dungeons. click to start", 10, 200);
		batch.end();
		
		 if (Gdx.input.justTouched()) // use your own criterion here
            InputManagerFactory.getInputManager().handleInputMainMenu(null);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
