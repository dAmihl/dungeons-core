package at.gousoogames.dungeons.engine.world;

import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.engine.modules.IModule;





public abstract class Room {

	private int numberModules;
	
	private Enemy[] enemies;
	
	private IModule[] modules;
	
	public Room(int numModules, IModule... modules){
		this.numberModules = numModules;
		this.modules = new IModule[numberModules];
		for (int i = 0; i < numberModules; i++){
			this.modules[i] = modules[i]; 
		}
		enemies = getEnemiesInModules();
	}

	public int getNumberModules() {
		return numberModules;
	}
	
	private Enemy[] getEnemiesInModules(){
		int size = countEnemyModules();
		Enemy[] res = new Enemy[size];
		int i = 0;
		for (IModule m : modules){
			if (m instanceof Enemy){
				res[i++] = (Enemy) m;
			}
		}
		return res;
	}

	public IModule[] getModules() {
		return modules;
	}
	
	private int countEnemyModules(){
		int count = 0;
		for (IModule m : modules){
			if (m instanceof Enemy){
				count++;
			}
		}
		return count;
	}
	
	public Enemy[] getEnemies(){
		return enemies;
	}
	
	
}
