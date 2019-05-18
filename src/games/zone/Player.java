package games.zone;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public class Player extends Character{

	private Color fillColor;
	private Color strokeColor;
	private int controllerID;
	private String name;
	private boolean moveLeft, moveRight, moveUp,moveDown;//,trigger;
	
	public Player (int posX, int posY,AppPlayer appPlayer) {
		super(posX,posY,appPlayer);
		int colorID = appPlayer.getColorID ();
		int controllerID = appPlayer.getControllerID ();
		String name = appPlayer.getName ();
		this.fillColor = AppPlayer.FILL_COLORS [colorID];
		this.strokeColor = AppPlayer.STROKE_COLORS [colorID];
		this.controllerID = controllerID;
		this.name = name;
	
	}

	public int getControllerID () {
		return this.controllerID;
	}

	public String getName () {
		return this.name;
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) {
		AppInput input = (AppInput) container.getInput();
		moveLeft = input.isControlPressed(AppInput.BUTTON_LEFT,controllerID);
		moveRight = input.isControlPressed(AppInput.BUTTON_RIGHT,controllerID);
		moveUp = input.isControlPressed(AppInput.BUTTON_UP,controllerID);
		moveDown = input.isControlPressed(AppInput.BUTTON_DOWN,controllerID);
		//trigger = input.isControlPressed(AppInput.BUTTON_A, controllerID);
		move(delta);
	}
	
	public void move(int delta) {//Attention, là la vitesse du personnage est bien plus rapide en diagonale !
		if(moveLeft) {
			super.posX=posX-1;
		}
		if(moveRight) {
			super.posX=posX-1;
		}
		if(moveUp) {
			super.posY=posY+1;
		}
		if(moveDown) {
			super.posY=posY-1;
		}
	}

}
