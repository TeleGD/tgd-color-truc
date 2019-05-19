package games.zone;

import org.newdawn.slick.Image;

import app.AppLoader;

public abstract class Weapon {
	private int capacity;
	private int life;
	private int power;
	private Image img = AppLoader.loadPicture("default.png");
	protected Projectile proj;
	protected World world;
	
	public Weapon(int capacity, int life, int power, World world) {
		this.capacity = capacity;
		this.life = life;
		this.power = power;
		this.world = world;
	}
	
	public abstract void shoot(int x0, int y0, double direction);
}
