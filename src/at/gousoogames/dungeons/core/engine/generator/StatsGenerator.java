package at.gousoogames.dungeons.core.engine.generator;


import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.gameitems.WeaponStats;
import at.gousoogames.dungeons.core.game.game.Game;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;

public class StatsGenerator {

	public static CharacterStats generateCharacterStats(){
		int s_vit = GamemodeManager.getGamemode().getGenerationConfig().getSTATS_START_VITALITY(); 
		int s_str = GamemodeManager.getGamemode().getGenerationConfig().getSTATS_START_STRENGTH(); 
		int s_agi = GamemodeManager.getGamemode().getGenerationConfig().getSTATS_START_AGILITY(); 
		int s_int = GamemodeManager.getGamemode().getGenerationConfig().getSTATS_START_INTELLIGENCE(); 
		int s_arm = GamemodeManager.getGamemode().getGenerationConfig().getSTATS_START_ARMOR();

		int envLevel = Game.getGameManager().getEnvironmentLevel();
		float randomFactor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_STAT_FACTOR_TO_PLEVEL_MAX());
		int extrapoints = (int) (envLevel * randomFactor);
		
		for (int i = 0; i < extrapoints; i++){
			int rand = RandomNumberGenerator.getRandomNumberBetween(1, 5);
			switch(rand){
				case 1: s_vit++; break;
				case 2: s_str++; break;
				case 3: s_agi++; break;
				case 4: s_int++; break;
				case 5: s_arm++; break;
			}
		}
		
		return new CharacterStats(s_arm,s_vit, s_str, s_agi, s_int);
	}
	
	private static float itemRarityRandomFactor(int rarity){
		float factor = 0f;
		switch (rarity){
		case 0: factor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MAX()); break;
				
		case 1: factor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_RARE_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_RARE_STAT_FACTOR_TO_PLEVEL_MAX()); break;
		case 2: factor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MAX()); break;
		case 3: factor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MAX()); break;
		
		default: factor = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MAX()); break;
				
		}
		return factor;
	}
	
	public static ArmorStats generateArmorStats(int rarity){
		int s_str = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_STRENGTH();
		int s_vit = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_VITALITY();
		int s_agi = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_AGILITY();
		int s_int = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_INTELLIGENCE();
		int s_arm = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_ARMOR();

		int envLevel = Game.getGameManager().getEnvironmentLevel();
		float randomFactor = itemRarityRandomFactor(rarity);
		int extrapoints = (int) (envLevel * randomFactor);
		
		for (int i = 0; i < extrapoints; i++){
			int rand = RandomNumberGenerator.getRandomNumberBetween(1, 5);
			switch(rand){
				case 1: s_vit++; break;
				case 2: s_str++; break;
				case 3: s_agi++; break;
				case 4: s_int++; break;
				case 5: s_arm++; break;
			}
		}
		
		return new ArmorStats(s_arm, s_vit, s_str, s_agi, s_int);
	}
	
	public static WeaponStats generateWeaponStats(int rarity){
		ArmorStats s = generateArmorStats(rarity);
		int weapDmg = GamemodeManager.getGamemode().getGenerationConfig().getITEM_STATS_MIN_WEAPONDMG();
		
		int envLevel = Game.getGameManager().getEnvironmentLevel();
		float randomFactor = itemRarityRandomFactor(rarity);
		int dmg = (int) (weapDmg * (envLevel * randomFactor));
		
		return new WeaponStats(s.getArmor(),s.getVitality(), s.getStrength(), s.getAgility(), s.getIntelligence(), dmg);
	}
	
	public static StatRequirements generateEnemyEquipmentStatRequirements(CharacterStats e){
		return new StatRequirements(e.getStrength(), e.getVitality(), e.getAgility(), e.getIntelligence());
		//TODO
	}
	
	public static StatRequirements generateItemStatRequirements(){
		return new StatRequirements(1,1,1,1); // TODO
	}
	
	
}
