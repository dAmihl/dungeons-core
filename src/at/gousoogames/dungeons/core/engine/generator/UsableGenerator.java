package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.gameitems.usables.HealpotUsable;
import at.gousoogames.dungeons.core.engine.gameitems.usables.ManapotUsable;
import at.gousoogames.dungeons.core.engine.gameitems.usables.SkillPergament;
import at.gousoogames.dungeons.core.engine.gameitems.usables.Usable;
import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class UsableGenerator {

	public static Usable generateUsable(int rarity){
		
		int rangePotMin = 0;
		int rangePotMax = rangePotMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_CHANCE();
		int rangeSkillMin = rangePotMax + 1;
		int rangeSkillMax = rangeSkillMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_PERGAMENT_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangePotMin, rangePotMax)){
			return generatePot(rarity);
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeSkillMin, rangeSkillMax)){
			return generateSkillPergament(rarity);
		}else{
			return generatePot(rarity);
		}
	}
	
	public static Usable generatePot(int rarity){
		String name = NameGenerator.generateHealpotName(rarity);
		int effectValue = 0;
		int duration = 0;
		
		switch(rarity){
		case 0: 
			effectValue = RandomNumberGenerator.getRandomNumberBetween(
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MIN_VALUE(),
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MAX_VALUE());
			duration =  RandomNumberGenerator.getRandomNumberBetween(
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MIN_DURATION(),
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MAX_DURATION());
			break;
		case 1: effectValue = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_RARE_MIN_VALUE(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_RARE_MAX_VALUE());
				duration =  RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_RARE_MIN_DURATION(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_RARE_MAX_DURATION());break;
		case 2: 
			effectValue = RandomNumberGenerator.getRandomNumberBetween(
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_EPIC_MIN_VALUE(),
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_EPIC_MAX_VALUE());
			duration =  RandomNumberGenerator.getRandomNumberBetween(
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_EPIC_MIN_DURATION(),
					GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_EPIC_MAX_DURATION());break;
		case 3: effectValue = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_LEGENDARY_MIN_VALUE(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_LEGENDARY_MAX_VALUE());
				duration =  RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_LEGENDARY_MIN_DURATION(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_LEGENDARY_MAX_DURATION());break;
		default:effectValue = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MIN_VALUE(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MAX_VALUE());
				duration =  RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MIN_DURATION(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_POT_NORMAL_MAX_DURATION());break;
		}
		
		int rangeHealpotMin = 0;
		int rangeHealpotMax = rangeHealpotMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_HEALPOT_CHANCE();
		int rangeManapotMin = rangeHealpotMax + 1;
		int rangeManapotMax = rangeManapotMin + GamemodeManager.getGamemode().getGenerationConfig().getITEM_USABLE_MANAPOT_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeHealpotMin, rangeHealpotMax)) 
			return new HealpotUsable(name, effectValue, duration);
		else if (RandomNumberGenerator.checkNumberBetween(rand, rangeManapotMin, rangeManapotMax))
			return new ManapotUsable(name, effectValue, duration);
		else
			return new HealpotUsable(name, effectValue, duration);
	}
	
	
	
	private static SkillPergament generateSkillPergament(int rarity){
		Skill sk = SkillGenerator.generate();
		return new SkillPergament("Pergament: "+sk.getSkillName(), sk);
	}
	
	
}
