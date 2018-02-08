package at.gousoogames.dungeons.core.gui.input.controller;

import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.core.engine.modules.Chest;
import at.gousoogames.dungeons.core.engine.modules.IModule;
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
		Integer input = (Integer) c.getInput();
		IModule[] mods = at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom().getModules();
		if (input >= Integer.parseInt("10")){
			switch (input){
			case 10: at.gousoogames.dungeons.core.game.game.Game.getGameManager().startBattle(); break;
			case 11: OutputFactory.getOutput().showCharacterInfo(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0]); break;
			case 12: OutputFactory.getOutput().drawInventory(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0]);break;
			case 13: at.gousoogames.dungeons.core.game.game.Game.getGameManager().nextRoom(); break;
			case 14: OutputFactory.getOutput().showSkillset(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0]); break;
			}
		}
		else{
		if (mods[input] instanceof Chest){
			at.gousoogames.dungeons.core.game.game.Game.getGameManager().getPlayers()[0].lootItems(((Chest)mods[input]).getItems());
			OutputFactory.getOutput().drawChest((Chest)mods[input]);
		}else if (mods[input] instanceof Enemy){
			OutputFactory.getOutput().showCharacterInfo(((Enemy)mods[input]));
		}else{
			OutputFactory.getOutput().drawRoom(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom());
		}
		}
		OutputFactory.getOutput().drawRoom(at.gousoogames.dungeons.core.game.game.Game.getGameManager().getDungeonManager().getCurrentRoom());

	}

	@Override
	public void handleInputPlayerTurn(InputContainer c) {
		
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