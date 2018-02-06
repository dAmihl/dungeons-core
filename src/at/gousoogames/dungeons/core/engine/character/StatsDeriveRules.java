package at.gousoogames.dungeons.core.engine.character;

public class StatsDeriveRules {

	private static final float HP_VIT_FACTOR = 10.f;
	private static final float MP_INT_FACTOR = 7.f;
	private static final float EVASION_AGI_FACTOR = 0.2f;
	private static final float HITCHANCE_AGI_FACTOR = 1f;
	
	
	public static void deriveStats(CharacterStats s){
		deriveHP(s);
		deriveMP(s);
		deriveEvasion(s);
		deriveHitChance(s);
	}
	
	private static void deriveHP(CharacterStats s){
		int hp = (int) (s.getVitality() * HP_VIT_FACTOR);
		s.setHealthPoints(hp);
	}
	
	private static void deriveMP(CharacterStats s){
		int mp =  (int) (s.getStrength() * MP_INT_FACTOR);
		s.setManaPoints(mp);
	}
	
	private static void deriveEvasion(CharacterStats s){
		int er =  (int) (s.getAgility() * EVASION_AGI_FACTOR);
		s.setEvasionRating(er);
	}
	
	private static void deriveHitChance(CharacterStats s){
		int hc =  (int) ((int) 50 + (s.getAgility() * HITCHANCE_AGI_FACTOR));
		s.setHitChance(hc);
	}
	
}
