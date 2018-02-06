package at.gousoogames.dungeons.core.engine.character;

import java.util.ArrayList;

import at.gousoogames.dungeons.core.engine.skills.Skill;
import at.gousoogames.dungeons.core.engine.skills.magical.MagicalSkill;
import at.gousoogames.dungeons.core.engine.skills.physical.PhysicalSkill;
import at.gousoogames.dungeons.core.engine.skills.supportive.SupportiveSkill;
import at.gousoogames.dungeons.gdx.gui.output.controller.Debug;

public class Skillset {

	ArrayList<Skill> learnedSkills;
	private int physicalSkillAvgLevel = 0;
	private int magicalSkillAvgLevel = 0;
	private int supportSkillAvgLevel = 0;
	
	private BattleSkillset battleSkillset;
	
	public ArrayList<Skill> getLearnedSkills() {
		return learnedSkills;
	}

	public Skillset(){
		learnedSkills = new ArrayList<Skill>();
		this.battleSkillset = new BattleSkillset();
	}
	
	private boolean containsSkill(Skill s){
		for (Skill k: learnedSkills){
			if (k.getClass() == s.getClass()) return true;
		}
		return false;
	}
	
	public void learnSkill(Skill s){
		if (!containsSkill(s)){
			this.learnedSkills.add(s);
			computeAvgLevel();
		}else{
			Debug.log("Skill "+s+" already learned!");
		}
	}
	
	public boolean skillLeveledUpNewAverageLevel(Skill s){
		int old;
		if (s instanceof PhysicalSkill){
			old = physicalSkillAvgLevel;
			computeAvgLevel();
			return old < physicalSkillAvgLevel;
		}else if (s instanceof MagicalSkill){
			old = magicalSkillAvgLevel;
			computeAvgLevel();
			return old < magicalSkillAvgLevel;
		}else{
			old = supportSkillAvgLevel;
			computeAvgLevel();
			return old < supportSkillAvgLevel;
		}	
	}
	
	private void computeAvgLevel(){
		computePhysicalAvgLevel();
		computeMagicalAvgLevel();
		computeSupportAvgLevel();
		updateBattleSkillset();
	}
	
	private void updateBattleSkillset(){
		battleSkillset.resizeMagicalSkills(magicalSkillAvgLevel);
		battleSkillset.resizePhysicalSkills(physicalSkillAvgLevel);
		battleSkillset.resizeSupportiveSkills(supportSkillAvgLevel);	
	}
	
	
	
	
	
	
	private void computePhysicalAvgLevel(){
		int tmpLevel = 0;
		int count = 0;
		
		for (Skill s: learnedSkills){
			if (s instanceof PhysicalSkill){
				tmpLevel += s.getSkillLevel();
				count++;
			}
		}
		if (count > 0){
			this.physicalSkillAvgLevel = tmpLevel / count;
		}else{
			physicalSkillAvgLevel = 0;
		}
	}
	
	private void computeMagicalAvgLevel(){
		int tmpLevel = 0;
		int count = 0;
		
		for (Skill s: learnedSkills){
			if (s instanceof MagicalSkill){
				tmpLevel += s.getSkillLevel();
				count++;
			}
		}
		if (count > 0){
			this.magicalSkillAvgLevel = tmpLevel / count;
		}else{
			magicalSkillAvgLevel = 0;
		}
	}
	
	private void computeSupportAvgLevel(){
		int tmpLevel = 0;
		int count = 0;
		
		for (Skill s: learnedSkills){
			if (s instanceof SupportiveSkill){
				tmpLevel += s.getSkillLevel();
				count++;
			}
		}
		if (count > 0){
			this.supportSkillAvgLevel = tmpLevel / count;
		}else{
			supportSkillAvgLevel = 0;
		}
	}
	
	
	

	public void addSkillToBattleSkillset(Skill s){
		if (!learnedSkills.contains(s)){
			Debug.log("Skill "+s+" is not learned!");
		}else{
			battleSkillset.addSkill(s);
		}
	}
	
	
	
	
	public BattleSkillset getBattleSkillset(){
		return battleSkillset;
	}
	


	public int getPhysicalSkillAvgLevel() {
		return physicalSkillAvgLevel;
	}

	public int getMagicalSkillAvgLevel() {
		return magicalSkillAvgLevel;
	}

	public int getSupportSkillAvgLevel() {
		return supportSkillAvgLevel;
	}
	
}
