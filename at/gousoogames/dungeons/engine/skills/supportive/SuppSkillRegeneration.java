package at.gousoogames.dungeons.engine.skills.supportive;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.engine.skills.EffectMethod;
import at.gousoogames.dungeons.engine.skills.SkillOnUse;
import at.gousoogames.dungeons.engine.skills.effects.SkillEffect;
import at.gousoogames.dungeons.gui.output.Debug;

public class SuppSkillRegeneration extends SupportiveSkill{

	protected static  String STD_NAME = "Regeneration";
	protected static  int STD_REQUIREMENT_STR = 2;
	protected static  int STD_REQUIREMENT_INT = 8;
	protected static  int STD_REQUIREMENT_VIT = 8;
	protected static  int STD_REQUIREMENT_AGI = 2;
	protected static  StatRequirements STD_REQUS = new StatRequirements(
			STD_REQUIREMENT_STR, STD_REQUIREMENT_VIT, STD_REQUIREMENT_AGI, STD_REQUIREMENT_INT); 
	
	
	private SkillOnUse useMethod = new SkillOnUse(){

		@Override
		public void onUse(GameCharacter c) {
				c.getBuffs().addBuff(getSkillEffect());							
		}
		
	};
	
	
	public SuppSkillRegeneration() {
		super(STD_NAME, STD_REQUS,SkillEffect.EMPTY_SKILL_EFFECT);
		
		onUse = useMethod;
		
		DAMAGE_RANGE_IN_PERCENT = 10;
		
		INIT_DAMAGE = 5;
		
		INIT_MANA_COST = 10;
		MANA_COST_LEVEL_SCALE = 0.5f;
		
		PHYSICAL_DAMAGE_PERCENTAGE	= 0;
		MAGICAL_DAMAGE_PERCENTAGE = 0;
		
		AGILITY_SCALE = 0f;
		STRENGTH_SCALE	= 0f;
		VITALITY_SCALE	= 0.7f;
		INTELLIGENCE_SCALE	= 0.8f;
		WEAPON_DMG_SCALE	= 0f;
		
		INIT_DAMAGE_LEVEL_BONUS = 1f;
		AGILITY_SCALE_LEVEL_BONUS = 0.1f;
		STRENGTH_SCALE_LEVEL_BONUS = 0.1f;
		VITALITY_SCALE_LEVEL_BONUS = 0.4f;
		INTELLIGENCE_SCALE_LEVEL_BONUS = 0.5f;
		WEAPON_DMG_LEVEL_BONUS	= 0f;
		
		
		SKILL_EFFECT_INIT_DAMAGE = 3;
		SKILL_EFFECT_DURATION = 3;
		SKILL_EFFECT_DURATION_LEVEL_BONUS = 0.1f;
		SKILL_EFFECT_DAMAGE_LEVEL_BONUS = 0.4f;
		
	}
	
	
	public SkillEffect newSkillEffectInstance(){
		SkillEffect eff = new SkillEffect("Regeneration", computeSkillEffectDuration(), new EffectMethod() {
			
			@Override
			public void activateEffect(GameCharacter c) {
				
				int heal = computeSkillEffectDamage();
				c.giveHeal(heal);
				Debug.log(c+" gets "+heal+" effect heal from : "+this);
			}
		});
		return eff;
	}

}
