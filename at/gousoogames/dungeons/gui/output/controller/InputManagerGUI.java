package at.gousoogames.dungeons.gui.output.controller;

import at.gousoogames.dungeons.engine.modules.IModule;
import at.gousoogames.dungeons.game.game.Game;
import at.gousoogames.dungeons.tests.application.Application;

public class InputManagerGUI implements IInputManager {

	@Override
	public void handleInputMainMenu(InputContainer c) {
		Application.startTestScenario();
	}

	@Override
	public void handleInputCharacterSheet(InputContainer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInputRoom(InputContainer c) {
		if (c == null){
			Game.getGameManager().nextRoom();
			return;
		}
		if (c.getInput() instanceof IModule){
			Debug.log((IModule)(c.getInput()) + " CLICKED!");
			return;
		}
	}

	@Override
	public void handleInputPlayerTurn(InputContainer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInputPlayerInventory(InputContainer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInputSkillset(InputContainer c) {
		// TODO Auto-generated method stub
		
	}

}
