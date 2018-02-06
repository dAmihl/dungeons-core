package at.gousoogames.dungeons.gdx.gui.output.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.engine.world.Room;
import at.gousoogames.dungeons.gdx.gui.output.controller.InputManagerFactory;


public class SmallRoomScreen extends AbstractRoomScreen {


	
	public SmallRoomScreen(Game gameApplication, Room room) {
		super(gameApplication, room);
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
		batch.draw(background, 0, 0);
		String text = "oh hello to my smally roomy. here is \n";
		for (IModule m : room.getModules()){
			text += " | "+m.toString()+"\n";
		}
		font.drawMultiLine(batch, text, 300, 400);
		
		 if (Gdx.input.justTouched()) // use your own criterion here
	            InputManagerFactory.getInputManager().handleInputRoom(null);
		
		
		batch.end();
		stage.act();
		stage.draw();
		
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
