package at.gousoogames.dungeons.core.gui.output.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import at.gousoogames.dungeons.core.config.InputConfigurationManager;
import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.core.engine.gameitems.Item;
import at.gousoogames.dungeons.core.engine.modules.Chest;
import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.engine.skills.supportive.SupportiveSkill;
import at.gousoogames.dungeons.core.engine.world.Room;
import at.gousoogames.dungeons.core.game.battle.BattleManager;
import at.gousoogames.dungeons.core.game.battle.BattleTeam;
import at.gousoogames.dungeons.core.game.game.Game;
import at.gousoogames.dungeons.core.gui.input.controller.InputContainer;
import at.gousoogames.dungeons.core.gui.input.controller.InputManagerFactory;
import at.gousoogames.dungeons.core.tests.application.Application;

public class OutputText implements IOutput {

	
	private void printText(String s){
		System.out.println(s);
	}
	
	@Override
	public void drawModule(IModule m) {
		printText("Module "+m);
		if (m instanceof Enemy){
			printText(((Enemy)m).getCharacterName()+" with Level: "+((Enemy)m).getCharacterLevel());
		}		
	}
	
	

	@Override
	public void showCharacterInfo(GameCharacter c) {
		printText("Character sheet for "+c.getCharacterName());
		showCharacterEquipment(c);
		showCharacterStats(c);
		showCharacterInventory(c);

	}
	
	private void showCharacterEquipment(GameCharacter c){
		Item i;
		printText("Equipment:");
		printText("Head: "+((i = c.getEquipment().getHead()) != null ? i.getItemName() : "empty"));
		printText("Shoulder: "+((i = c.getEquipment().getShoulder()) != null ? i.getItemName() : "empty"));
		printText("Breast: "+((i = c.getEquipment().getBreast()) != null ? i.getItemName() : "empty"));
		printText("Pants: "+((i = c.getEquipment().getPants()) != null ? i.getItemName() : "empty"));
		printText("Shoes: "+((i = c.getEquipment().getShoes()) != null ? i.getItemName() : "empty"));
		printText("Ring 1: "+c.getEquipment().getLeftRing().getItemName());
		printText("Ring 2: "+c.getEquipment().getRightRing().getItemName());
		printText("Amulet: "+c.getEquipment().getAmulet().getItemName());
		printText("MainHand Weapon: "+c.getEquipment().getMainHandWeapon().getItemName());
		printText("OffHand Weapon: "+c.getEquipment().getOffHandWeapon().getItemName());

	}
	
	private void showCharacterStats(GameCharacter c){
		printText("-------------------");
		printText("Stats:");
		printText("Vitality: "+c.getStats().getVitality());
		printText("Strength: "+c.getStats().getStrength());
		printText("Agility: "+c.getStats().getAgility());
		printText("Intelligence: "+c.getStats().getIntelligence());
		printText("Armor: "+c.getStats().getArmor());
		printText("HealthPoints: "+c.getStats().getHealthPoints());
		printText("ManaPoints: "+c.getStats().getManaPoints());
		printText("EvasionRating: "+c.getStats().getEvasionRating());
		printText("HitChance: "+c.getStats().getHitChance());
		printText("--------------------");
	}
	
	private void showCharacterInventory(GameCharacter c){
		Item i;
		Item[] iarr = c.getInventory().getInventoryArray();
		printText("Inventory:");
		for (int n = 0; n < iarr.length; n++){
			printText(n+". "+(( i = iarr[n]) != null ? i.getItemName() : "empty"));
		}
		printText("-----------");
	}
	

	@Override
	public void showMainMenu() {
		printText("1. Start!");
		InputManagerFactory.getInputManager().handleInputMainMenu(new InputContainer(readIntStdin()));
		
	}

	@Override
	public void showErrorMessage(String msg) {
		printText("-------------Error: "+msg);
	}

	@Override
	public void drawRoom(Room r) {
		printText("You are in a Room with "+r.getNumberModules()+" modules.");
		for (IModule mod : r.getModules()){
			drawModule(mod);
		}
		
		showRoomMenu(r.getModules());
		
	}
	
	private void showRoomMenu(IModule... modules){
		printText("What do you want to do:");
		for (int i = 0; i < modules.length; i++){
			printText(i+". Inspect Module: "+modules[i]);
		}
		printText(InputConfigurationManager.getKeyStartFight()+": Start Fight");
		printText(InputConfigurationManager.getKeyShowCharacter()+": Show character");
		printText(InputConfigurationManager.getKeyShowInventory()+": Show character inventory");
		printText(InputConfigurationManager.getKeyShowSkillset()+": show skillsets");
		printText("########");
		printText(InputConfigurationManager.getKeyExit()+": Quit");
		
		String input = readStringStdin();
		
		InputManagerFactory.getInputManager().handleInputRoom(new InputContainer(input));

	}
	
	
	private Integer readIntStdin(){
		String input;
		Integer number = 0;
	    try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number = Integer.parseInt(input);
	        return number;
	    } catch (NumberFormatException ex) {
	       printText("Not a number !");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return number;
	}
	
	private String readStringStdin(){
		String input = "";
	    try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        return input;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return input;
	}

	@Override
	public void drawChest(Chest c) {
		printText("Chest contains: ");
		drawItemContainer(c.getItems());
		
	}
	
	private void drawItemContainer(Item[] items){
		int n = 1;
		for (Item i: items){
			printText(n++ + i.getItemName());
		}
	}

	@Override
	public void drawBattleScreen(BattleManager bm) {
		printText("You are in a Battle!");
		printText("Team 1: ");
		for (GameCharacter c : bm.getTeamOne().getMembers())
			printText(c.getCharacterName() + " with Level "+c.getCharacterLevel()+" HP: "+c.getStats().getCurrentHealthPoints());
		
		printText("vs. Team 2: ");
		for (GameCharacter c : bm.getTeamTwo().getMembers())
			printText(c.getCharacterName() + " with Level "+c.getCharacterLevel()+" HP: "+c.getStats().getCurrentHealthPoints());
		
	}

	@Override
	public void showBattleCharacterTurn(GameCharacter c) {
		printText("[" + c + "] with HP: "+c.getStats().getHealthPoints());
		if (c instanceof Player){
			printText("Player is making a turn.");
			showBattlePlayerTurnMenu((Player) c);
		}else{
			printText("Enemy is making a turn.");
		}
	}
	
	
	public void showBattlePlayerTurnMenu(Player p){
		
		printText("Your life: "+p.getStats().getCurrentHealthPoints());
		printText("Your mana: "+p.getStats().getCurrentManaPoints());
		printText("watcha wanna doo?");
		printText(InputConfigurationManager.getKeyShowSkillset()+" show skills");
		printText(InputConfigurationManager.getKeyShowInventory()+" show inventory");
		printText(InputConfigurationManager.getKeyShowCharacter()+" show character stats");
	
		String input = readStringStdin();
		InputContainer ic = new InputContainer(input);
		InputManagerFactory.getInputManager().handleInputPlayerTurn(ic);
		
		

	}
	
	@Override
	public void showBattleInventory(Player p){
		int i = 0;
		for (Item it: p.getInventory().getInventoryArray()){
			printText(i++ +". "+it.getItemName());
		}
		
		int input = readIntStdin();

		if (input >= p.getInventory().getInventoryArray().length) {
//			battleShowInventory(p);
		}
		else{
			if (p.useItemOfInventory(p.getInventory().getInventoryArray()[input])){
				printText("Item used.");
			}
			else{
				printText("you cant do that now");
			}
		}
		
	}
	
	@Override
	public void showBattleSkillset(Player p){
		int i = 0;
		printText("Physical Skills: ");
		for (Skill s: p.getSkillset().getBattleSkillset().getPhysicalSkills()){
			printText(i++ + ". {"+s.getSkillName() + "}: "+s.getSkillLevel());
		}
		i = 10;
		printText("Magical Skills: ");
		for (Skill s: p.getSkillset().getBattleSkillset().getMagicalSkills()){
			printText(i++ + ". {"+s.getSkillName() + "}: "+s.getSkillLevel());
		}
		i = 20;
		printText("Supportive Skills: ");
		for (Skill s: p.getSkillset().getBattleSkillset().getSupportiveSkills()){
			printText(i++ + ". {"+s.getSkillName() + "}: "+s.getSkillLevel());
		}
		
		int input = readIntStdin();

		if (input > i){
			showBattleSkillset(p);
		}else{
			if (input < 10)
				battleUseSkillMenu(p, p.getSkillset().getBattleSkillset().getPhysicalSkills().get(input));
			else if (input < 20)
				battleUseSkillMenu(p, p.getSkillset().getBattleSkillset().getMagicalSkills().get(input-10));
			else if (input < 30)
				battleUseSkillMenu(p, p.getSkillset().getBattleSkillset().getSupportiveSkills().get(input-20));
		}
	}
	
	private void battleUseSkillMenu(Player p, Skill s){
		BattleTeam enemies = at.gousoogames.dungeons.core.game.game.Game.getGameManager().getBattleManager().getTeamTwo();
		BattleTeam myTeam = Game.getGameManager().getBattleManager().getTeamOne();
		int i = 0;
		
		if (s instanceof SupportiveSkill){
			
			for (GameCharacter c: myTeam.getAliveMembers()){
				printText(i++ + ". ["+c+"] with life: "+c.getStats().getCurrentHealthPoints());
			}
			
			int input = readIntStdin();
			if (input > i){
				battleUseSkillMenu(p, s);
			}else{
				if (s.isMultiTargetSkill())
					s.useSkillOn(myTeam.getAliveMembers());
				else
					s.useSkillOn(myTeam.getAliveMembers()[input]);
			}
		
		}else{
			for (GameCharacter c: enemies.getAliveMembers()){
				printText(i++ + ". ["+c+"] with life: "+c.getStats().getCurrentHealthPoints());
			}
			
			int input = readIntStdin();
			if (input > i){
				battleUseSkillMenu(p, s);
			}else{
				if (s.isMultiTargetSkill())
					s.useSkillOn(enemies.getAliveMembers());
				else
					s.useSkillOn(enemies.getAliveMembers()[input]);
			}
		}
	}



	@Override
	public void drawInventory(Player p) {
		showBattleInventory(p);
		
	}



	@Override
	public void showSkillset(Player p) {
		printText("Learned Skills: ");
		printText("Add to battle skillset:");
		int i = 0;
		for (Skill s: p.getSkillset().getLearnedSkills()){
			printText(i++ +". "+s.getSkillName()+" / Level: "+s.getSkillLevel());
		}
		
		int input = readIntStdin();
		InputManagerFactory.getInputManager().handleInputSkillset(new InputContainer(input));
		
	}

	@Override
	public void playerDeathScreen(Player p) {
		printText("Unfortunately... YOU DIED!");
		printText("Here's your character. Say goodbye!");
		this.showCharacterInfo(p);
		
		printText("Enter any key to start all over, from the very beginning. Have fun!");
		readIntStdin();
		Application.startMainMenu();
	}

}
