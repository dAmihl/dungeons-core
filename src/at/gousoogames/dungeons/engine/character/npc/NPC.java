package at.gousoogames.dungeons.engine.character.npc;

import at.gousoogames.dungeons.engine.character.Buffs;
import at.gousoogames.dungeons.engine.character.Equipment;
import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.character.Inventory;
import at.gousoogames.dungeons.engine.character.Skillset;
import at.gousoogames.dungeons.engine.character.CharacterStats;

public class NPC extends GameCharacter {

	public NPC(String name, Inventory i, Equipment eq, Skillset sk, CharacterStats st,
			Buffs b) {
		super(name, i, eq, sk, st, b);
	}

}
