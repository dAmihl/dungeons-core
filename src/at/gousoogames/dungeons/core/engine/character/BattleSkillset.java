package at.gousoogames.dungeons.core.engine.character;

import java.util.ArrayList;

import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.engine.skills.magical.MagicalSkill;
import at.gousoogames.dungeons.core.engine.skills.physical.PhysicalSkill;
import at.gousoogames.dungeons.core.engine.skills.supportive.SupportiveSkill;
import at.gousoogames.dungeons.core.game.gamemodes.GamemodeManager;
import at.gousoogames.dungeons.gdx.gui.output.controller.OutputFactory;

public class BattleSkillset {

	private int numPhysicalActiveSkills;
	private int numMagicalActiveSkills;
	private int numSupportiveActiveSkills;
	
	private ArrayList<PhysicalSkill> physicalSkills;
	private ArrayList<MagicalSkill> magicalSkills;
	private ArrayList<SupportiveSkill> supportiveSkills;
	
	
	public BattleSkillset(){
		physicalSkills = new ArrayList<PhysicalSkill>();
		magicalSkills = new ArrayList<MagicalSkill>();
		supportiveSkills = new ArrayList<SupportiveSkill>();
		numPhysicalActiveSkills = GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_PHYSICAL();
		numMagicalActiveSkills = GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_MAGICAL();
		numSupportiveActiveSkills = GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_SUPPORTIVE();

	}
	
	
	public void addSkill(Skill s){
		if (s instanceof PhysicalSkill){
			addSkill((PhysicalSkill) s);
		}else if (s instanceof MagicalSkill){
			addSkill((MagicalSkill) s);
		}else if (s instanceof SupportiveSkill){
			addSkill((SupportiveSkill) s);
		}
	}
	
	private boolean containsMagicalSkill(MagicalSkill s){
		for (MagicalSkill k: magicalSkills){
			if (k == s) return true;
		}
		return false;
	}
	
	private boolean containsPhysicalSkill(PhysicalSkill s){
		for (PhysicalSkill k: physicalSkills){
			if (k == s) return true;
		}
		return false;
	}
	
	// TODO returns true even if no supportive skill learned yet ?!?!?!
	private boolean containsSupportiveSkill(SupportiveSkill s){
		for (SupportiveSkill k: supportiveSkills){
			if (k == s) return true;
		}
		return false;
	}
	
	
	private void addSkill(MagicalSkill s){
		if (magicalSkills.size() < numMagicalActiveSkills && !containsMagicalSkill(s)){
			magicalSkills.add(s);
		}else{
			OutputFactory.getOutput().showErrorMessage("Skill "+s.getSkillName()+" not added to battle skillset. No space left or already added");
		}
	}
	
	private void addSkill(PhysicalSkill s){
		if (physicalSkills.size() < numPhysicalActiveSkills && !containsPhysicalSkill(s)){
			physicalSkills.add(s);
		}else{
			OutputFactory.getOutput().showErrorMessage("Skill "+s.getSkillName()+" not added to battle skillset. No space left or already added");
		}
	}
	
	private void addSkill(SupportiveSkill s){
		if (supportiveSkills.size() < numSupportiveActiveSkills && !containsSupportiveSkill(s)){
			supportiveSkills.add(s);
		}else{
			OutputFactory.getOutput().showErrorMessage("Skill "+s.getSkillName()+" not added to battle skillset. No space left or already added");
		}
	}
	
	
	
	
	
	
	public void resizePhysicalSkills(int physLevel){
		numPhysicalActiveSkills = (int) (GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_PHYSICAL() + 
				(physLevel * GamemodeManager.getGamemode().getBATTLE_SKILLSET_NUM_PHYSICAL_LEVEL_FACTOR()));
	}
	
	public void resizeMagicalSkills(int magLevel){
		numMagicalActiveSkills = (int) (GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_MAGICAL() + 
				(magLevel * GamemodeManager.getGamemode().getBATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR()));
	
	}
	
	public void resizeSupportiveSkills(int suppLevel){
		numSupportiveActiveSkills = (int) (GamemodeManager.getGamemode().getBATTLE_SKILLSET_INIT_NUM_MAGICAL() + 
				(suppLevel * GamemodeManager.getGamemode().getBATTLE_SKILLSET_NUM_MAGICAL_LEVEL_FACTOR()));
	
	}
	
	
	public ArrayList<PhysicalSkill> getPhysicalSkills(){
		return physicalSkills;
	}
	
	public ArrayList<MagicalSkill> getMagicalSkills(){
		return magicalSkills;
	}
	
	public ArrayList<SupportiveSkill> getSupportiveSkills(){
		return supportiveSkills;
	}
	
}
