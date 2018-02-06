package at.gousoogames.dungeons.gdx.gui.output.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.gdx.gui.output.controller.InputContainer;
import at.gousoogames.dungeons.gdx.gui.output.controller.InputManagerFactory;
import at.gousoogames.dungeons.gdx.gui.output.tools.ModuleRenderer;

public abstract class AbstractModuleActor extends Actor {

	private IModule module;
	Texture texture;
	float actorX = 100, actorY = 100;
	
	public AbstractModuleActor (IModule mod, float posX, float posY){
		this.module = mod;
		texture = ModuleRenderer.renderModule(mod);
		actorX = posX;
		actorY = posY;
		
		setTouchable(Touchable.enabled);
		
		setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                InputManagerFactory.getInputManager().handleInputRoom(new InputContainer(module));
                return true;
            }
        });
	}
	

	   @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,actorX,actorY);
    }
	
	
	public IModule getModule(){
		return module;
	}
}
