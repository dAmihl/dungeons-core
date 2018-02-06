package at.gousoogames.dungeons.core.engine.gameitems;

public class ArmorStats extends EquipStats {

	public static final ArmorStats EMPTY_ARMOR_STATS = new ArmorStats(0,0,0,0,0);
	
	public ArmorStats(int armor, int vit, int str, int agi, int intell) {
		super(armor, vit, str, agi, intell);
	}

}
