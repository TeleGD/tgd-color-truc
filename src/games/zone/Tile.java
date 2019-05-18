package games.zone;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;


public class Tile {

	static int size = 10;   // Taille (hauteur et largueur) d'une Tile en pixels

	private int type; /* Type de case */
	private Color color; /* Couleur de la peinture recouvrant */
	private int x, y;

	public Tile(int type, Color color, int i, int j) {
		this.x = j * size;
		this.y = i * size;
		this.setType(type);
		this.setColor(color);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics context) {
		//TODO : switch de type pour le render (nommer l'image en fonction du type)

		// Affichage de la couleur :
		context.setColor(color);
		context.fillRect(x, y, size, size);
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getType() {
		return this.type;
	}

	public Color getColor() {
		return this.color;
	}

}
