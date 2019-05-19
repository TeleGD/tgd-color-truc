package games.zone;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public abstract class Character {

	private int life;
	protected int posX;
	protected int posY;
	private float speed;
	private float speedX;
	private float speedY;
	private int width;
	private int height;
	
	private Weapon weapon;
	private float alpha;
	private Color fillColor;
	private Color strokeColor;
	private Color fillColorAlpha;
	private Color strokeColorAlpha;

	public Character(int posX, int posY, int colorID) {
		this.life = 100;
		this.posX = posX;
		this.posY = posY;
		this.speed = 1;
		this.width=50;
		this.height=50;
		this.weapon = new Brush(100,100,20);
		this.alpha = .5f;
		this.fillColor = AppPlayer.FILL_COLORS [colorID];
		this.strokeColor = AppPlayer.STROKE_COLORS [colorID];
		this.fillColorAlpha = new Color(this.fillColor.r, this.fillColor.g, this.fillColor.b, this.alpha);
		this.strokeColorAlpha = new Color(this.strokeColor.r, this.strokeColor.g, this.strokeColor.b, this.alpha);
	}


	public void render(GameContainer container, StateBasedGame game, Graphics context){
		context.setColor(this.fillColorAlpha);
		context.fillOval(posX, posY, width, height);
		context.setColor(this.strokeColorAlpha);
		context.drawOval(posX, posY, width, height);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		
		posX += speedX*delta;
		
		posY += speedY*delta;
	}
	
	public void poll (GameContainer container, StateBasedGame game, Input user) {
		
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
		this.fillColorAlpha = new Color(this.fillColor.r, this.fillColor.g, this.fillColor.b, this.alpha);
		this.strokeColorAlpha = new Color(this.strokeColor.r, this.strokeColor.g, this.strokeColor.b, this.alpha);
	}

	public float getAlpha() {
		return this.alpha;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed=speed;
	}

	public float getSpeedX() {
		return this.speedX;
	}
	
	public float getSpeedY() {
		return this.speedY;
	}

	public void setSpeedX(float speedX) {
		this.speedX=speedX;
	}
	
	public void setSpeedY(float speedY) {
		this.speedY=speedY;
	}
}