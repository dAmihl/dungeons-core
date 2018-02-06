package at.gousoogames.dungeons.gui.output.tools;

import at.gousoogames.dungeons.engine.world.Room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RoomRenderer {

	public static Texture renderRoom(Room r){
		return new Texture(Gdx.files.internal("small_room_1.png"));
	}
	
}
