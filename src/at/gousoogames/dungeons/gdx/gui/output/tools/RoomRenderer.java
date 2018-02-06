package at.gousoogames.dungeons.gdx.gui.output.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import at.gousoogames.dungeons.core.engine.world.Room;

public class RoomRenderer {

	public static Texture renderRoom(Room r){
		return new Texture(Gdx.files.internal("small_room_1.png"));
	}
	
}
