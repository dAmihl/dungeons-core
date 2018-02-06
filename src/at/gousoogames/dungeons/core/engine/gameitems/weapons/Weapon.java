package at.gousoogames.dungeons.core.engine.gameitems.weapons;

import at.gousoogames.dungeons.core.engine.gameitems.Equipable;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.gameitems.WeaponStats;

public class Weapon extends Equipable {



	public Weapon(String name, WeaponStats st, StatRequirements req) {
		super(name, req);
		this.stats = st;
	}

	private WeaponStats stats;
	
	public WeaponStats getStats(){
		return this.stats;
	}
	
	
}
