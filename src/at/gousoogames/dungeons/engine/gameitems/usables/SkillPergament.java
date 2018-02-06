package at.gousoogames.dungeons.engine.gameitems.usables;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Effect;
import at.gousoogames.dungeons.engine.skills.EffectMethod;
import at.gousoogames.dungeons.engine.skills.Skill;

public class SkillPergament extends StackableUsable {

	private Skill skill;
	
	public SkillPergament(String name, Skill s) {
		super(name, new Effect(name, 0, new EffectMethod(){

			@Override
			public void activateEffect(GameCharacter c) {
			}
			
		}));
		this.setSkill(s);
		this.onUse = new UsableOnUse() {
			
			@Override
			public void onUse(GameCharacter c) {
				c.getBuffs().addBuff(usableEffect);
				c.learnSkill(skill);
			}
		};
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
