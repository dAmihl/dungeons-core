package at.gousoogames.dungeons.core.engine.world;

public class Dungeon {

	private int numRooms;
	private Room[] rooms;
	
	public Dungeon(int numRooms){
		this.numRooms = numRooms;
		rooms = new Room[numRooms];
		generateRooms();
	}
	
	private void generateRooms(){
		for (int i = 0; i < numRooms; i++){
			rooms[i] = RoomGenerator.generate();
		}
	}

	public int getNumRooms() {
		return numRooms;
	}

	public Room[] getRooms() {
		return rooms;
	}
	
	
	
	
}
