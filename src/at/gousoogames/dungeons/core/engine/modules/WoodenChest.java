package at.gousoogames.dungeons.core.engine.modules;

import at.gousoogames.dungeons.core.engine.gameitems.Item;

public class WoodenChest extends Chest {

	public WoodenChest(int size){
		this.name = "WoodenChest";
		this.items = new Item[size];
		this.size = size;
		this.generateItems();
	}
	
}
