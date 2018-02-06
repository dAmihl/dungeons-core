package at.gousoogames.dungeons.engine.modules;

import at.gousoogames.dungeons.engine.gameitems.Item;

public class IronChest extends Chest {

	public IronChest(int size){
		this.name = "IronChest";
		this.items = new Item[size];
		this.size = size;
		this.generateItems();
	}
	
	
}
