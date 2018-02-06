package at.gousoogames.dungeons.core.engine.skills;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;

public interface EffectMethod {

	public final static EffectMethod EMPTY_EFFECT_METHOD = new EffectMethod(){

		@Override
		public void activateEffect(GameCharacter c) {			
		}};
	
	public void activateEffect(GameCharacter c);
	
}
