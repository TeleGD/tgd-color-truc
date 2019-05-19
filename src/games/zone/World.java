package games.zone;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppGame;
import app.AppInput;
import app.AppWorld;

public class World extends AppWorld {
	
	private Player [] players;
	private Character [] characters;
	private String log;
	private Board board;

	public World (int ID) {
		super (ID);
	}

	@Override
	public void init (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au chargement du programme */
		super.init (container, game);
	}

	@Override
	public void play (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au début du jeu */
		AppGame appGame = (AppGame) game;
		int n = appGame.appPlayers.size ();
		this.players = new Player [n];
		this.characters = new Character[4];// Nombre de personnages(joueurs et IA)
		for (int i = 0; i < n; i++) {
			this.players [i] = new Player (i*500,i*500,appGame.appPlayers.get (i));//TODO : Faire mieux.
			this.characters[i] = players[i];
		}
		this.log = "";
		System.out.println ("PLAY");

		this.board = new Board( (int) Math.floor(container.getWidth() / Tile.size), (int) Math.floor(container.getHeight() / Tile.size));
	}

	@Override
	public void stop (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois à la fin du jeu */
		System.out.println ("STOP");
	}

	@Override
	public void resume (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la reprise du jeu */
		System.out.println ("RESUME");
	}

	@Override
	public void pause (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la mise en pause du jeu */
		System.out.println ("PAUSE");
	}

	@Override
	public void poll (GameContainer container, StateBasedGame game, Input user) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.poll (container, game, user);
		AppInput input = (AppInput) user;
		this.log = "";
		for (Player player: this.players) {
			//player.poll(container, game, user);
			String name = player.getName ();
			int controllerID = player.getControllerID ();
			for (int i = 0, l = input.getControlCount (controllerID); i < l; i++) {
				if (input.isControlPressed (1 << i, controllerID)) {
					this.log += "(" + name + ").isControlPressed: " + i + "\n";
				}
			}
			for (int i = 0, l = input.getButtonCount (controllerID); i < l; i++) {
				if (input.isButtonPressed (1 << i, controllerID)) {
					this.log += "(" + name + ").isButtonPressed: " + i + "\n";
				}
			}
			for (int i = 0, l = input.getAxisCount (controllerID); i < l; i++) {
				float j = input.getAxisValue (i, controllerID);
				if (j <= -.5f || j >= .5f) {
					this.log += "(" + name + ").getAxisValue: " + i + " -> " + j + "\n";
				}
			}
		}
	}

	@Override
	public void update (GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.update (container, game, delta);
		for(Player player : players) {
			player.update(container, game, delta);
		}
	}

	@Override
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.render (container, game, context);
		if (this.log.length () != 0) {
			System.out.print (this.log);
		}
		board.render(container, game, context);
			
		for (Player player : players) {
			player.render(container, game, context);
		}
		
	}

}
