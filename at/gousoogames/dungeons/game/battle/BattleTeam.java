package at.gousoogames.dungeons.game.battle;

import at.gousoogames.dungeons.engine.character.GameCharacter;

public class BattleTeam {
	
	private GameCharacter[] members;
	private int teamSize;
	
	
	public BattleTeam(GameCharacter...characters ){
		this.teamSize = characters.length;
		this.members = new GameCharacter[teamSize];
		for (int i = 0; i < teamSize; i++){
			this.members[i] = characters[i];
		}
	}
	
	
	public GameCharacter[] getMembers(){
		return members;
	}
	
	public boolean isCharacterInTeam(GameCharacter c){
		for (GameCharacter x : members){
			if (x == c) return true;
		}
		return false;
	}
	
	public boolean teamAlive(){
		int numDeads = 0;
		for (GameCharacter x : members){
			if (!x.isAlive()) numDeads++;
		}
		return numDeads < members.length;
	}
	
	public GameCharacter[] getAliveMembers(){
		GameCharacter[] alives = new GameCharacter[countAliveMembers()];
		int i = 0;
		for (GameCharacter c: members){
			if (c.isAlive()) alives[i++] = c;
		}
		return alives;
	}
	
	private int countAliveMembers(){
		int number = 0;
		for (GameCharacter c: members){
			if (c.isAlive()) number++;
		}
		return number;
	}
	
}
