package at.gousoogames.dungeons.engine.character.npc.enemies;

import at.gousoogames.dungeons.engine.character.Buffs;
import at.gousoogames.dungeons.engine.character.Equipment;
import at.gousoogames.dungeons.engine.character.Inventory;
import at.gousoogames.dungeons.engine.character.Skillset;
import at.gousoogames.dungeons.engine.character.CharacterStats;
import at.gousoogames.dungeons.engine.character.npc.NPC;

public class Enemy extends NPC{

	public Enemy(String name, Inventory i, Equipment eq, Skillset sk, CharacterStats st,
			Buffs b) {
		super(name, i, eq, sk, st, b);
	}



}
