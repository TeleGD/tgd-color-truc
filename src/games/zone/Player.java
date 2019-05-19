package games.zone;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public class Player extends Character{

	private int controllerID;
	private float speedX;
	private float speedY;
	private float speed;
	
	public Player (int posX, int posY,AppPlayer appPlayer) {
		super(posX, posY, appPlayer.getColorID (), appPlayer.getName ());
		int controllerID = appPlayer.getControllerID ();
		this.controllerID = controllerID;
		this.speed=super.getSpeed();
	}

	public int getControllerID () {
		return this.controllerID;
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		AppInput input = (AppInput) container.getInput();
		
		//trigger = input.isControlPressed(AppInput.BUTTON_A, controllerID);
		move(input,delta);
	}

	public void move(AppInput input, int delta) {//Attention, là la vitesse du personnage est bien plus rapide en diagonale !
		speedX = input.getAxisValue(AppInput.AXIS_XL, controllerID) * speed;
		speedY = input.getAxisValue(AppInput.AXIS_YR, controllerID) * speed;
		posX += speedX*delta;
		posY += speedY*delta;
		
	}

}
