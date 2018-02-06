package at.gousoogames.dungeons.engine.gameitems;

public class StatRequirements {
	
	public static final StatRequirements emptyRequirement = new StatRequirements(0, 0, 0, 0);

	private int strengthRequ;
	private int vitalityRequ;
	private int agilityRequ;
	private int intelligenceRequ;
	
	public StatRequirements(int str, int vit, int agi, int intell){
		this.strengthRequ = str;
		this.vitalityRequ = vit;
		this.agilityRequ = agi;
		this.intelligenceRequ = intell;
	}
	
	
	

	public int getStrengthRequ() {
		return strengthRequ;
	}

	public int getVitalityRequ() {
		return vitalityRequ;
	}

	public int getAgilityRequ() {
		return agilityRequ;
	}

	public int getIntelligenceRequ() {
		return intelligenceRequ;
	}
	
	
	
	
}
