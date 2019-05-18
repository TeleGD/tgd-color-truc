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

		// TODO : mettre des images stylées à la place des différentes couleurs :
		// Affichage de la case :
		switch (type){
			case 0 : context.setColor(Color.white); // rien
				break;
			case 1 : context.setColor(Color.black); // pont
				break;
			case 2 : context.setColor(Color.darkGray); // dénivelé
				break;
			case 3 : context.setColor(Color.blue); // rivière
				break;
			case 4 : context.setColor(Color.gray); // pierre
				break;
			default: context.setColor(Color.transparent);
		}
		context.fillRect(x, y, size, size);

		// Affichage de la couleur de peinture:
		context.setColor(color);
		context.fillRect(x, y, size, size);

		// Quadrillage :
		//TODO : ne plus l'afficher plus tard
		context.setColor(Color.red);
		context.drawRect(x, y, size, size);
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
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isWalkable(){
		if (type >= 3){ // Seuls les 3 premiers types peuvent être marché dessus
			return false;
		} else {
			return true;
		}
	}

}
