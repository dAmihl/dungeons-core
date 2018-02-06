package at.gousoogames.dungeons.core.engine.character.npc;

import at.gousoogames.dungeons.core.engine.character.Buffs;
import at.gousoogames.dungeons.core.engine.character.CharacterStats;
import at.gousoogames.dungeons.core.engine.character.Equipment;
import at.gousoogames.dungeons.core.engine.character.GameCharacter;
import at.gousoogames.dungeons.core.engine.character.Inventory;
import at.gousoogames.dungeons.core.engine.character.Skillset;

public class NPC extends GameCharacter {

	public NPC(String name, Inventory i, Equipment eq, Skillset sk, CharacterStats st,
			Buffs b) {
		super(name, i, eq, sk, st, b);
	}

}
