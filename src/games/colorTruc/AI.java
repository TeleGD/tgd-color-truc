package games.colorTruc;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import app.AppPlayer;

public class AI extends Character {

	public AI (int posX, int posY, int colorID) {
		super(posX, posY, colorID, "IA " + AppPlayer.COLOR_NAMES[colorID]);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		//TODO : décider des mouvements de l'IA
	}

}
