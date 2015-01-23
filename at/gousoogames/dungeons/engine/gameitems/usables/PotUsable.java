package at.gousoogames.dungeons.engine.gameitems.usables;

import at.gousoogames.dungeons.engine.skills.Effect;

public class PotUsable extends StackableUsable {

	protected int effectPoints = 0;
	protected int effectDuration = 0;
	
	public PotUsable(String name, Effect eff) {
		super(name, eff);
	}

}
