package at.gousoogames.dungeons.engine.skills;

import java.util.ArrayList;

import at.gousoogames.dungeons.engine.skills.magical.MagSkillFireball;
import at.gousoogames.dungeons.engine.skills.magical.MagSkillFirestorm;
import at.gousoogames.dungeons.engine.skills.magical.MagicalSkill;
import at.gousoogames.dungeons.engine.skills.physical.PhySkillNormalAttack;
import at.gousoogames.dungeons.engine.skills.physical.PhySkillWhirlwind;
import at.gousoogames.dungeons.engine.skills.physical.PhysicalSkill;
import at.gousoogames.dungeons.engine.skills.supportive.SuppSkillHeal;
import at.gousoogames.dungeons.engine.skills.supportive.SuppSkillRegeneration;
import at.gousoogames.dungeons.engine.skills.supportive.SuppStrengthBuff;
import at.gousoogames.dungeons.engine.skills.supportive.SupportiveSkill;



public class SkillFactory {
	
	private static ArrayList<Class<? extends Skill>> skillPool = null;
	
	
	private static void init(){
		
		skillPool = new ArrayList<Class<? extends Skill>>();

		
		skillPool.add(MagSkillFirestorm.class);
		skillPool.add(MagSkillFireball.class);
		skillPool.add(PhySkillNormalAttack.class);
		skillPool.add(PhySkillWhirlwind.class);
		skillPool.add(SuppSkillHeal.class);
		skillPool.add(SuppSkillRegeneration.class);
		skillPool.add(SuppStrengthBuff.class);
	}
	
	
	public static ArrayList<Class <? extends Skill>> getSkillPool(){
		if (skillPool == null) init();
		return skillPool;
	}
	
	

	

	public static PhysicalSkill getNewPhysicalNormalAttack(){
		return new PhySkillNormalAttack();
	}
	
	public static MagicalSkill getNewMagicalFireball(){
		return new MagSkillFireball();
	}
	
	public static PhysicalSkill getNewPhysicalWhirlwind(){
		return new PhySkillWhirlwind();
	}
	
	public static SupportiveSkill getNewSupportiveHeal(){
		return new SuppSkillHeal();
	}
	
	public static MagicalSkill getNewMagicalFirestorm(){
		return new MagSkillFirestorm();
	}
	
	public static SupportiveSkill getNewStrengthBuff(){
		return new SuppStrengthBuff();
	}
	
	
}
