package at.gousoogames.dungeons.core.engine.character;

import at.gousoogames.dungeons.core.game.game.Game;

public class Player extends GameCharacter{

	public Player(String name, Inventory i, Equipment eq, Skillset sk,
			CharacterStats st, Buffs b) {
		super(name, i, eq, sk, st, b);
	}

	@Override
	protected void onDeath() {
		super.onDeath();
		Game.getGameManager().onPlayerDeath(this);
	}
	
}
