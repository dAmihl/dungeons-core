package at.gousoogames.dungeons.core.engine.character.npc.enemies;

import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Skillset;

public class HumanoidEnemy extends Enemy {

	public HumanoidEnemy(String name, Inventory i, Equipment eq, Skillset sk,
			CharacterStats st, Buffs b) {
		super(name, i, eq, sk, st, b);
	}

}
