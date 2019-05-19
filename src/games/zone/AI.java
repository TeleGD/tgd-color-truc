package games.zone;

import app.AppPlayer;

public class AI extends Character {

	public AI (int posX, int posY, int colorID) {
		super(posX, posY, colorID, "IA " + AppPlayer.COLOR_NAMES[colorID]);
	}

}
