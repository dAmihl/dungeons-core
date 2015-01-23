package at.gousoogames.dungeons.engine.character;

import at.gousoogames.dungeons.engine.gameitems.*;
import at.gousoogames.dungeons.engine.gameitems.armor.AmuletArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.BreastArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.FootArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.HeadArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.LegArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.RingArmor;
import at.gousoogames.dungeons.engine.gameitems.armor.ShoulderArmor;
import at.gousoogames.dungeons.engine.gameitems.weapons.OffhandWeapon;
import at.gousoogames.dungeons.engine.gameitems.weapons.OneHandWeapon;
import at.gousoogames.dungeons.engine.gameitems.weapons.TwoHandWeapon;
import at.gousoogames.dungeons.engine.gameitems.weapons.Weapon;

public class Equipment {
	
	private final static String emptySlotText = "empty";

	public final static HeadArmor emptyHeadSlot = new HeadArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static ShoulderArmor emptyShoulderSlot = new ShoulderArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static BreastArmor emptyBreastSlot = new BreastArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static LegArmor emptyLegSlot = new LegArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static FootArmor emptyFootSlot = new FootArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);

	public final static RingArmor emptyLRingSlot = new RingArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static RingArmor emptyRRingSlot = new RingArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);
	public final static AmuletArmor emptyAmuletSlot = new AmuletArmor(emptySlotText, ArmorStats.EMPTY_ARMOR_STATS, StatRequirements.emptyRequirement);

	public final static Weapon emptyMainWeaponSlot = new Weapon(emptySlotText, WeaponStats.EMPTY_WEAPON_STATS, StatRequirements.emptyRequirement);
	public final static Weapon emptyOffWeaponSlot = new Weapon(emptySlotText, WeaponStats.EMPTY_WEAPON_STATS, StatRequirements.emptyRequirement);

	
	private HeadArmor head = emptyHeadSlot;
	private ShoulderArmor shoulder = emptyShoulderSlot;
	private BreastArmor breast = emptyBreastSlot;
	private LegArmor pants = emptyLegSlot;
	private FootArmor shoes = emptyFootSlot;
	
	private RingArmor leftRing = emptyLRingSlot;
	private RingArmor rightRing = emptyRRingSlot;
	private AmuletArmor amulet = emptyAmuletSlot;
	
	private Weapon mainHandWeapon = emptyMainWeaponSlot;
	private Weapon offHandWeapon = emptyOffWeaponSlot;
	
	
	/*
	 * Equips an item on the right place
	 */
	public Item equipItem(Equipable eq){
		Equipable old = null;
		if (eq instanceof HeadArmor){
			old = this.head;
			this.head = (HeadArmor) eq;
		}
		if (eq instanceof ShoulderArmor){
			old = this.shoulder;
			this.shoulder = (ShoulderArmor) eq;
		}
		if (eq instanceof BreastArmor){
			old = this.breast;
			this.breast = (BreastArmor) eq;
		}
		if (eq instanceof LegArmor){
			old = this.pants;
			this.pants = (LegArmor) eq;
		}
		if (eq instanceof FootArmor){
			old = this.shoes;
			this.shoes = (FootArmor) eq;
		}
		if (eq instanceof AmuletArmor){
			old = this.amulet;
			this.amulet = (AmuletArmor) eq;
		}
		
		if (eq instanceof RingArmor){
			if (this.leftRing == emptyLRingSlot){
				old = this.leftRing;
				this.leftRing = (RingArmor) eq;
			}
			else{
					if (this.rightRing == emptyRRingSlot) this.rightRing = (RingArmor) eq;
					else {
						old = this.leftRing;
						this.leftRing = (RingArmor) eq;
					}
			}
		}

		if (eq instanceof Weapon){
			if (eq instanceof OneHandWeapon){ // TODO
				if (this.mainHandWeapon == emptyMainWeaponSlot || this.mainHandWeapon instanceof TwoHandWeapon) {
					old = this.mainHandWeapon;
					this.mainHandWeapon = (Weapon) eq;
				}
				else{
					if (this.offHandWeapon == emptyOffWeaponSlot){
						old = this.offHandWeapon;
						this.offHandWeapon = (Weapon) eq;
					}
					else {
						old = this.mainHandWeapon;
						this.mainHandWeapon = (Weapon) eq;
					}
				}
			}
			if (eq instanceof OffhandWeapon){
				old = this.offHandWeapon;
				this.offHandWeapon = (Weapon) eq;
				if (this.mainHandWeapon instanceof TwoHandWeapon) this.mainHandWeapon = emptyMainWeaponSlot;
			}
			if (eq instanceof TwoHandWeapon){
				old = this.mainHandWeapon;
				this.mainHandWeapon = (Weapon) eq;
				this.offHandWeapon = emptyOffWeaponSlot;
			}
			
		}
		return getOldEquipment(old);
	}
	
	
	private Item getOldEquipment(Equipable old){
		
		Item computedItem = null;
		
		if (old == emptyAmuletSlot || old == emptyBreastSlot || old == emptyFootSlot || old == emptyHeadSlot
				|| old == emptyLegSlot || old == emptyLRingSlot || old == emptyRRingSlot || old == emptyMainWeaponSlot
				|| old == emptyOffWeaponSlot || old == emptyShoulderSlot || old == null){
			
			computedItem = Item.EMPTY_ITEM;
			
		}else{
			computedItem = old;
		}	
		
		return computedItem;
	}
	
	
	/*
	 * These functions compute and return the cumulative stats
	 */
	
	public Stats getCumulativeStats(){
		Stats cumulStats = new Stats();
		cumulStats.addToBase(this.head.getStats());
		cumulStats.addToBase(this.shoulder.getStats());
		cumulStats.addToBase(this.breast.getStats());
		cumulStats.addToBase(this.pants.getStats());
		cumulStats.addToBase(this.shoes.getStats());
		cumulStats.addToBase(this.leftRing.getStats());
		cumulStats.addToBase(this.rightRing.getStats());
		cumulStats.addToBase(this.amulet.getStats());
		cumulStats.addToBase(this.mainHandWeapon.getStats());
		cumulStats.addToBase(this.offHandWeapon.getStats());

		return cumulStats;
	}
	
	/* TODO : DEPRECATED?
	public int getCumulativeStrength(){
		int val = 0;
		val += this.head.getStats().getStrength();
		val += this.shoulder.getStats().getStrength();
		val += this.breast.getStats().getStrength();
		val += this.pants.getStats().getStrength();
		val += this.shoes.getStats().getStrength();
		val += this.leftRing.getStats().getStrength();
		val += this.rightRing.getStats().getStrength();
		val += this.getAmulet().getStats().getStrength();
		val += this.getMainHandWeapon().getStats().getStrength();
		val += this.getOffHandWeapon().getStats().getStrength();
		
		return val;
	}
	
	public int getCumulativeArmor(){
		int val = 0;
		val += this.head.getStats().getArmor();
		val += this.shoulder.getStats().getArmor();
		val += this.breast.getStats().getArmor();
		val += this.pants.getStats().getArmor();
		val += this.shoes.getStats().getArmor();
		val += this.leftRing.getStats().getArmor();
		val += this.rightRing.getStats().getArmor();
		val += this.getAmulet().getStats().getArmor();
		val += this.getMainHandWeapon().getStats().getArmor();
		val += this.getOffHandWeapon().getStats().getArmor();
		
		return val;
	}
	
	public int getCumulativeVitality(){
		int val = 0;
		val += this.head.getStats().getVitality();
		val += this.shoulder.getStats().getVitality();
		val += this.breast.getStats().getVitality();
		val += this.pants.getStats().getVitality();
		val += this.shoes.getStats().getVitality();
		val += this.leftRing.getStats().getVitality();
		val += this.rightRing.getStats().getVitality();
		val += this.getAmulet().getStats().getVitality();
		val += this.getMainHandWeapon().getStats().getVitality();
		val += this.getOffHandWeapon().getStats().getStrength();
		
		return val;
	}
	
	public int getCumulativeAgility(){
		int val = 0;
		val += this.head.getStats().getAgility();
		val += this.shoulder.getStats().getAgility();
		val += this.breast.getStats().getAgility();
		val += this.pants.getStats().getAgility();
		val += this.shoes.getStats().getAgility();
		val += this.leftRing.getStats().getAgility();
		val += this.rightRing.getStats().getAgility();
		val += this.getAmulet().getStats().getAgility();
		val += this.getMainHandWeapon().getStats().getAgility();
		val += this.getOffHandWeapon().getStats().getAgility();
		
		return val;
	}
	
	public int getCumulativeIntelligence(){
		int val = 0;
		val += this.head.getStats().getIntelligence();
		val += this.shoulder.getStats().getIntelligence();
		val += this.breast.getStats().getIntelligence();
		val += this.pants.getStats().getIntelligence();
		val += this.shoes.getStats().getIntelligence();
		val += this.leftRing.getStats().getIntelligence();
		val += this.rightRing.getStats().getIntelligence();
		val += this.getAmulet().getStats().getIntelligence();
		val += this.getMainHandWeapon().getStats().getIntelligence();
		val += this.getOffHandWeapon().getStats().getIntelligence();
		
		return val;
	}
	*/
	
	/*
	 * GETTERS ND SETTERS
	 */
	public HeadArmor getHead() {
		return head;
	}
	public void setHead(HeadArmor head) {
		this.head = head;
	}
	public ShoulderArmor getShoulder() {
		return shoulder;
	}
	public void setShoulder(ShoulderArmor shoulder) {
		this.shoulder = shoulder;
	}
	public BreastArmor getBreast() {
		return breast;
	}
	public void setBreast(BreastArmor breast) {
		this.breast = breast;
	}
	public LegArmor getPants() {
		return pants;
	}
	public void setPants(LegArmor pants) {
		this.pants = pants;
	}
	public FootArmor getShoes() {
		return shoes;
	}
	public void setShoes(FootArmor shoes) {
		this.shoes = shoes;
	}
	public RingArmor getLeftRing() {
		return leftRing;
	}
	public void setLeftRing(RingArmor leftRing) {
		this.leftRing = leftRing;
	}
	public RingArmor getRightRing() {
		return rightRing;
	}
	public void setRightRing(RingArmor rightRing) {
		this.rightRing = rightRing;
	}
	public AmuletArmor getAmulet() {
		return amulet;
	}
	public void setAmulet(AmuletArmor amulet) {
		this.amulet = amulet;
	}
	public Weapon getMainHandWeapon() {
		return mainHandWeapon;
	}
	public void setMainHandWeapon(Weapon leftHandWeapon) {
		this.mainHandWeapon = leftHandWeapon;
	}
	public Weapon getOffHandWeapon() {
		return offHandWeapon;
	}
	public void setOffHandWeapon(Weapon rightHandWeapon) {
		this.offHandWeapon = rightHandWeapon;
	}
	
	
}
