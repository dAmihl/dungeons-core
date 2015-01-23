package at.gousoogames.dungeons.engine.character.npc.enemies;

import at.gousoogames.dungeons.engine.character.Buffs;
import at.gousoogames.dungeons.engine.character.Equipment;
import at.gousoogames.dungeons.engine.character.Inventory;
import at.gousoogames.dungeons.engine.character.Skillset;
import at.gousoogames.dungeons.engine.character.CharacterStats;

public class BeastEnemy extends Enemy {

	public BeastEnemy(String name, Inventory i, Skillset sk,
			CharacterStats st, Buffs b) {
		super(name, i, new Equipment(), sk, st, b);
	}

}
