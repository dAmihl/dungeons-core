package at.gousoogames.dungeons.engine.skills;

import at.gousoogames.dungeons.engine.character.GameCharacter;

public interface EffectMethod {

	public final static EffectMethod EMPTY_EFFECT_METHOD = new EffectMethod(){

		@Override
		public void activateEffect(GameCharacter c) {			
		}};
	
	public void activateEffect(GameCharacter c);
	
}
