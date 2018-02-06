package at.gousoogames.dungeons.core.engine.skills.magical;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.skills.EffectMethod;
import at.gousoogames.dungeons.core.engine.skills.effects.SkillEffect;
import at.gousoogames.dungeons.gdx.gui.output.controller.Debug;

public class MagSkillFirestorm extends MagicalSkill{

	protected  static String STD_NAME = "Firestorm";
	protected  static int STD_REQUIREMENT_STR = 2;
	protected  static int STD_REQUIREMENT_INT = 12;
	protected  static int STD_REQUIREMENT_VIT = 4;
	protected  static int STD_REQUIREMENT_AGI = 2;
	protected  static StatRequirements STD_REQUS = new StatRequirements(
			STD_REQUIREMENT_STR, STD_REQUIREMENT_VIT, STD_REQUIREMENT_AGI, STD_REQUIREMENT_INT); 
	
	
	

	public MagSkillFirestorm() {
		super(STD_NAME, STD_REQUS,SkillEffect.EMPTY_SKILL_EFFECT);
		
		
		DAMAGE_RANGE_IN_PERCENT = 10;
		
		INIT_DAMAGE = 5;
		
		INIT_MANA_COST = 10;
		MANA_COST_LEVEL_SCALE = 1f;
		
		MULTI_TARGET_SKILL = true;
		
		PHYSICAL_DAMAGE_PERCENTAGE	= 0;
		MAGICAL_DAMAGE_PERCENTAGE = 100;
		
		AGILITY_SCALE = 0f;
		STRENGTH_SCALE	= 0.1f;
		VITALITY_SCALE	= 0.2f;
		INTELLIGENCE_SCALE	= 0.5f;
		WEAPON_DMG_SCALE	= 1f;
		
		INIT_DAMAGE_LEVEL_BONUS = 1f;
		AGILITY_SCALE_LEVEL_BONUS = 0f;
		STRENGTH_SCALE_LEVEL_BONUS = 0f;
		VITALITY_SCALE_LEVEL_BONUS = 0.1f;
		INTELLIGENCE_SCALE_LEVEL_BONUS = 0.3f;
		WEAPON_DMG_LEVEL_BONUS	= 0.5f;
		
		
		SKILL_EFFECT_INIT_DAMAGE = 2;
		SKILL_EFFECT_DURATION = 2;
		SKILL_EFFECT_DURATION_LEVEL_BONUS = 0.1f;
		SKILL_EFFECT_DAMAGE_LEVEL_BONUS = 0.5f;	
		
	}
	
	
	public SkillEffect newSkillEffectInstance(){
		SkillEffect eff = new SkillEffect("Burning", computeSkillEffectDuration(), new EffectMethod() {
			
			@Override
			public void activateEffect(GameCharacter c) {
				
				int damage = computeSkillEffectDamage();
				c.giveMagicalDamage(getCharacter(), damage);
				Debug.log(c.getCharacterName()+" gets "+damage+" effect damage from : "+this);
			}
		});
		return eff;
	}
	
}
