package at.gousoogames.dungeons.core.gui.input.controller;


import at.gousoogames.dungeons.core.config.InputConfigurationManager;
import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.core.engine.modules.Chest;
import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.game.game.Game;
import at.gousoogames.dungeons.core.gui.output.controller.Debug;
import at.gousoogames.dungeons.core.gui.output.controller.OutputFactory;
import at.gousoogames.dungeons.core.tests.application.Application;

public class InputManagerText implements IInputManager {

	@Override
	public void handleInputMainMenu(InputContainer c) {
		Integer input = (Integer) c.getInput();
		switch(input){
		case 1:
			Application.startTestScenario();
			break;
		}
	}

	@Override
	public void handleInputCharacterSheet(InputContainer c) {
		
	}

	@Override
	public void handleInputRoom(InputContainer c) {
				
		String strinput = (String) c.getInput();

		if (InputConfigurationManager.isKeyStartFight(strinput)) {
			Game.getGameManager().startBattle(); 
		}
		else if (InputConfigurationManager.isKeyShowCharacter(strinput)){
			OutputFactory.getOutput().showCharacterInfo(Game.getGameManager().getPlayers()[0]);
		}
		else if (InputConfigurationManager.isKeyShowInventory(strinput)){
			OutputFactory.getOutput().drawInventory(Game.getGameManager().getPlayers()[0]);
		}
		else if (InputConfigurationManager.isKeyShowSkillset(strinput)){
			OutputFactory.getOutput().showSkillset(Game.getGameManager().getPlayers()[0]); 
		}
		else if (InputConfigurationManager.isKeyExit(strinput)){
			Game.getGameManager().quitCurrentGame();
		}
		else{
			
			Integer input = -1;
			
			try{
				input = Integer.parseInt(strinput);
			}catch(NumberFormatException e){
				Debug.log("Unknown Input!");
			}
			
			IModule[] mods = Game.getGameManager().getDungeonManager().getCurrentRoom().getModules();
			
			if (input < 0 || input > mods.length - 1){
				Debug.log("Unknown Input!");
			}else{
				if (mods[input] instanceof Chest){
					at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0].lootItems(((Chest)mods[input]).getItems());
					OutputFactory.getOutput().drawChest((Chest)mods[input]);
				}else if (mods[input] instanceof Enemy){
					OutputFactory.getOutput().showCharacterInfo(((Enemy)mods[input]));
				}else{
					OutputFactory.getOutput().drawRoom(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom());
				}
			}
		}

		OutputFactory.getOutput().drawRoom(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom());
	}

	@Override
	public void handleInputPlayerTurn(InputContainer c) {
		
		String strinput = (String) c.getInput();
		
		if (InputConfigurationManager.isKeyShowSkillset(strinput)) OutputFactory.getOutput().showBattleSkillset(Game.getGameManager().getPlayers()[0]);
		else if (InputConfigurationManager.isKeyShowInventory(strinput)) OutputFactory.getOutput().showBattleInventory(Game.getGameManager().getPlayers()[0]);
		else if (InputConfigurationManager.isKeyShowCharacter(strinput)) {
			OutputFactory.getOutput().showCharacterInfo(Game.getGameManager().getPlayers()[0]); 
			OutputFactory.getOutput().showBattlePlayerTurnMenu(Game.getGameManager().getPlayers()[0]);
		}
		else OutputFactory.getOutput().showBattlePlayerTurnMenu(Game.getGameManager().getPlayers()[0]);
	}

	@Override
	public void handleInputPlayerInventory(InputContainer c) {
		
	}

	@Override
	public void handleInputSkillset(InputContainer c) {
		Integer input = (Integer) c.getInput();

		
		
		Player p = at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0];
		
		if (input > p.getSkillset().getLearnedSkills().size() || input < 0) OutputFactory.getOutput().drawRoom(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom());
		
		p.getSkillset().addSkillToBattleSkillset(p.getSkillset().getLearnedSkills().get(input));
		
		
	}

}
