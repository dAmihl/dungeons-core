package at.gousoogames.dungeons.core.engine.character.npc.ally;

import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Skillset;
import at.gousoogames.dungeons.core.engine.character.npc.NPC;

public class Merchant extends NPC {

	public Merchant(String name, Inventory i, Equipment eq, Skillset sk,
			CharacterStats st, Buffs b) {
		super(name, i, eq, sk, st, b);
	}

}
