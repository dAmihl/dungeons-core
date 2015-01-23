package at.gousoogames.dungeons.engine.generator;

import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.engine.gameitems.armor.AmuletArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.BreastArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.FootArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.HeadArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.LegArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.RingArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.ShoulderArmor;
import at.gousoogames.dungeons.engine.gameitems.weapons.TwoHandWeapon;
import at.gousoogames.dungeons.engine.gameitems.weapons.Weapon;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;

public class EquipmentGenerator {

	public static Enemy generateEnemyEquipment(Enemy e){
		
		generateHead(e);
		generateShoulder(e);
		generateBreast(e);
		generateLegs(e);
		generateShoes(e);
		generateRing(e);
		generateRing(e);
		generateAmulet(e);
		generateWeapon(e);
		
		
		return e;
	}
	
	private static int getItemRarity(){
		return 0;
//		return ItemGenerator.getItemRarity();
	}
	
	
	private static void generateHead(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_HEAD_CHANCE())){

			HeadArmor a = ArmorGenerator.generateHeadArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateShoulder(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_SHOULDER_CHANCE())){

			ShoulderArmor a = ArmorGenerator.generateShoulderArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateBreast(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_CHEST_CHANCE())){

			BreastArmor a = ArmorGenerator.generateBreastArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateLegs(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_LEGS_CHANCE())){

			LegArmor a = ArmorGenerator.generateLegArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateShoes(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_SHOES_CHANCE())){

			FootArmor a = ArmorGenerator.generateFootArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateRing(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_RING1_CHANCE()) ||
				RandomNumberGenerator.checkNumberBetween(rand, 0, GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_RING2_CHANCE())){

			RingArmor a = ArmorGenerator.generateRingArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateAmulet(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();

		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_SHOES_CHANCE())){
			
			AmuletArmor a = ArmorGenerator.generateAmuletArmor(getItemRarity());
			a.setStatRequirementForNPC(e);
			e.equipItem(a);
		}
	}
	
	private static void generateWeapon(Enemy e){
		int rand = RandomNumberGenerator.getRandomNumberPercentage();
		Weapon w = null;
		if (RandomNumberGenerator.checkNumberBetween(rand, 0, 
				GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_RIGHTHAND_CHANCE())){
			w = WeaponGenerator.generateMainHandWeapon(getItemRarity());
			w.setStatRequirementForNPC(e);
			e.equipItem( w);
		}
		if (RandomNumberGenerator.checkNumberBetween(RandomNumberGenerator.getRandomNumberPercentage(), 
				0, GamemodeManager.getGamemode().getGenerationConfig().getENEMY_EQUIPMENT_LEFTHAND_CHANCE())
				&& (w != null) && !(w instanceof TwoHandWeapon)){
			w = WeaponGenerator.generateWeapon(getItemRarity());
			w.setStatRequirementForNPC(e);
			e.equipItem( w);
		}
	}
	
	
	
}
