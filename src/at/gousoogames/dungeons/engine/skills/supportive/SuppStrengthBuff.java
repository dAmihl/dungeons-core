package at.gousoogames.dungeons.engine.skills.supportive;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.engine.skills.EffectMethod;
import at.gousoogames.dungeons.engine.skills.effects.SkillEffect;

public class SuppStrengthBuff extends SupportiveSkill {


	protected static  String STD_NAME = "Extra Strength";
	protected static  int STD_REQUIREMENT_STR = 10;
	protected static  int STD_REQUIREMENT_INT = 10;
	protected static  int STD_REQUIREMENT_VIT = 2;
	protected static  int STD_REQUIREMENT_AGI = 2;
	protected static  StatRequirements STD_REQUS = new StatRequirements(
			STD_REQUIREMENT_STR, STD_REQUIREMENT_VIT, STD_REQUIREMENT_AGI, STD_REQUIREMENT_INT); 
	
	
	
	public SuppStrengthBuff() {
		super(STD_NAME, STD_REQUS,SkillEffect.EMPTY_SKILL_EFFECT);
		
		DAMAGE_RANGE_IN_PERCENT = 10;
		
		INIT_DAMAGE = 0;
		
		INIT_MANA_COST = 10;
		MANA_COST_LEVEL_SCALE = 0.5f;
		
		PHYSICAL_DAMAGE_PERCENTAGE	= 0;
		MAGICAL_DAMAGE_PERCENTAGE = 0;
		
		AGILITY_SCALE = 0f;
		STRENGTH_SCALE	= 0f;
		VITALITY_SCALE	= 0.7f;
		INTELLIGENCE_SCALE	= 0.8f;
		WEAPON_DMG_SCALE	= 0f;
		
		INIT_DAMAGE_LEVEL_BONUS = 0f;
		AGILITY_SCALE_LEVEL_BONUS = 0.1f;
		STRENGTH_SCALE_LEVEL_BONUS = 0.1f;
		VITALITY_SCALE_LEVEL_BONUS = 0.4f;
		INTELLIGENCE_SCALE_LEVEL_BONUS = 0.5f;
		WEAPON_DMG_LEVEL_BONUS	= 0f;
		
		
		SKILL_EFFECT_INIT_DAMAGE = 10;
		SKILL_EFFECT_DURATION = 10;
		SKILL_EFFECT_DURATION_LEVEL_BONUS = 0.1f;
		SKILL_EFFECT_DAMAGE_LEVEL_BONUS = 0f;
		
	}
	
	
	public SkillEffect newSkillEffectInstance(){
		SkillEffect eff = new SkillEffect("Extra Strength", computeSkillEffectDuration(), new EffectMethod() {
			
			@Override
			public void activateEffect(GameCharacter c) {
				
			}
		});
		eff.getStats().addBaseStrength(computeSkillEffectDamage());
		return eff;
	}
	
}
