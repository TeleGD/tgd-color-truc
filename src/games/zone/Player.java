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
		super.move(input.getAxisValue(AppInput.AXIS_XL, controllerID), input.getAxisValue(AppInput.AXIS_YR, controllerID), delta);
		
	}

}
