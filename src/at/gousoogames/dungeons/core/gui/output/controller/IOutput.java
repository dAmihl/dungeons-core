package at.gousoogames.dungeons.core.gui.output.controller;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.modules.Chest;
import at.gousoogames.dungeons.core.engine.modules.IModule;
import at.gousoogames.dungeons.core.engine.world.Room;
import at.gousoogames.dungeons.core.game.battle.BattleManager;

public interface IOutput {

	public void drawModule(IModule m);
	public void showCharacterInfo(GameCharacter c);
	public void showMainMenu();
	public void showErrorMessage(String msg);
	public void drawRoom(Room r);
	public void drawChest(Chest c);
	public void drawInventory(Player p);
	public void drawBattleScreen(BattleManager bm);
	public void showBattleCharacterTurn(GameCharacter c);
	public void showSkillset(Player p);
	public void playerDeathScreen(Player p);
	public void showBattleSkillset(Player p);
	public void showBattleInventory(Player p);
	public void showBattlePlayerTurnMenu(Player p);
}

