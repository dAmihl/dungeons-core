package at.gousoogames.dungeons.core.engine.skills.physical;

import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.skills.effects.SkillEffect;

public class PhySkillWhirlwind extends PhysicalSkill {

	protected static  String STD_NAME = "Whirlwind";
	protected static  int STD_REQUIREMENT_STR = 10;
	protected static  int STD_REQUIREMENT_INT = 2;
	protected static  int STD_REQUIREMENT_VIT = 4;
	protected static  int STD_REQUIREMENT_AGI = 6;
	protected static  StatRequirements STD_REQUS = new StatRequirements(
			STD_REQUIREMENT_STR, STD_REQUIREMENT_VIT, STD_REQUIREMENT_AGI, STD_REQUIREMENT_INT); 
	
	
	public PhySkillWhirlwind() {
		super(STD_NAME, STD_REQUS,SkillEffect.EMPTY_SKILL_EFFECT);
		
		MULTI_TARGET_SKILL = true;
		
		DAMAGE_RANGE_IN_PERCENT = 20;
		
		INIT_DAMAGE = 7;
		
		INIT_MANA_COST = 5;
		MANA_COST_LEVEL_SCALE = 0.1f;
		
		PHYSICAL_DAMAGE_PERCENTAGE	= 100;
		MAGICAL_DAMAGE_PERCENTAGE = 0;
		
		AGILITY_SCALE = 0.2f;
		STRENGTH_SCALE	= 0.6f;
		VITALITY_SCALE	= 0.1f;
		INTELLIGENCE_SCALE	= 0f;
		WEAPON_DMG_SCALE	= 0.8f;
		
		INIT_DAMAGE_LEVEL_BONUS = 1f;
		AGILITY_SCALE_LEVEL_BONUS = 0.1f;
		STRENGTH_SCALE_LEVEL_BONUS = 0.5f;
		VITALITY_SCALE_LEVEL_BONUS = 0.1f;
		INTELLIGENCE_SCALE_LEVEL_BONUS = 0f;
		WEAPON_DMG_LEVEL_BONUS	= 0.6f;
		
		
		SKILL_EFFECT_INIT_DAMAGE = 0;
		SKILL_EFFECT_DURATION = 0;
		SKILL_EFFECT_DURATION_LEVEL_BONUS = 0f;
		SKILL_EFFECT_DAMAGE_LEVEL_BONUS = 0f;	
	}

}
