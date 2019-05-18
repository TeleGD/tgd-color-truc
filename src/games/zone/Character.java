package games.zone;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public abstract class Character {
	private int life;
	protected int posX;
	protected int posY;
	private float speed;
	private int width;
	private int height;
	private Color color;
	private Weapon weapon;
	
	public Character(int posX, int posY, AppPlayer appPlayer) {
		this.life = 100;
		this.posX = posX;
		this.posY = posY;
		this.speed = 0;
		this.width=50;
		this.height=50;
		color=Color.blue;
		this.weapon = new Brush(100,100,20);
	}
	
	
	public void render(GameContainer container, StateBasedGame game, Graphics context){
		context.setColor(color);
		context.fillOval(posX, posY, width, height);
	}
	
	
	
	
	
}
