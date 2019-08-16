package games.colorTruc;

public class Brush extends Weapon {

	public Brush(int capacity, int life, int power, World world) {
		super(capacity, life, power, world);
	}

	public void shoot(int x0, int y0, double direction) {
		if (proj != null && !proj.hasDone()) return;
		proj = new Projectile(x0, y0, this.color, null, 0.05, direction, 200, 30, 0, world);
		world.addProjectile(proj);
	}

}
