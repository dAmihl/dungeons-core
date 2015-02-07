package at.gousoogames.dungeons.gui.output.screens;

import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.engine.modules.Chest;
import at.gousoogames.dungeons.engine.modules.IModule;
import at.gousoogames.dungeons.engine.world.Room;
import at.gousoogames.dungeons.gui.output.actors.AbstractModuleActor;
import at.gousoogames.dungeons.gui.output.actors.ChestModuleActor;
import at.gousoogames.dungeons.gui.output.actors.EnemyModuleActor;
import at.gousoogames.dungeons.gui.output.tools.RoomRenderer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;

public abstract class AbstractRoomScreen extends AbstractScreen {

	public Room room;
	Texture background;
	AbstractModuleActor[] moduleActors;
	
	public AbstractRoomScreen(Game gameApplication, Room room) {
		super(gameApplication);
		this.room = room;
		background = RoomRenderer.renderRoom(room);
		
		moduleActors = new AbstractModuleActor[room.getNumberModules()];
		for (int i = 0; i < room.getNumberModules(); i++){
			IModule mod = room.getModules()[i];
			if (mod instanceof Enemy) moduleActors[i] = new EnemyModuleActor(mod, 100 + (i*150), 200);
			else if (mod instanceof Chest) moduleActors[i] = new ChestModuleActor(mod,100 + (i*150), 200);
			else continue;
			stage.addActor(moduleActors[i]);
		}
	}

}
