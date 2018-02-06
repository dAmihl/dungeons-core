package at.gousoogames.dungeons.core.engine.modules;

import at.gousoogames.dungeons.core.engine.gameitems.Item;

public class IronChest extends Chest {

	public IronChest(int size){
		this.name = "IronChest";
		this.items = new Item[size];
		this.size = size;
		this.generateItems();
	}
	
	
}
