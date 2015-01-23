package at.gousoogames.dungeons.engine.gameitems;

public class WeaponStats extends EquipStats {

	private int weaponDmg;
	
	public static final WeaponStats EMPTY_WEAPON_STATS = new WeaponStats(0,0,0,0,0,0);
	
	public WeaponStats(int armor, int vit, int str, int agi, int intell, int weaponDmg) {
		super(armor, vit, str, agi, intell);
		this.weaponDmg = weaponDmg;
	}

	public int getWeaponDmg() {
		return weaponDmg;
	}

}
