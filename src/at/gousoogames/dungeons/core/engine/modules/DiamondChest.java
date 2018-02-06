package at.gousoogames.dungeons.core.engine.modules;

import at.gousoogames.dungeons.core.engine.gameitems.Item;

public class DiamondChest extends Chest {

	public DiamondChest(int size){
		this.name = "DiamondChest";
		this.items = new Item[size];
		this.size = size;
		this.generateItems();
	}
	
}
