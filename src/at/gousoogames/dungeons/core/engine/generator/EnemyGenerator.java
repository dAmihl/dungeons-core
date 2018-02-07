package at.gousoogames.dungeons.core.engine.generator;

import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Skillset;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.BeastEnemy;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Goblin;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.HumanoidEnemy;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Skeleton;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Spider;
import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;


public class EnemyGenerator {

	// TODO: name pool, equipment generating - depending on a level ?
	// Stats generating - also level?
	// Skills
	
	public static Enemy generate(){
		
		int rangeHumanoidMin = 0;
		int rangeHumanoidMax = rangeHumanoidMin + GamemodeManager.getGamemode().getGenerationConfig().getENEMY_HUMANOID_SPAWN_CHANCE();
		int rangeBeastMin = rangeHumanoidMin + 1;
		int rangeBeastMax = rangeBeastMin + GamemodeManager.getGamemode().getGenerationConfig().getENEMY_BEAST_SPAWN_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
			
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeHumanoidMin, rangeHumanoidMax)){
			return generateHumanoid();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeBeastMin, rangeBeastMax)){
			return generateBeast();
		}else{
			return generateBeast();
		}

	}
	
	private static BeastEnemy generateBeast(){
		int rangeSpiderMin = 0;
		int rangeSpiderMax = rangeSpiderMin + GamemodeManager.getGamemode().getGenerationConfig().getENEMY_BEAST_SPIDER_SPAWN_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeSpiderMin, rangeSpiderMax)){
			return generateSpider();
		}else{
			return generateSpider();
		}
	}
	
	private static HumanoidEnemy generateHumanoid(){
		int rangeSkeletonMin = 0;
		int rangeSkeletonMax = rangeSkeletonMin + GamemodeManager.getGamemode().getGenerationConfig().getENEMY_HUMANOID_SKELETON_SPAWN_CHANCE();
		int rangeGoblinMin = rangeSkeletonMax + 1;
		int rangeGoblinMax = rangeGoblinMin + GamemodeManager.getGamemode().getGenerationConfig().getENEMY_HUMANOID_GOBLIN_SPAWN_CHANCE();
		
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		
		if (RandomNumberGenerator.checkNumberBetween(rand, rangeSkeletonMin, rangeSkeletonMax)){
			return generateSkeleton();
		}else if (RandomNumberGenerator.checkNumberBetween(rand, rangeGoblinMin, rangeGoblinMax)){
			return generateGoblin();
		}else{
			return generateSkeleton();
		}
	}
	
	
	
	private static Skeleton generateSkeleton(){
		CharacterStats stats = StatsGenerator.generateCharacterStats();
		String name = generateName(Skeleton.class);
		Skeleton e = new Skeleton(name, new Inventory(getInventorySize()), new Equipment(), new Skillset(), stats, new Buffs());
		generateInventory(e);
		generateEquipment(e);
		generateSkillset(e);
		return e;
	}
	
	private static Goblin generateGoblin(){
		CharacterStats stats = StatsGenerator.generateCharacterStats();
		String name = generateName(Goblin.class);
		Goblin e = new Goblin(name, new Inventory(getInventorySize()), new Equipment(), new Skillset(), stats, new Buffs());
		generateInventory(e);
		generateEquipment(e);
		generateSkillset(e);
		return e;
	}
	
	private static Spider generateSpider(){
		CharacterStats stats = StatsGenerator.generateCharacterStats();
		String name = generateName(Spider.class);
		Spider e = new Spider(name, new Inventory(getInventorySize()), new Skillset(), stats, new Buffs());
		generateInventory(e);
		generateSkillset(e);
		return e;
	}
	
	
	private static int getInventorySize(){
		int size = RandomNumberGenerator.getRandomNumberBetween(
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_INVENTORY_SIZE_MIN(),
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_INVENTORY_SIZE_MAX());
		return size;
	}
	
	
	@SuppressWarnings("unused")
	private static String generateName(){
		return "dummy";
	}
	
	private static String generateName(Class<? extends Enemy> EnemyClass){
		
		return EnemyClass.getSimpleName();
	}
	
	
	private static void generateInventory(Enemy e){
		for (int i = 0; i < e.getInventory().getInventoryArray().length; i++){
			e.getInventory().addItem(ItemGenerator.generate());
		}
		
	}
	
	private static void generateEquipment(Enemy e){
		EquipmentGenerator.generateEnemyEquipment(e);
	}
	
	private static void generateSkillset(Enemy e){
//		Skill s1 = SkillFactory.getNewPhysicalNormalAttack();
		Skill s1 = SkillGenerator.generate();
		s1.setCharacter(e);
		s1.addExp(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getEnvironmentLevel() * 1000);//TODO
		e.learnSkill(s1);
//		e.learnSkill(s2);
	}
	
}
