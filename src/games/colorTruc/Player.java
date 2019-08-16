package games.colorTruc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public class Player extends Character{

	private int controllerID;
	private float speedX;
	private float speedY;
	private float speed;
	private float moveX;
	private float moveY;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;

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
		//AppInput input = (AppInput) container.getInput();

		//trigger = input.isControlPressed(AppInput.BUTTON_A, controllerID);
		if(up==true) {
			moveY=-1;
		}
		else if(down==true) {
			moveY=1;
		}
		else {
			moveY=0;
		}
		if(left==true) {
			moveX=-1;
		}
		else if(right==true) {
			moveX=1;
		}
		else {
			moveX=0;
		}
		super.move(moveX , moveY, delta);

	}

	public void poll (GameContainer container, StateBasedGame game, Input user) {
		AppInput input = (AppInput) user;
		up=input.isButtonPressed(AppInput.BUTTON_UP, this.controllerID);//moveX=input.getAxisValue(AppInput.AXIS_XL, controllerID);
		down=input.isButtonPressed(AppInput.BUTTON_DOWN, this.controllerID);
		left=input.isButtonPressed(AppInput.BUTTON_LEFT, this.controllerID);
		right=input.isButtonPressed(AppInput.BUTTON_RIGHT, this.controllerID);
		//moveY=input.getAxisValue(AppInput.AXIS_YR, controllerID);
		System.out.println(up+"; "+down+" ; "+left+" ; "+right);
		System.out.println(moveX+";"+moveY);
	}

}
