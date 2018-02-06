package at.gousoogames.dungeons.core.engine.character.npc.enemies;

import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Skillset;

public class BeastEnemy extends Enemy {

	public BeastEnemy(String name, Inventory i, Skillset sk,
			CharacterStats st, Buffs b) {
		super(name, i, new Equipment(), sk, st, b);
	}

}
