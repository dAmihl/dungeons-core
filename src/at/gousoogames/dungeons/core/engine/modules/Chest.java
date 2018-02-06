package at.gousoogames.dungeons.core.engine.modules;


import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.generator.ItemGenerator;

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

	@Override
	public String toString() {
		return this.name;
	}
	
}
