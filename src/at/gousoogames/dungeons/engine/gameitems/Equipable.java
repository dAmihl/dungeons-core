package at.gousoogames.dungeons.engine.gameitems;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.generator.StatsGenerator;


public class Equipable extends Item {

	
	public Equipable(String name, StatRequirements req){
		super(name, req);
	}

	public void setStatRequirementForNPC(GameCharacter npc){
		this.setStatRequirements(StatsGenerator.generateEnemyEquipmentStatRequirements(npc.getStats()));
	}
	
	
}
