package at.gousoogames.dungeons.core.engine.modules;


import java.util.Arrays;

import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.generator.ItemGenerator;
import at.gousoogames.dungeons.core.gui.output.controller.Debug;

public class Chest implements IModule{

	protected String name = "Chest";
	protected Item[] items;
	protected int size;
	
	
	public String getName(){
		return name;
	}
	
	protected void generateItems(){
		for (int i = 0; i < this.size; i++){
			items[i] = ItemGenerator.generate();
		}
	}
	
	public int getSize(){
		return this.size;
	}
	
	public Item[] getItems(){
		return items;
	}
	
	public Item takeItem(Item i){
		if (i == Item.EMPTY_ITEM){
			Debug.log("Selected Item is empty in Chest: "+i);
		}
		int indexOfItem = Arrays.asList(this.items).indexOf(i);
		if (indexOfItem == -1){
			Debug.log("Item not found in Chest: "+i);
		}
		Item tookItem = this.items[indexOfItem];
		this.items[indexOfItem] = Item.EMPTY_ITEM;
		return tookItem;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
