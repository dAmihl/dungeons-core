package at.gousoogames.dungeons.engine.gameitems.armor;

import at.gousoogames.dungeons.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.engine.gameitems.Equipable;
import at.gousoogames.dungeons.engine.gameitems.StatRequirements;

public class Armor extends Equipable {

	private ArmorStats stats;
	
	public Armor(String name, ArmorStats st, StatRequirements req){
		super(name, req);
		this.stats = st;
	}
	
	
	public ArmorStats getStats(){
		return this.stats;
	}
	
}
