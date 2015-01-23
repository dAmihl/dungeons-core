package at.gousoogames.dungeons.game.game;

import at.gousoogames.dungeons.engine.character.Player;
import at.gousoogames.dungeons.engine.world.Dungeon;
import at.gousoogames.dungeons.engine.world.DungeonManager;
import at.gousoogames.dungeons.game.battle.BattleTeam;
import at.gousoogames.dungeons.gui.output.IOutput;
import at.gousoogames.dungeons.tests.application.Application;

public class SingleplayerGameManager extends GameManager {

	
	public SingleplayerGameManager(DungeonManager dm, Player p) {
		super(dm, 1, p);
	}
	
	public void startGame(){
		super.startGame();
		IOutput out = Application.output;
		out.drawRoom(this.getDungeonManager().getCurrentRoom());
	}
	
	public void startGame(Dungeon d){
		super.startGame(d);
		IOutput out = Application.output;
		out.drawRoom(this.getDungeonManager().getCurrentRoom());
	}
	
	protected  BattleTeam[] makeTeams(){
		BattleTeam t1 = new BattleTeam(players);
		BattleTeam t2 = new BattleTeam(dungeonManager.getCurrentRoom().getEnemies());
		BattleTeam[] teams = new BattleTeam[2];
		teams[0] = t1;
		teams[1] = t2;
		return teams;
	}
	
	
	
}
