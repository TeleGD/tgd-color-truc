package games.zone;

import org.newdawn.slick.Color;

public class Tile {

	private int type; /* Type de case */
	private Color color; /* Couleur de la peinture recouvrant */

	public Tile(int type, Color color) {
		this.setType(type);
		this.setColor(color);
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
