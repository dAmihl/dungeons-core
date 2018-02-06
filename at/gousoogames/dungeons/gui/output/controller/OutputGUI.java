package at.gousoogames.dungeons.gui.output.controller;

import at.gousoogames.dungeons.Dungeons;
import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.character.Player;
import at.gousoogames.dungeons.engine.modules.Chest;
import at.gousoogames.dungeons.engine.modules.IModule;
import at.gousoogames.dungeons.engine.world.LargeRoom;
import at.gousoogames.dungeons.engine.world.MediumRoom;
import at.gousoogames.dungeons.engine.world.Room;
import at.gousoogames.dungeons.engine.world.SmallRoom;
import at.gousoogames.dungeons.game.battle.BattleManager;
import at.gousoogames.dungeons.gui.output.screens.LargeRoomScreen;
import at.gousoogames.dungeons.gui.output.screens.MediumRoomScreen;
import at.gousoogames.dungeons.gui.output.screens.SmallRoomScreen;
import at.gousoogames.dungeons.gui.output.screens.WelcomeScreen;

public class OutputGUI implements IOutput {


	
	@Override
	public void drawModule(IModule m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showCharacterInfo(GameCharacter c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMainMenu() {
		Dungeons.instance.setScreen(new WelcomeScreen(Dungeons.instance));
		
	}

	@Override
	public void showErrorMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawRoom(Room r) {
		if (r instanceof SmallRoom)
			Dungeons.instance.setScreen(new SmallRoomScreen(Dungeons.instance, r));
		if (r instanceof MediumRoom)
			Dungeons.instance.setScreen(new MediumRoomScreen(Dungeons.instance, r));
		if (r instanceof LargeRoom)
			Dungeons.instance.setScreen(new LargeRoomScreen(Dungeons.instance, r));
	}

	@Override
	public void drawChest(Chest c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawInventory(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawBattleScreen(BattleManager bm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showBattleCharacterTurn(GameCharacter c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showSkillset(Player p) {
		// TODO Auto-generated method stub
		
	}

}