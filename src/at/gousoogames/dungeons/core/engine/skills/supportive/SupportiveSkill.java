package at.gousoogames.dungeons.core.engine.skills.supportive;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.engine.skills.SkillOnUse;
import at.gousoogames.dungeons.core.engine.skills.effects.SkillEffect;

public class SupportiveSkill extends Skill{

	public SupportiveSkill(String name, StatRequirements req, SkillEffect eff) {
		super(name, req, eff);
		this.onUse = new SkillOnUse(){

			@Override
			public void onUse(GameCharacter c) {
				c.getBuffs().addBuff(newSkillEffectInstance());
			}
			
		};
	}
	
	
	
	
}
