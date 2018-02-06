package at.gousoogames.dungeons.engine.world;

public class DungeonManager {

	private Dungeon dungeon;
	private Room currentRoom;
	private int currentRoomIndex;
	
	public DungeonManager(){
		
	}
	
	public Dungeon getDungeon(){
		return dungeon;
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public void startDungeon(Dungeon d){
		this.dungeon = d;
		this.currentRoom = d.getRooms()[0];
		this.currentRoomIndex = 0;
	}
	
	public boolean nextRoom(){
		if (this.currentRoomIndex < dungeon.getNumRooms()-1){
			this.currentRoomIndex ++;
			this.currentRoom = dungeon.getRooms()[currentRoomIndex];
			return true;
		}else{
			return false;
		}
	}

}
