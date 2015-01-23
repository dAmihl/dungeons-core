package at.gousoogames.dungeons.engine.skills.effects;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Effect;
import at.gousoogames.dungeons.engine.skills.EffectMethod;


public class SkillEffect extends Effect {

	public final static SkillEffect EMPTY_SKILL_EFFECT = new SkillEffect("", 0, new EffectMethod(){

		@Override
		public void activateEffect(GameCharacter c) {			
		}
		
	});
	
	
	public SkillEffect(String name, int duration, EffectMethod method) {
		super(name, duration, method);
	}
	
	@Override
	public SkillEffect reset(){
		this.remainingDuration = this.duration;
		return this;
	}
	
	// TODO: SKILLeffect damage computation: at casting or at creating? or at tick

}
