package at.gousoogames.dungeons.engine.gameitems;

public class Item {

	public static final Item EMPTY_ITEM = new Item("empty");
	
	private String itemName;
	private StatRequirements statRequirement;
	protected int goldValue = 10; //TODO gold value of items
	
	public Item(String name){
		this.itemName = name;
		this.statRequirement = StatRequirements.emptyRequirement;
	}
	
	public Item(String name, StatRequirements req){
		this.itemName = name;
		this.statRequirement = req;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public StatRequirements getStatRequirements(){
		return statRequirement;
	}
	
	protected void setStatRequirements(StatRequirements req){
		this.statRequirement = req;
	}
	
	public int getGoldValue(){
		return goldValue;
	}
	
}
