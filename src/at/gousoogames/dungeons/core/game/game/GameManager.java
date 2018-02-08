package at.gousoogames.dungeons.core.game.game;

import at.gousoogames.dungeons.core.engine.character.Player;
import at.gousoogames.dungeons.core.engine.world.Dungeon;
import at.gousoogames.dungeons.core.engine.world.DungeonGenerator;
import at.gousoogames.dungeons.core.engine.world.DungeonManager;
import at.gousoogames.dungeons.core.game.battle.BattleManager;
import at.gousoogames.dungeons.core.game.battle.BattleTeam;
import at.gousoogames.dungeons.core.gui.output.controller.Debug;
import at.gousoogames.dungeons.core.gui.output.controller.IOutput;
import at.gousoogames.dungeons.core.gui.output.controller.OutputFactory;
import at.gousoogames.dungeons.core.tests.application.Application;

public abstract class GameManager {

	protected DungeonManager dungeonManager;
	protected Player[] players;
	protected int numPlayers;
	protected BattleManager currentBattle = null;
	
	public GameManager(DungeonManager dm, int numPlayers, Player ... ps ){
		this.dungeonManager = dm;
		this.numPlayers = numPlayers;
		this.players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++){
			if (ps[i] != null){
				this.players[i] = ps[i];
			}
		}
	}
	
	public DungeonManager getDungeonManager(){
		return dungeonManager;
	}
	
	public void startGame(){
		dungeonManager.startDungeon(DungeonGenerator.generate());
	}
	
	public void startGame(Dungeon d){
		dungeonManager.startDungeon(d);
	}
	
	public void startBattle(){
		BattleTeam[] teams = makeTeams();
		this.currentBattle = new BattleManager(teams[0], teams[1]);
		this.currentBattle.startBattle();
	}
	
	protected  BattleTeam[] makeTeams(){
		BattleTeam t1 = new BattleTeam(players);
		BattleTeam t2 = new BattleTeam(dungeonManager.getCurrentRoom().getEnemies());
		BattleTeam[] teams = new BattleTeam[2];
		teams[0] = t1;
		teams[1] = t2;
		return teams;
	}
	
	public abstract void onPlayerDeath(Player p);
	
	public int getEnvironmentLevel(){
		int sumLevel = 0;
		for (Player p: players){
			sumLevel += p.getCharacterLevel();
		}
		int result = sumLevel / numPlayers;
		return result;
	}
	
	public BattleManager getBattleManager(){
		return currentBattle;
	}
	
	public void nextRound(){
		for (Player p : players)
			p.tickBuffs();
	}
	
	public void nextRoom(){
		
		if (this.dungeonManager.nextRoom()){
			IOutput out = Application.output;
			out.drawRoom(this.getDungeonManager().getCurrentRoom());
		}else{
			Debug.log("Dungeon finished! Congrats!");
			OutputFactory.getOutput().showMainMenu();
		}
	
	}
	
	public Player[] getPlayers(){
		return players;
	}
	
	public void quitCurrentGame(){
		Debug.log("Bye Bye!");
		System.exit(0);
	}
	
}
