package at.gousoogames.dungeons.core.tests;


import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.character.Skillset;
import at.gousoogames.dungeons.core.engine.gameitems.ArmorStats;
import at.gousoogames.dungeons.core.engine.gameitems.StatRequirements;
import at.gousoogames.dungeons.core.engine.gameitems.WeaponStats;
import at.gousoogames.dungeons.core.engine.gameitems.armor.BreastArmor;
import at.gousoogames.dungeons.core.engine.gameitems.armor.HeadArmor;
import at.gousoogames.dungeons.core.engine.gameitems.usables.ManapotUsable;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.OneHandWeapon;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.TwoHandWeapon;
import at.gousoogames.dungeons.core.engine.gameitems.weapons.Weapon;
import at.gousoogames.dungeons.core.engine.skills.SkillFactory;
import at.gousoogames.dungeons.core.engine.world.DungeonManager;
import at.gousoogames.dungeons.core.game.game.SingleplayerGameManager;
import at.gousoogames.dungeons.core.gui.output.controller.Debug;



public class TestCases {


	
/*Testcase configs*/
private static final int P_STR = 10;
private static final int P_VIT = 10;
private static final int P_AGI = 10;
private static final int P_INT = 10;
private static final int P_ARM = 10;
	
private static final int I_STR = 3;
private static final int I_VIT = 20;
private static final int I_AGI = 1;
private static final int I_INT = 0;
private static final int I_ARM = 4;


	
	public static Player createTestcasePlayer(){
		
		Debug.log("Creating testcase player object..");
		
		String name = "TestHer0";
		
		Skillset sk = new Skillset();
		Equipment eq = new Equipment();
		Inventory i = new Inventory();
		Buffs b = new Buffs();
		CharacterStats st = new CharacterStats(P_ARM,P_VIT, P_STR, P_AGI, P_INT);
		
		HeadArmor head = new HeadArmor("Kopf des Noobs",new ArmorStats(I_ARM,I_VIT, I_STR, I_AGI, I_INT), new StatRequirements(10, 10, 10, 8));
		BreastArmor breast = new BreastArmor("Brustschutz des Noobs", new ArmorStats(4,3, 2, 2, 2), StatRequirements.emptyRequirement);
		Weapon weap = new OneHandWeapon("Waffe des Noobs", new WeaponStats(0,200,2,2,2,2), StatRequirements.emptyRequirement);
		Weapon weap2 = new TwoHandWeapon("Zweitwaffe des OberNoobs", new WeaponStats(0,200,2,2,2,2), StatRequirements.emptyRequirement);
		BreastArmor breast2 = new BreastArmor("Zweit-Brustschutz des OberNoobs", new ArmorStats(10,3, 2, 2, 2), StatRequirements.emptyRequirement);
		
		Player p = new Player(name, i, eq, sk, st, b);
		p.equipItem(breast);
		p.equipItem(weap);
		
		p.learnSkill(SkillFactory.getNewPhysicalNormalAttack());
		p.learnSkill(SkillFactory.getNewMagicalFireball());
		p.learnSkill(SkillFactory.getNewPhysicalWhirlwind());
		p.learnSkill(SkillFactory.getNewStrengthBuff());
		p.getSkillset().addSkillToBattleSkillset(p.getSkillset().getLearnedSkills().get(0));
		p.getSkillset().addSkillToBattleSkillset(p.getSkillset().getLearnedSkills().get(1));

//		p.learnSkill(SkillFactory.getNewSupportiveHeal());
//		p.learnSkill(SkillFactory.getNewMagicalFirestorm());
		p.giveHealth(2000);
		p.getInventory().addItem(new ManapotUsable("manapot", 50, 1));
		p.getInventory().addItem(head);
		p.getInventory().addItem(weap2);
		p.getInventory().addItem(breast2);
		return p;
		
	}
	
	
	public static SingleplayerGameManager createTestcaseGame(Player p){
		SingleplayerGameManager gm = new SingleplayerGameManager(new DungeonManager(), p);
		return gm;
	}
	
	
}
