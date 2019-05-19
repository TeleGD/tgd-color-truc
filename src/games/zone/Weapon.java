package games.zone;

import org.newdawn.slick.Image;

import app.AppLoader;

public abstract class Weapon {
	private int capacity;
	private int life;
	private int power;
	private Image img = AppLoader.loadPicture("default.png");
	protected int reach;
	protected int radius;
	
	public Weapon(int capacity, int life, int power) {
		this.capacity = capacity;
		this.life = life;
		this.power = power;
	}
	
	
}
