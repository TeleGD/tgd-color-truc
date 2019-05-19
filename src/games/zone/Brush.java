package games.zone;

public class Brush extends Weapon {
	public Brush(int capacity, int life, int power) {
		super(capacity, life, power);
	}
	
	public void shoot(int x0, int y0, double direction) {
		if (proj != null && !proj.hasDone()) return;
		proj = new Projectile(x0, y0, 0.05, direction, 200, 30, 0);
	}
}
