package games.zone;

public class Projectile {
	private int reach;
	private int radius;
	private int shapeType;
	
	public Projectile(int reach, int radius, int shapeType) {
		this.reach = reach;
		this.radius = radius;
		this.shapeType = shapeType;
	}
	
	public void projection(float direction) {
		// direction = angle en radians
	}
}
