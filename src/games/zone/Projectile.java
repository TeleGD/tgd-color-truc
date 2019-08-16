package games.zone;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Projectile {
	private int reach;
	private int radius;
	private Shape shapeImpact;
	private int posX;
	private int posY;
	private double speed;
	private double direction;
	private double distance;
	private World world;
	private Color color;

	public Projectile(int x0, int y0, Color color, Shape shapeImpact, double speed, double direction, int reach, int radius, int shapeType, World world) {
		this.reach = reach;
		this.radius = radius;
		this.shapeImpact = shapeImpact;
		this.posX = x0;
		this.posY = y0;
		this.speed = speed;
		this.direction = direction;
		this.world = world;
		this.color = color;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		if (this.distance < reach) {
			double speedX = speed*Math.cos(direction);
			double speedY = speed*Math.sin(direction);
			this.posX += (int)(speedX*delta);
			this.posY += (int)(speedY*delta);
			this.distance += speed*delta;
		}
	}

	public boolean hasDone() {
		return this.distance >= reach;
	}
	
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		context.setColor(Color.black);
		// TODO: formes différentes en fonction de shapeImpact
		context.fillRect(posX, posY, 16, 16);
	}

	public void explode(){
		// Gestion des collision entre la zone d'impact et les cases pour les colorier :
		Point maxCasePoint = Tile.getCoordTile(shapeImpact.getMaxX(), shapeImpact.getMaxY());
		Point minCasePoint = Tile.getCoordTile(shapeImpact.getMinX(), shapeImpact.getMinY());

		for (int i = (int) maxCasePoint.getY(); i <= minCasePoint.getY() ; i ++){
			for (int j = (int) maxCasePoint.getX() ; j <= minCasePoint.getX() ; j++){
				if (shapeImpact.contains(i*Tile.size + Tile.size/2f, j*Tile.size + Tile.size/2f)){
					world.getBoard().getBoard()[i][j].setColor(color);
				}
			}
		}

		//TODO : retirer ce projectile de world !

	}



}
