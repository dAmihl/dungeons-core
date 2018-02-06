package at.gousoogames.dungeons.core.engine.gameitems.usables;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.skills.Effect;
import at.gousoogames.dungeons.core.engine.skills.EffectMethod;

public class ManapotUsable extends PotUsable {
	
	public ManapotUsable(String name, final int points, int duration) {
		super(name, new Effect(name, duration, new EffectMethod(){

			@Override
			public void activateEffect(GameCharacter c) {
				c.giveMana(points);
			}
			
		}));
		effectPoints = points;
		effectDuration = duration;

}
}
