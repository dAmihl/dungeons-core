package at.gousoogames.dungeons.core.engine.gameitems.armor;

import at.gousoogames.dungeons.core.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.core.engine.gameitems.Equipable;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;

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
