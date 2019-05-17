package games.zone;




import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Character {
	private int life;
	private int posX;
	private int posY;
	private float speed;
	private int width;
	private int height;
	private Color color;
	
	public Character(int posX, int posY) {
		this.life = 100;
		this.posX = posX;
		this.posY = posY;
		this.speed = 0;
		this.width=50;
		this.height=50;
		color=Color.blue;
	}
	
	
	public void render(GameContainer container, StateBasedGame game, Graphics context){
		context.setColor(color);
		context.fillOval(posX, posY, width, height);
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		//move(delta);
	}

}
