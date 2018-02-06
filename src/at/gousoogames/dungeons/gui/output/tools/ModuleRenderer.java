package at.gousoogames.dungeons.gui.output.tools;

import at.gousoogames.dungeons.engine.character.npc.enemies.BeastEnemy;
import at.gousoogames.dungeons.engine.character.npc.enemies.Enemy;
import at.gousoogames.dungeons.engine.character.npc.enemies.HumanoidEnemy;
import at.gousoogames.dungeons.engine.modules.Chest;
import at.gousoogames.dungeons.engine.modules.IModule;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ModuleRenderer {

	public static Texture renderModule(IModule mod){
		if (mod instanceof Enemy) return renderEnemy((Enemy)mod);
		if (mod instanceof Chest) return renderChest((Chest)mod);
		else return new Texture(Gdx.files.internal("badlogic.jpg"));

	}
	
	
	public static Texture renderEnemy(Enemy mod){
		if (mod instanceof HumanoidEnemy) return renderHumanoidEnemy((HumanoidEnemy)mod);
		if (mod instanceof BeastEnemy) return renderBeastEnemy((BeastEnemy)mod);
		return new Texture(Gdx.files.internal("simple_enemy_1.png"));
	}
	
	public static Texture renderHumanoidEnemy(HumanoidEnemy e){
		return new Texture(Gdx.files.internal("simple_enemy_1.png"));
	}
	
	public static Texture renderBeastEnemy(BeastEnemy s){
		return new Texture(Gdx.files.internal("simple_spider_1.png"));
	}
	
	public static Texture renderChest(Chest mod){
		return new Texture(Gdx.files.internal("simple_chest_1.png"));
	}
	
	
}
