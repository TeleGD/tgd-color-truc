package games.zone;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppInput;
import app.AppPlayer;

public class Player extends Character{

	private int controllerID;
	private String name;
	
	private float speed;
	
	public Player (int posX, int posY,AppPlayer appPlayer) {
		super(posX,posY,appPlayer.getColorID ());
		int controllerID = appPlayer.getControllerID ();
		String name = appPlayer.getName ();
		this.controllerID = controllerID;
		this.name = name;
		this.speed = super.getSpeed();

	}

	public int getControllerID () {
		return this.controllerID;
	}

	public String getName () {
		return this.name;
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		super.update(container, game, delta);
	}
	
	public void poll (GameContainer container, StateBasedGame game, Input user) {
		move(user);
	}
	private void move(Input input){
		//System.out.println(input.getAxisValue(input.AXIS_XL, controllerID));
		//System.out.println(input.getAxisValue(input.AXIS_XL, controllerID) * speed);
		AppInput appInput= (AppInput) input;
		System.out.println(input.getAxisValue(appInput.AXIS_XL, controllerID));
		super.setSpeedX(input.getAxisValue(AppInput.AXIS_XL, controllerID) * speed);
		super.setSpeedY(input.getAxisValue(AppInput.AXIS_YR, controllerID) * speed);

		System.out.println(posX+" ; "+posY+" ; "+super.getSpeedX()+" ; "+super.getSpeedY());
	}
	

}
