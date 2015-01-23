package at.gousoogames.dungeons.engine.generator;

import at.gousoogames.dungeons.engine.skills.Skill;
import at.gousoogames.dungeons.engine.skills.SkillFactory;

public class SkillGenerator {

	
	public static Skill generate(){
		
		int rand = RandomNumberGenerator.getRandomNumberBetween(0, SkillFactory.getSkillPool().size());
		
		Skill sk = null;
		
		Class<? extends Skill> s = SkillFactory.getSkillPool().get(rand);
		try {
			sk = s.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return sk;
	}
	
}
