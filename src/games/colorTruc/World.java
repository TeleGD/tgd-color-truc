package games.colorTruc;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import app.AppGame;
import app.AppPlayer;
import app.AppWorld;

public class World extends AppWorld {

	private Character [] characters;
	private Board board;
	private ArrayList<Projectile> projectiles = new ArrayList<>();

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
		int n = appGame.appPlayers.size();
		this.characters = new Character[4];
		int colorIDs[] = new int[4];
		for (int i = 0; i < n; i++) {
			AppPlayer appPlayer = appGame.appPlayers.get(i);
			this.characters[i] = new Player(i*500,i*500,appPlayer);//TODO : Faire mieux.*
			colorIDs[i] = appPlayer.getColorID();
		}
		Random random = new Random();
		for (int i = n; i < 4; i++) {
			int colorID = random.nextInt(8);
			for (int j = 0; j < i; j++) {
				if (colorID == colorIDs[j]) {
					i--;
					break;
				}
			}
			this.characters[i] = new AI(i*500,i*500, colorID);//TODO : Faire mieux.*
		}

		this.board = new Board( (int) Math.floor(container.getWidth() / Tile.size), (int) Math.floor(container.getHeight() / Tile.size));
	}



	@Override
	public void stop (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois à la fin du jeu */
	}

	@Override
	public void resume (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la reprise du jeu */
	}

	@Override
	public void pause (GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la mise en pause du jeu */
	}

	@Override
	public void poll (GameContainer container, StateBasedGame game, Input user) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.poll (container, game, user);
		for (Character character: this.characters) {
			if (!(character instanceof Player)) {
				continue;
			}
			Player player = (Player) character;
			player.poll(container, game, user);
		}
	}

	public void addProjectile(Projectile proj) {
		projectiles.add(proj);
	}

	public void removeProjectile(Projectile proj) {
		projectiles.remove(proj);
	}

	@Override
	public void update (GameContainer container, StateBasedGame game, int delta) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.update (container, game, delta);
		for (Character character : characters) {
			character.update(container,game,delta);
		}
		for (Projectile proj : projectiles) {
			proj.update(container, game, delta);
		}
	}

	@Override
	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		/* Méthode exécutée environ 60 fois par seconde */
		super.render (container, game, context);
		board.render(container, game, context);

		for (Character character: characters) {
			character.render(container, game, context);
		}

		for (Projectile proj : projectiles) {
			proj.render(container, game, context);
		}
	}

	public Board getBoard() {
		return board;
	}

}
