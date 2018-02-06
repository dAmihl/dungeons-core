package at.gousoogames.dungeons.core.engine.character;

import java.util.ArrayList;

import at.gousoogames.dungeons.core.engine.skills.Effect;
import at.gousoogames.dungeons.core.engine.skills.effects.SkillEffect;
import at.gousoogames.dungeons.gdx.gui.output.controller.Debug;

public class Buffs {

	private ArrayList<Effect> activeEffects;
	
	public Buffs(){
		this.activeEffects = new ArrayList<Effect>();
	}
	
	public ArrayList<Effect> getActiveEffects(){
		return activeEffects;
	}
	
	public void addBuff(Effect e){
		if (e != SkillEffect.EMPTY_SKILL_EFFECT && e != SkillEffect.EMPTY_EFFECT){
			this.activeEffects.add(e);
		}
	}

	public void tick(GameCharacter c) {
		for (int i = 0; i < activeEffects.size(); i++){
			Effect e = activeEffects.get(i);
			if (e.getRemainingDuration() <= 0){
				activeEffects.remove(i);
			}else{
				e.useEffectOn(c);
				e.decreaseDuration();
				Debug.log("Buff "+e+" ticked on character "+c);
			}
		}
	}

	public Stats getCumulativeStats() {
		Stats st = new Stats();
		for (Effect e : activeEffects){
			Debug.log("Got Buff stats from "+e+" with "+e.getStats().strength+" str.");
			st.addToBase(e.getStats());
		}
		return st;
	}
}
