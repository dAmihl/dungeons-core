package at.gousoogames.dungeons.engine.ai;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.skills.Skill;
import at.gousoogames.dungeons.engine.skills.supportive.SupportiveSkill;
import at.gousoogames.dungeons.game.battle.BattleTeam;
import at.gousoogames.dungeons.gui.output.Debug;

public class StandardAI extends AI {

	private StandardAI() {
	}

	private static StandardAI instance;

	public static StandardAI getInstance() {
		if (instance == null)
			instance = new StandardAI();
		return instance;
	}

	@Override
	public void battleMakeNPCTurn(GameCharacter c) {

		Skill sk = getSkillToUse(c);
		GameCharacter target = computeAttackTarget(c, sk);
		sk.useSkillOn(target);
		Debug.log("AI active making battle turn for " + c);
	}

	private GameCharacter computeAttackTarget(GameCharacter c, Skill sk) {
		BattleTeam playerTeam = at.gousoogames.dungeons.game.game.Game.getGameManager().getBattleManager()
				.getTeamOfCharacter(c) == at.gousoogames.dungeons.game.game.Game.getGameManager()
				.getBattleManager().getTeamOne() ? at.gousoogames.dungeons.game.game.Game.getGameManager()
				.getBattleManager().getTeamTwo() : at.gousoogames.dungeons.game.game.Game.getGameManager()
				.getBattleManager().getTeamOne();

		if (sk instanceof SupportiveSkill) {
			return at.gousoogames.dungeons.game.game.Game.getGameManager().getBattleManager()
					.getTeamOfCharacter(c).getAliveMembers()[0];
		} else {
			return playerTeam.getMembers()[0];
		}

	}

	private Skill getSkillToUse(GameCharacter c) {
		return c.getSkillset().getLearnedSkills().get(0);
	}

}
