package at.gousoogames.dungeons.engine.gameitems.usables;

import at.gousoogames.dungeons.engine.character.GameCharacter;
import at.gousoogames.dungeons.engine.gameitems.Item;
import at.gousoogames.dungeons.engine.skills.Effect;

public class Usable extends Item {

	protected Effect usableEffect;
	protected UsableOnUse onUse;
	
	public Usable(String name, Effect eff) {
		super(name);
		this.usableEffect = eff;
		this.onUse = new UsableOnUse() {
			
			@Override
			public void onUse(GameCharacter c) {
				c.getBuffs().addBuff(usableEffect);
			}
		};
	}

	public Effect getUsableEffect() {
		return usableEffect;
	}
	
	public void useOn(GameCharacter c){
		onUse.onUse(c);
	}
	

}
