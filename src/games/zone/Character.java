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
	private boolean moveLeft, moveRight, moveUp,moveDown,trigger;
	
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
		moveLeft = input.isControlPressed(AppInput.BUTTON_LEFT,controllerID);
		moveRight = input.isControlPressed(AppInput.BUTTON_RIGHT,controllerID);
		moveUp = input.isControlPressed(AppInput.BUTTON_UP,controllerID);
		moveDown = input.isControlPressed(AppInput.BUTTON_DOWN,controllerID);
		trigger = input.isControlPressed(AppInput.BUTTON_A, controllerID);
		move(delta);
	}
	
	public void move(int delta) {//Attention, là la vitesse du personnage est bien plus rapide en diagonale !
		if(moveLeft) {
			posX=posX-1;
		}
		if(moveRight) {
			posX=posX-1;
		}
		if(moveUp) {
			posY=posY+1;
		}
		if(moveDown) {
			posY=posY-1;
		}
	}
	
}
