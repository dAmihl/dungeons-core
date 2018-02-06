package at.gousoogames.dungeons.engine.skills;

import at.gousoogames.dungeons.engine.character.GameCharacter;

public class Effect {
	
	public static final Effect EMPTY_EFFECT = new Effect("", 0, EffectMethod.EMPTY_EFFECT_METHOD);

	protected int duration;
	private String effectName;
	protected int remainingDuration;
	private EffectMethod effectMethod;
	private EffectStats stats;
	
	public Effect(String name, int duration, EffectMethod effectMethod){
		this.effectName = name;
		this.duration = duration;
		this.remainingDuration = duration;
		this.effectMethod = effectMethod;
		this.stats = new EffectStats(); // TODO give buffs some stats
	}


	public void decreaseDuration(){
		this.remainingDuration--;
	}
	

	public int getDuration() {
		return duration;
	}

	public String getEffectName() {
		return effectName;
	}

	public int getRemainingDuration() {
		return remainingDuration;
	}
	
	public void useEffectOn(GameCharacter c){
		this.effectMethod.activateEffect(c);
	}
	
	public Effect reset(){
		this.remainingDuration = this.duration;
		return this;
	}
	
	
	public EffectStats getStats() {
		return stats;
	}
	
	public void setStats(EffectStats s){
		this.stats = s;
	}
	
}
