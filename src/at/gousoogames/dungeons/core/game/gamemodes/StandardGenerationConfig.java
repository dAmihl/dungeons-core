package at.gousoogames.dungeons.core.game.gamemodes;

public class StandardGenerationConfig extends GenerationConfig {

	/*Singleton mechanism */
		private static StandardGenerationConfig instance = null;
		
		private StandardGenerationConfig(){}
		
		public static StandardGenerationConfig getConfig(){
			if (instance == null) instance = new StandardGenerationConfig();
			return instance;
		}
		
		
	
		/*Config*/
		
		private  int STATS_START_VITALITY	= 10;
		private  int STATS_START_STRENGTH	= 10;
		private  int STATS_START_AGILITY	= 10;
		private  int STATS_START_INTELLIGENCE = 10;
		private  int STATS_START_ARMOR		= 10;
		
		private  int ITEM_STATS_MIN_STRENGTH = 1;
		private  int ITEM_STATS_MIN_VITALITY = 1;
		private  int ITEM_STATS_MIN_AGILITY  = 1;
		private  int ITEM_STATS_MIN_INTELLIGENCE = 1;
		private  int ITEM_STATS_MIN_WEAPONDMG = 10;
		private  int ITEM_STATS_MIN_ARMOR		= 1;

		private  int ITEM_NORMAL_DROPCHANCE		= 70;
		private  int ITEM_RARE_DROPCHANCE		= 20;
		private  int ITEM_EPIC_DROPCHANCE		= 9;
		private  int ITEM_LEGENDARY_DROPCHANCE	= 1;
		
		private  int SMALL_ROOM_CHANCE 			= 50;
		private  int MEDIUM_ROOM_CHANCE			= 30;
		private  int LARGE_ROOM_CHANCE			= 20;	
		
		private  int SMALL_ROOM_SIZE_MIN		= 2;
		private  int SMALL_ROOM_SIZE_MAX		= 3;
		private  int MEDIUM_ROOM_SIZE_MIN		= 3;
		private  int MEDIUM_ROOM_SIZE_MAX		= 4;
		private  int LARGE_ROOM_SIZE_MIN		= 4;
		private  int LARGE_ROOM_SIZE_MAX		= 5;
		private  int DUNGEON_SIZE_ROOMS_MIN 	= 3;
		private  int DUNGEON_SIZE_ROOMS_MAX		= 6;
		
		private  int WOODEN_CHEST_SIZE_MIN		= 1;
		private  int WOODEN_CHEST_SIZE_MAX		= 2;
		private  int IRON_CHEST_SIZE_MIN		= 3;
		private  int IRON_CHEST_SIZE_MAX		= 4;
		private  int MAGIC_CHEST_SIZE_MIN		= 3;
		private  int MAGIC_CHEST_SIZE_MAX		= 4;
		private  int DIAMOND_CHEST_SIZE_MIN		= 4;
		private  int DIAMOND_CHEST_SIZE_MAX		= 5;
		
		private  int ITEM_DROPCHANCE			= 90; //general dropchance for items
		private  int ITEM_ARMOR_DROPCHANCE		= 15;
		private  int ITEM_WEAPON_DROPCHANCE		= 15;
		private  int ITEM_KEY_DROPCHANCE		= 10;	
		private  int ITEM_USABLE_DROPCHANCE 	= 60;
		
		private  int ROOM_ENEMY_SPAWN_CHANCE	= 70;
		private  int ROOM_CHEST_SPAWN_CHANCE	= 30;

		private  int CHEST_WOODEN_SPAWN_CHANCE	= 50;
		private  int CHEST_IRON_SPAWN_CHANCE	= 30;
		private  int CHEST_MAGIC_SPAWN_CHANCE	= 15;
		private  int CHEST_DIAMOND_SPAWN_CHANCE	= 5;	

		private  float ENEMY_LEVEL_FACTOR_TO_PLEVEL_MIN		= 1.f;
		private  float ENEMY_LEVEL_FACTOR_TO_PLEVEL_MAX		= 1.3f;
		private  float ENEMY_STAT_FACTOR_TO_PLEVEL_MIN		= 1.3f;
		private	 float ENEMY_STAT_FACTOR_TO_PLEVEL_MAX		= 1.5f;
		private  float ITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MIN		= 1.f;
		private  float ITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MAX		= 1.5f;
		private  float ITEM_RARE_STAT_FACTOR_TO_PLEVEL_MIN			= 1.6f;
		private  float ITEM_RARE_STAT_FACTOR_TO_PLEVEL_MAX			= 2.f;
		private  float ITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MIN			= 2.1f;
		private  float ITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MAX			= 2.3f;
		private  float ITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MIN		= 2.4f;
		private  float ITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MAX		= 3.f;
		private  float STAT_REQUIREMENT_FACTOR_TO_PLEVEL_MIN	= 1.f;
		private  float STAT_REQUIREMENT_FACTOR_TO_PLEVEL_MAX	= 1.5f;
		
		
		private  int ENEMY_HUMANOID_SPAWN_CHANCE	= 40;
		private  int ENEMY_BEAST_SPAWN_CHANCE		= 60;
		private  int ENEMY_HUMANOID_SKELETON_SPAWN_CHANCE	= 50;
		private  int ENEMY_HUMANOID_GOBLIN_SPAWN_CHANCE		= 50;
		private  int ENEMY_BEAST_SPIDER_SPAWN_CHANCE	= 100;
		
		private  int ENEMY_INVENTORY_SIZE_MIN		= 1;
		private  int ENEMY_INVENTORY_SIZE_MAX		= 4;
		
		
		private  int ENEMY_EQUIPMENT_HEAD_CHANCE	= 25;
		private  int ENEMY_EQUIPMENT_SHOULDER_CHANCE = 10;
		private  int ENEMY_EQUIPMENT_CHEST_CHANCE	= 40;
		private  int ENEMY_EQUIPMENT_LEGS_CHANCE	= 50;
		private  int ENEMY_EQUIPMENT_SHOES_CHANCE	= 30;
		private  int ENEMY_EQUIPMENT_RING1_CHANCE	= 5;
		private  int ENEMY_EQUIPMENT_RING2_CHANCE	= 5;
		private  int ENEMY_EQUIPMENT_AMULET_CHANCE	= 5;
		private  int ENEMY_EQUIPMENT_RIGHTHAND_CHANCE	= 100;
		private  int ENEMY_EQUIPMENT_LEFTHAND_CHANCE	= 10;
		
		
		private int ITEM_KEY_WOODEN_CHANCE		= 55;
		private int ITEM_KEY_IRON_CHANCE		= 35;
		private int ITEM_KEY_MAGIC_CHANCE		= 9;
		private int ITEM_KEY_DIAMOND_CHANCE		= 1;
		
		private int ITEM_ARMOR_HEAD_CHANCE		= 15;
		private int ITEM_ARMOR_SHOULDER_CHANCE	= 10;
		private int ITEM_ARMOR_CHEST_CHANCE		= 15;
		private int ITEM_ARMOR_PANTS_CHANCE		= 15;
		private int ITEM_ARMOR_SHOES_CHANCE		= 15;
		private int ITEM_ARMOR_RING_CHANCE		= 15;
		private int ITEM_ARMOR_AMULET_CHANCE	= 15;

		private int ITEM_WEAPON_MAINHAND_CHANCE	= 70;
		private int ITEM_WEAPON_OFFHAND_CHANCE	= 30;
		
		private int ITEM_WEAPON_ONEHAND_CHANCE  = 50;
		private int ITEM_WEAPON_TWOHAND_CHANCE	= 50;
		
		private int ITEM_WEAPON_1H_SWORD_CHANCE	= 25;
		private int ITEM_WEAPON_1H_AXE_CHANCE	= 25;
		private int ITEM_WEAPON_1H_DAGGER_CHANCE= 25;
		private int ITEM_WEAPON_1H_MACE_CHANCE	= 25;
		
		private int ITEM_WEAPON_2H_SWORD_CHANCE	= 20;
		private int ITEM_WEAPON_2H_AXE_CHANCE	= 20;
		private int ITEM_WEAPON_2H_STAFF_CHANCE	= 20;
		private int ITEM_WEAPON_2H_MACE_CHANCE	= 20;
		private int ITEM_WEAPON_2H_BOW_CHANCE	= 20;
		
		private int ITEM_WEAPON_OH_SHIELD_CHANCE 	= 50;
		private int ITEM_WEAPON_OH_SCEPTER_CHANCE	= 50;
		
		
		private int ITEM_USABLE_POT_CHANCE			= 0;
		private int ITEM_USABLE_HEALPOT_CHANCE		= 50;
		private int ITEM_USABLE_MANAPOT_CHANCE		= 50;
		private int ITEM_USABLE_PERGAMENT_CHANCE	= 100;
		private int ITEM_USABLE_PERGAMENT_SKILL_CHANCE = 100;
		
		private float ITEM_USABLE_PERGAMENT_SKILL_MIN_LEVEL_FACTOR = 1; 
		private float ITEM_USABLE_PERGAMENT_SKILL_MAX_LEVEL_FACTOR = 2;
		private int ITEM_USABLE_POT_NORMAL_MIN_VALUE	= 30;
		private int ITEM_USABLE_POT_NORMAL_MAX_VALUE	= 50;
		private int ITEM_USABLE_POT_NORMAL_MIN_DURATION	= 1;
		private int ITEM_USABLE_POT_NORMAL_MAX_DURATION	= 2;
		private int ITEM_USABLE_POT_RARE_MIN_VALUE		= 50;
		private int ITEM_USABLE_POT_RARE_MAX_VALUE		= 70;
		private int ITEM_USABLE_POT_RARE_MIN_DURATION	= 2;
		private int ITEM_USABLE_POT_RARE_MAX_DURATION	= 3;
		private int ITEM_USABLE_POT_EPIC_MIN_VALUE		= 70;
		private int ITEM_USABLE_POT_EPIC_MAX_VALUE		= 100;
		private int ITEM_USABLE_POT_EPIC_MIN_DURATION	= 3;
		private int ITEM_USABLE_POT_EPIC_MAX_DURATION	= 4;
		private int ITEM_USABLE_POT_LEGENDARY_MIN_VALUE	= 120;
		private int ITEM_USABLE_POT_LEGENDARY_MAX_VALUE	= 150;
		private int ITEM_USABLE_POT_LEGENDARY_MIN_DURATION	= 5;
		private int ITEM_USABLE_POT_LEGENDARY_MAX_DURATION	= 6;
		
		private int ITEM_USABLE_FLASK_CHANCE	= 0;
		
		/*Getters*/
		public int getSMALL_ROOM_CHANCE() {
			return SMALL_ROOM_CHANCE;
		}

		public int getMEDIUM_ROOM_CHANCE() {
			return MEDIUM_ROOM_CHANCE;
		}

		public int getLARGE_ROOM_CHANCE() {
			return LARGE_ROOM_CHANCE;
		}

		public int getSMALL_ROOM_SIZE_MIN() {
			return SMALL_ROOM_SIZE_MIN;
		}

		public int getSMALL_ROOM_SIZE_MAX() {
			return SMALL_ROOM_SIZE_MAX;
		}

		public int getMEDIUM_ROOM_SIZE_MIN() {
			return MEDIUM_ROOM_SIZE_MIN;
		}

		public int getMEDIUM_ROOM_SIZE_MAX() {
			return MEDIUM_ROOM_SIZE_MAX;
		}

		public int getLARGE_ROOM_SIZE_MIN() {
			return LARGE_ROOM_SIZE_MIN;
		}

		public int getLARGE_ROOM_SIZE_MAX() {
			return LARGE_ROOM_SIZE_MAX;
		}

		public int getDUNGEON_SIZE_ROOMS_MIN() {
			return DUNGEON_SIZE_ROOMS_MIN;
		}

		public int getDUNGEON_SIZE_ROOMS_MAX() {
			return DUNGEON_SIZE_ROOMS_MAX;
		}

		public int getWOODEN_CHEST_SIZE_MIN() {
			return WOODEN_CHEST_SIZE_MIN;
		}

		public int getWOODEN_CHEST_SIZE_MAX() {
			return WOODEN_CHEST_SIZE_MAX;
		}

		public int getIRON_CHEST_SIZE_MIN() {
			return IRON_CHEST_SIZE_MIN;
		}

		public int getIRON_CHEST_SIZE_MAX() {
			return IRON_CHEST_SIZE_MAX;
		}

		public int getMAGIC_CHEST_SIZE_MIN() {
			return MAGIC_CHEST_SIZE_MIN;
		}

		public int getMAGIC_CHEST_SIZE_MAX() {
			return MAGIC_CHEST_SIZE_MAX;
		}

		public int getDIAMOND_CHEST_SIZE_MIN() {
			return DIAMOND_CHEST_SIZE_MIN;
		}

		public int getDIAMOND_CHEST_SIZE_MAX() {
			return DIAMOND_CHEST_SIZE_MAX;
		}

		public int getITEM_ARMOR_DROPCHANCE() {
			return ITEM_ARMOR_DROPCHANCE;
		}

		public int getITEM_WEAPON_DROPCHANCE() {
			return ITEM_WEAPON_DROPCHANCE;
		}

		public int getITEM_KEY_DROPCHANCE() {
			return ITEM_KEY_DROPCHANCE;
		}

		public int getITEM_DROPCHANCE() {
			return ITEM_DROPCHANCE;
		}

		public int getROOM_ENEMY_SPAWN_CHANCE() {
			return ROOM_ENEMY_SPAWN_CHANCE;
		}

		public int getROOM_CHEST_SPAWN_CHANCE() {
			return ROOM_CHEST_SPAWN_CHANCE;
		}

		public static StandardGenerationConfig getInstance() {
			return instance;
		}

		public int getITEM_USABLE_DROPCHANCE() {
			return ITEM_USABLE_DROPCHANCE;
		}

		public int getCHEST_WOODEN_SPAWN_CHANCE() {
			return CHEST_WOODEN_SPAWN_CHANCE;
		}

		public int getCHEST_IRON_SPAWN_CHANCE() {
			return CHEST_IRON_SPAWN_CHANCE;
		}

		public int getCHEST_MAGIC_SPAWN_CHANCE() {
			return CHEST_MAGIC_SPAWN_CHANCE;
		}

		public float getENEMY_LEVEL_FACTOR_TO_PLEVEL_MIN() {
			return ENEMY_LEVEL_FACTOR_TO_PLEVEL_MIN;
		}

		public float getENEMY_LEVEL_FACTOR_TO_PLEVEL_MAX() {
			return ENEMY_LEVEL_FACTOR_TO_PLEVEL_MAX;
		}

		public float getENEMY_STAT_FACTOR_TO_PLEVEL_MIN() {
			return ENEMY_STAT_FACTOR_TO_PLEVEL_MIN;
		}

		public float getENEMY_STAT_FACTOR_TO_PLEVEL_MAX() {
			return ENEMY_STAT_FACTOR_TO_PLEVEL_MAX;
		}

		public float getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MIN() {
			return ITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MIN;
		}

		public float getITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MAX() {
			return ITEM_NORMAL_STAT_FACTOR_TO_PLEVEL_MAX;
		}

		public float getITEM_RARE_STAT_FACTOR_TO_PLEVEL_MIN() {
			return ITEM_RARE_STAT_FACTOR_TO_PLEVEL_MIN;
		}

		public float getITEM_RARE_STAT_FACTOR_TO_PLEVEL_MAX() {
			return ITEM_RARE_STAT_FACTOR_TO_PLEVEL_MAX;
		}

		public float getITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MIN() {
			return ITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MIN;
		}

		public float getITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MAX() {
			return ITEM_EPIC_STAT_FACTOR_TO_PLEVEL_MAX;
		}

		public float getITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MIN() {
			return ITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MIN;
		}

		public float getITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MAX() {
			return ITEM_LEGENDARY_STAT_FACTOR_TO_PLEVEL_MAX;
		}

		public float getSTAT_REQUIREMENT_FACTOR_TO_PLEVEL_MIN() {
			return STAT_REQUIREMENT_FACTOR_TO_PLEVEL_MIN;
		}

		public int getSTATS_START_VITALITY() {
			return STATS_START_VITALITY;
		}

		public int getSTATS_START_STRENGTH() {
			return STATS_START_STRENGTH;
		}

		public int getSTATS_START_AGILITY() {
			return STATS_START_AGILITY;
		}

		public int getSTATS_START_INTELLIGENCE() {
			return STATS_START_INTELLIGENCE;
		}

		public float getSTAT_REQUIREMENT_FACTOR_TO_PLEVEL_MAX() {
			return STAT_REQUIREMENT_FACTOR_TO_PLEVEL_MAX;
		}

		public int getCHEST_DIAMOND_SPAWN_CHANCE() {
			return CHEST_DIAMOND_SPAWN_CHANCE;
		}


		public int getENEMY_INVENTORY_SIZE_MIN() {
			return ENEMY_INVENTORY_SIZE_MIN;
		}

		public int getENEMY_INVENTORY_SIZE_MAX() {
			return ENEMY_INVENTORY_SIZE_MAX;
		}

		public int getENEMY_HUMANOID_SPAWN_CHANCE() {
			return ENEMY_HUMANOID_SPAWN_CHANCE;
		}

		public int getENEMY_BEAST_SPAWN_CHANCE() {
			return ENEMY_BEAST_SPAWN_CHANCE;
		}

		public int getENEMY_EQUIPMENT_HEAD_CHANCE() {
			return ENEMY_EQUIPMENT_HEAD_CHANCE;
		}

		public int getENEMY_EQUIPMENT_SHOULDER_CHANCE() {
			return ENEMY_EQUIPMENT_SHOULDER_CHANCE;
		}

		public int getENEMY_EQUIPMENT_CHEST_CHANCE() {
			return ENEMY_EQUIPMENT_CHEST_CHANCE;
		}

		public int getENEMY_EQUIPMENT_LEGS_CHANCE() {
			return ENEMY_EQUIPMENT_LEGS_CHANCE;
		}

		public int getENEMY_EQUIPMENT_SHOES_CHANCE() {
			return ENEMY_EQUIPMENT_SHOES_CHANCE;
		}

		public int getENEMY_EQUIPMENT_RING1_CHANCE() {
			return ENEMY_EQUIPMENT_RING1_CHANCE;
		}

		public int getENEMY_EQUIPMENT_RING2_CHANCE() {
			return ENEMY_EQUIPMENT_RING2_CHANCE;
		}

		public int getENEMY_EQUIPMENT_AMULET_CHANCE() {
			return ENEMY_EQUIPMENT_AMULET_CHANCE;
		}

		public int getENEMY_EQUIPMENT_RIGHTHAND_CHANCE() {
			return ENEMY_EQUIPMENT_RIGHTHAND_CHANCE;
		}

		public int getENEMY_EQUIPMENT_LEFTHAND_CHANCE() {
			return ENEMY_EQUIPMENT_LEFTHAND_CHANCE;
		}

		public int getENEMY_HUMANOID_SKELETON_SPAWN_CHANCE() {
			return ENEMY_HUMANOID_SKELETON_SPAWN_CHANCE;
		}

		public int getENEMY_HUMANOID_GOBLIN_SPAWN_CHANCE() {
			return ENEMY_HUMANOID_GOBLIN_SPAWN_CHANCE;
		}

		public int getITEM_STATS_MIN_STRENGTH() {
			return ITEM_STATS_MIN_STRENGTH;
		}

		public int getITEM_STATS_MIN_VITALITY() {
			return ITEM_STATS_MIN_VITALITY;
		}

		public int getITEM_STATS_MIN_AGILITY() {
			return ITEM_STATS_MIN_AGILITY;
		}

		public int getITEM_STATS_MIN_WEAPONDMG() {
			return ITEM_STATS_MIN_WEAPONDMG;
		}

		public int getITEM_STATS_MIN_INTELLIGENCE() {
			return ITEM_STATS_MIN_INTELLIGENCE;
		}

		public int getENEMY_BEAST_SPIDER_SPAWN_CHANCE() {
			return ENEMY_BEAST_SPIDER_SPAWN_CHANCE;
		}

		public int getITEM_KEY_WOODEN_CHANCE() {
			return ITEM_KEY_WOODEN_CHANCE;
		}

		public int getITEM_KEY_IRON_CHANCE() {
			return ITEM_KEY_IRON_CHANCE;
		}

		public int getITEM_KEY_MAGIC_CHANCE() {
			return ITEM_KEY_MAGIC_CHANCE;
		}

		public int getITEM_KEY_DIAMOND_CHANCE() {
			return ITEM_KEY_DIAMOND_CHANCE;
		}

		public int getITEM_ARMOR_HEAD_CHANCE() {
			return ITEM_ARMOR_HEAD_CHANCE;
		}

		public int getITEM_ARMOR_SHOULDER_CHANCE() {
			return ITEM_ARMOR_SHOULDER_CHANCE;
		}

		public int getITEM_ARMOR_CHEST_CHANCE() {
			return ITEM_ARMOR_CHEST_CHANCE;
		}

		public int getITEM_ARMOR_PANTS_CHANCE() {
			return ITEM_ARMOR_PANTS_CHANCE;
		}

		public int getITEM_ARMOR_SHOES_CHANCE() {
			return ITEM_ARMOR_SHOES_CHANCE;
		}

		public int getITEM_ARMOR_RING_CHANCE() {
			return ITEM_ARMOR_RING_CHANCE;
		}

		public int getITEM_ARMOR_AMULET_CHANCE() {
			return ITEM_ARMOR_AMULET_CHANCE;
		}

		public int getITEM_WEAPON_ONEHAND_CHANCE() {
			return ITEM_WEAPON_ONEHAND_CHANCE;
		}

		public int getITEM_WEAPON_TWOHAND_CHANCE() {
			return ITEM_WEAPON_TWOHAND_CHANCE;
		}

		public int getITEM_WEAPON_OFFHAND_CHANCE() {
			return ITEM_WEAPON_OFFHAND_CHANCE;
		}

		public int getITEM_WEAPON_1H_SWORD_CHANCE() {
			return ITEM_WEAPON_1H_SWORD_CHANCE;
		}

		public int getITEM_WEAPON_1H_AXE_CHANCE() {
			return ITEM_WEAPON_1H_AXE_CHANCE;
		}

		public int getITEM_WEAPON_1H_DAGGER_CHANCE() {
			return ITEM_WEAPON_1H_DAGGER_CHANCE;
		}

		public int getITEM_WEAPON_1H_MACE_CHANCE() {
			return ITEM_WEAPON_1H_MACE_CHANCE;
		}

		public int getITEM_WEAPON_2H_SWORD_CHANCE() {
			return ITEM_WEAPON_2H_SWORD_CHANCE;
		}

		public int getITEM_WEAPON_2H_AXE_CHANCE() {
			return ITEM_WEAPON_2H_AXE_CHANCE;
		}

		public int getITEM_WEAPON_2H_STAFF_CHANCE() {
			return ITEM_WEAPON_2H_STAFF_CHANCE;
		}

		public int getITEM_WEAPON_2H_MACE_CHANCE() {
			return ITEM_WEAPON_2H_MACE_CHANCE;
		}

		public int getITEM_WEAPON_2H_BOW_CHANCE() {
			return ITEM_WEAPON_2H_BOW_CHANCE;
		}

		public int getITEM_WEAPON_OH_SHIELD_CHANCE() {
			return ITEM_WEAPON_OH_SHIELD_CHANCE;
		}

		public int getSTATS_START_ARMOR() {
			return STATS_START_ARMOR;
		}

		public int getITEM_WEAPON_MAINHAND_CHANCE() {
			return ITEM_WEAPON_MAINHAND_CHANCE;
		}

		public int getITEM_STATS_MIN_ARMOR() {
			return ITEM_STATS_MIN_ARMOR;
		}

		public int getITEM_WEAPON_OH_SCEPTER_CHANCE() {
			return ITEM_WEAPON_OH_SCEPTER_CHANCE;
		}

		public int getITEM_NORMAL_DROPCHANCE() {
			return ITEM_NORMAL_DROPCHANCE;
		}

		public int getITEM_RARE_DROPCHANCE() {
			return ITEM_RARE_DROPCHANCE;
		}

		public int getITEM_USABLE_POT_CHANCE() {
			return ITEM_USABLE_POT_CHANCE;
		}

		public int getITEM_USABLE_HEALPOT_CHANCE() {
			return ITEM_USABLE_HEALPOT_CHANCE;
		}

		public int getITEM_USABLE_MANAPOT_CHANCE() {
			return ITEM_USABLE_MANAPOT_CHANCE;
		}

		public int getITEM_USABLE_POT_NORMAL_MIN_VALUE() {
			return ITEM_USABLE_POT_NORMAL_MIN_VALUE;
		}

		public int getITEM_USABLE_POT_NORMAL_MAX_VALUE() {
			return ITEM_USABLE_POT_NORMAL_MAX_VALUE;
		}

		public int getITEM_USABLE_POT_NORMAL_MIN_DURATION() {
			return ITEM_USABLE_POT_NORMAL_MIN_DURATION;
		}

		public int getITEM_USABLE_POT_NORMAL_MAX_DURATION() {
			return ITEM_USABLE_POT_NORMAL_MAX_DURATION;
		}

		public int getITEM_USABLE_POT_RARE_MIN_VALUE() {
			return ITEM_USABLE_POT_RARE_MIN_VALUE;
		}

		public int getITEM_USABLE_POT_RARE_MAX_VALUE() {
			return ITEM_USABLE_POT_RARE_MAX_VALUE;
		}

		public int getITEM_USABLE_POT_RARE_MIN_DURATION() {
			return ITEM_USABLE_POT_RARE_MIN_DURATION;
		}

		public int getITEM_USABLE_POT_RARE_MAX_DURATION() {
			return ITEM_USABLE_POT_RARE_MAX_DURATION;
		}

		public int getITEM_USABLE_POT_EPIC_MIN_VALUE() {
			return ITEM_USABLE_POT_EPIC_MIN_VALUE;
		}

		public int getITEM_USABLE_POT_EPIC_MAX_VALUE() {
			return ITEM_USABLE_POT_EPIC_MAX_VALUE;
		}

		public int getITEM_USABLE_POT_EPIC_MIN_DURATION() {
			return ITEM_USABLE_POT_EPIC_MIN_DURATION;
		}

		public int getITEM_USABLE_POT_EPIC_MAX_DURATION() {
			return ITEM_USABLE_POT_EPIC_MAX_DURATION;
		}

		public int getITEM_USABLE_POT_LEGENDARY_MIN_VALUE() {
			return ITEM_USABLE_POT_LEGENDARY_MIN_VALUE;
		}

		public int getITEM_USABLE_POT_LEGENDARY_MAX_VALUE() {
			return ITEM_USABLE_POT_LEGENDARY_MAX_VALUE;
		}

		public int getITEM_USABLE_POT_LEGENDARY_MIN_DURATION() {
			return ITEM_USABLE_POT_LEGENDARY_MIN_DURATION;
		}

		public int getITEM_USABLE_POT_LEGENDARY_MAX_DURATION() {
			return ITEM_USABLE_POT_LEGENDARY_MAX_DURATION;
		}

		public int getITEM_USABLE_FLASK_CHANCE() {
			return ITEM_USABLE_FLASK_CHANCE;
		}

		public int getITEM_EPIC_DROPCHANCE() {
			return ITEM_EPIC_DROPCHANCE;
		}

		public int getITEM_USABLE_PERGAMENT_CHANCE() {
			return ITEM_USABLE_PERGAMENT_CHANCE;
		}

		public int getITEM_USABLE_PERGAMENT_SKILL_CHANCE() {
			return ITEM_USABLE_PERGAMENT_SKILL_CHANCE;
		}

		public float getITEM_USABLE_PERGAMENT_SKILL_MIN_LEVEL_FACTOR() {
			return ITEM_USABLE_PERGAMENT_SKILL_MIN_LEVEL_FACTOR;
		}

		public float getITEM_USABLE_PERGAMENT_SKILL_MAX_LEVEL_FACTOR() {
			return ITEM_USABLE_PERGAMENT_SKILL_MAX_LEVEL_FACTOR;
		}

		public int getITEM_LEGENDARY_DROPCHANCE() {
			return ITEM_LEGENDARY_DROPCHANCE;
		}
		
		
		
	
}
