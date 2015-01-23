package at.gousoogames.dungeons.game.battle;

import at.gousoogames.dungeons.engine.ai.AI;
import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.character.Player;
import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.game.gamemodes.GamemodeManager;
import at.gousoogames.dungeons.gui.output.Debug;
import at.gousoogames.dungeons.gui.output.OutputFactory;


public class BattleManager {

	private BattleTeam teamOne;
	private BattleTeam teamTwo;
	
	private AI npcAI;
	
	private int roundCount;
	
	public BattleManager(BattleTeam t1, BattleTeam t2){
		this.npcAI = GamemodeManager.getGamemode().getAI();
		this.teamOne = t1;
		this.teamTwo = t2;
		this.roundCount = 0;
	}
	
	public BattleTeam getTeamOfCharacter(GameCharacter c){
		if (teamOne.isCharacterInTeam(c)) return teamOne;
		else return teamTwo;
	}
	
	
	
	public void startBattle(){
		OutputFactory.getOutput().drawBattleScreen(this);
		while(checkBattleActive()){
			nextRound();
			roundCount++;
		}
	}
	
	private boolean checkBattleActive(){
		if (!teamOne.teamAlive()) {
			battleOver(teamTwo);
			return false;
		}
		else if (!teamTwo.teamAlive()){
			battleOver(teamOne);
			return false;
		}else{
			return true;
		}
	}
	
	private void nextRound(){
		enemiesTickBuffs();
		at.gousoogames.dungeons.game.game.Game.getGameManager().nextRound();
		switch (roundCount % 2){
		case 0: makeTurn(teamOne); break;
		case 1: makeTurn(teamTwo); break;
		}
	}
	
	private void makeTurn(BattleTeam t){
		for (GameCharacter c: t.getMembers()){
			OutputFactory.getOutput().showBattleCharacterTurn(c);
			if (c instanceof Player){
				playerTurn((Player) c);
			}else{
				npcTurn(c);
			}
		}
	}
	
	private void playerTurn(Player p){
//		Debug.log("Player "+p+" is on turn! with life "+p.getStats().getCurrentHealthPoints()+".");
//		Enemy e = (Enemy) this.teamTwo.getAliveMembers()[0];
//		Debug.log("Life of Enemy: "+e.getStats().getCurrentHealthPoints());
//		p.getSkillset().getLearnedSkills().get(1).useSkillOn(e);
//		Debug.log("Life of ENemy now: "+e.getStats().getCurrentHealthPoints());
	}
	
	private void npcTurn(GameCharacter c){
		this.npcAI.battleMakeNPCTurn(c);
	}
	
	
	private void battleOver(BattleTeam winnerTeam){
		Debug.log("Battle over. Team "+winnerTeam+" won.");
		Debug.log("Team stats: ");

		for (GameCharacter c: winnerTeam.getMembers()){
			Debug.log("Character "+c+": Life: "+c.getStats().getCurrentHealthPoints());
		}
		//TODO
		for (GameCharacter c : teamTwo.getMembers()){
			at.gousoogames.dungeons.game.game.Game.getGameManager().getPlayers()[0].lootInventory(c.getInventory());
		}
		at.gousoogames.dungeons.game.game.Game.getGameManager().nextRoom();
	}
	
	
	private void enemiesTickBuffs(){
		for (GameCharacter c: teamOne.getAliveMembers()){
			if (c instanceof Enemy)
				c.tickBuffs();
		}
		
		for (GameCharacter c: teamTwo.getAliveMembers()){
			if (c instanceof Enemy){
				c.tickBuffs();
			}
		}
	}
	
	
	/*
	 * getters
	 */

	public int getRoundCount(){
		return roundCount;
	}
	
	public BattleTeam getTeamOne(){
		return teamOne;
	}
	
	public BattleTeam getTeamTwo(){
		return teamTwo;
	}
	
	
}
