package games.zone;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Projectile {
	private int reach;
	private int radius;
	private int shapeType;
	private int posX;
	private int posY;
	private double speed;
	private double direction;
	
	public Projectile(int x0, int y0, double speed, double direction, int reach, int radius, int shapeType) {
		this.reach = reach;
		this.radius = radius;
		this.shapeType = shapeType;
		this.posX = x0;
		this.posY = y0;
		this.speed = speed;
		this.direction = direction;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		double speedX = speed*Math.cos(direction);
		double speedY = speed*Math.sin(direction);
		this.posX += (int)(speedX*delta);
		this.posY += (int)(speedY*delta);
	}
	
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(Color.black);
		// TODO: formes différentes en fonction de shapeType
		context.fillRect(posX, posY, 16, 16);
	}
}
