package at.gousoogames.dungeons.game.gamemodes;

import at.gousoogames.dungeons.engine.ai.AI;
import at.gousoogames.dungeons.engine.ai.StandardAI;
import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Skill;

public class StandardGamemode extends Gamemode {

	private StandardGamemode(){}
	
	private static StandardGamemode instance = null;
	
	private static GenerationConfig generationConfig = null;
	private static AI	artificialIntelligence = null;
	
	
	
	private int BATTLE_SKILLSET_INIT_NUM_PHYSICAL = 3;
	private int BATTLE_SKILLSET_INIT_NUM_MAGICAL  = 3;
	private int BATTLE_SKILLSET_INIT_NUM_SUPPORTIVE = 3;
	
	private float BATTLE_SKILLSET_NUM_PHYSICAL_LEVEL_FACTOR = 0.1f;
	private float BATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR	= 0.1f;
	private float BATTLE_SKILLSET_NUM_SUPPORTIVE_LEVEL_FACTOR	= 0.1f;
	
	
	@Override
	public GenerationConfig getGenerationConfig() {
		if (generationConfig == null) generationConfig = StandardGenerationConfig.getConfig();
		return generationConfig;
	}
	
	public AI getAI(){
		if (artificialIntelligence == null) artificialIntelligence = StandardAI.getInstance();
		return artificialIntelligence;
	}
	
	
	public static Gamemode getGamemode(){
		if (instance == null) instance = new StandardGamemode();
		return instance;
	}
	
	// TODO better exp computation
		public int computeExp(Skill usedSkill, GameCharacter enemy){
			int exp = usedSkill.getSkillLevel() * 100 * enemy.getCharacterLevel();
			return exp;
		}

		public StandardGamemode getInstance() {
			return instance;
		}

		public AI getArtificialIntelligence() {
			return artificialIntelligence;
		}

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
