package at.gousoogames.dungeons.game.gamemodes;

import at.gousoogames.dungeons.engine.ai.AI;
import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Skill;

public abstract class Gamemode {
	
	/*Singleton mechanism*/
	
	private int BATTLE_SKILLSET_INIT_NUM_PHYSICAL;
	private int BATTLE_SKILLSET_INIT_NUM_MAGICAL;
	private int BATTLE_SKILLSET_INIT_NUM_SUPPORTIVE;
	
	private float BATTLE_SKILLSET_NUM_PHYSICAL_LEVEL_FACTOR;
	private float BATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR;
	private float BATTLE_SKILLSET_NUM_SUPPORTIVE_LEVEL_FACTOR;
	
	public abstract GenerationConfig getGenerationConfig();
	public abstract AI getAI();
	public abstract int computeExp(Skill usedSkill, GameCharacter enemy);
	public int getBATTLE_SKILLSET_INIT_NUM_PHYSICAL() {
		return BATTLE_SKILLSET_INIT_NUM_PHYSICAL;
	}
	public int getBATTLE_SKILLSET_INIT_NUM_MAGICAL() {
		return BATTLE_SKILLSET_INIT_NUM_MAGICAL;
	}
	public int getBATTLE_SKILLSET_INIT_NUM_SUPPORTIVE() {
		return BATTLE_SKILLSET_INIT_NUM_SUPPORTIVE;
	}
	public float getBATTLE_SKILLSET_NUM_PHYSICAL_LEVEL_FACTOR() {
		return BATTLE_SKILLSET_NUM_PHYSICAL_LEVEL_FACTOR;
	}
	public float getBATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR() {
		return BATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR;
	}
	public float getBATTLE_SKILLSET_NUM_SUPPORTIVE_LEVEL_FACTOR() {
		return BATTLE_SKILLSET_NUM_SUPPORTIVE_LEVEL_FACTOR;
	}
}
