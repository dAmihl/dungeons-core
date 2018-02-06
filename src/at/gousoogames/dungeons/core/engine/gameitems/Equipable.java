package at.gousoogames.dungeons.core.engine.gameitems;

import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.generator.StatsGenerator;


public class Equipable extends Item {

	
	public Equipable(String name, StatRequirements req){
		super(name, req);
	}

	public void setStatRequirementForNPC(GameCharacter npc){
		this.setStatRequirements(StatsGenerator.generateEnemyEquipmentStatRequirements(npc.getStats()));
	}
	
	
}
