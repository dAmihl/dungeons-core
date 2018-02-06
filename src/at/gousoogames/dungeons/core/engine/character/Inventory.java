package at.gousoogames.dungeons.core.engine.character;


import at.gousoogames.dungeons.core.engine.gameitems.Item;

public class Inventory {

	private final static int INVENTORY_STD_SIZE = 30;
	
	Item[] inventory;
	private int size;
	private int gold;
	
	public Inventory(){
		this.inventory = new Item[INVENTORY_STD_SIZE];
		this.size = INVENTORY_STD_SIZE;
		initArray();
		gold = 0;
	}
	
	public Inventory(int size){
		this.inventory = new Item[size];
		this.size = size;
		initArray();
	}
	

	
	private void initArray(){
		for (int n = 0; n < this.size; n++)
			this.inventory[n] = Item.EMPTY_ITEM;
	}
	
	public boolean addItem(Item i){
		int n = 0;
		while (n < this.size && this.inventory[n] != Item.EMPTY_ITEM) n++;
		if (n >= this.size) return false;
		else {
			this.inventory[n] = i;
			return true;
		}
		
	}
	
	public void swapItems(Item old, Item newI){
		for (int i = 0; i < this.size; i++){
			if (inventory[i] == old) inventory[i] = newI;
		}
	}
	
	public void removeItem(Item it){
		for (int i = 0; i < this.size; i++){
			if (inventory[i] == it) inventory[i] = Item.EMPTY_ITEM;
		}
	}
	
	public Item[] getInventoryArray(){
		return this.inventory;
	}
	
	
	public int getCurrentGold(){
		return gold;
	}
	
	public void addGold(int goldV){
		this.gold += goldV;
	}
	
	public boolean takeGold(int gold){
		if (this.gold < gold) return false;
		this.gold -= gold;
		return true;
	}
}
