package at.gousoogames.dungeons.engine.gameitems.usables;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Effect;
import at.gousoogames.dungeons.engine.skills.EffectMethod;

public class HealpotUsable extends PotUsable {

	
	public HealpotUsable(String name, final int points, int duration) {
		super(name, new Effect(name, duration, new EffectMethod(){

			@Override
			public void activateEffect(GameCharacter c) {
				c.giveHealth(points);
			}
			
		}));
		effectPoints = points;
		effectDuration = duration;

	}


	
	
}
