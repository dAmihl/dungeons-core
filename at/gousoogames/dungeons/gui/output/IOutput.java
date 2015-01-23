package at.gousoogames.dungeons.gui.output;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.character.Player;
import at.gousoogames.dungeons.engine.modules.Chest;
import at.gousoogames.dungeons.engine.modules.IModule;
import at.gousoogames.dungeons.engine.world.Room;
import at.gousoogames.dungeons.game.battle.BattleManager;

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
}

