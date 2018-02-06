package at.gousoogames.dungeons.engine.modules;

import at.gousoogames.dungeons.engine.gameitems.Item;

public class MagicChest extends Chest {

	public MagicChest(int size){
		this.name = "MagicChest";
		this.items = new Item[size];
		this.size = size;
		this.generateItems();
	}
	
}
