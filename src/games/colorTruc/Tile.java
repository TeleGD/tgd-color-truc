package games.colorTruc;

import app.AppLoader;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Tile {

	public static int size = 10;   // Taille (hauteur et largueur) d'une Tile en pixels

	private static int nbTypes = 5; //
	private static Image[] typeImages = new Image[nbTypes];
	static {
		// Chargements des sprites dans les cases :
		SpriteSheet spriteSheet = null;
		Image spriteImage = AppLoader.loadPicture("/images/terrain_atlas.png");
		spriteSheet = new SpriteSheet(spriteImage, 32, 32);

		typeImages[0] = spriteSheet.getSprite(31,11); // rien
		typeImages[1] = spriteSheet.getSprite(14,16);   //Pont
		typeImages[2] = spriteSheet.getSprite(5,1); // Dénivelé
		typeImages[3] = spriteSheet.getSprite(22,12);   //Rivière
		typeImages[4] = spriteSheet.getSprite(13,14);   // Pierre
	}

	private int type; /* Type de case */
	private Color color; /* Couleur de la peinture recouvrant */
	private int x, y;
	private Shape shape;    // Shape pour les collisions

	public Tile(int type, Color color, int i, int j) {
		this.x = j * size;
		this.y = i * size;
		this.setType(type);
		this.setColor(color);
		this.shape = new Rectangle(this.x, this.y, size, size);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics context) {

		// TODO : mettre des images stylées à la place des différentes couleurs :
		// Affichage de la case :
		context.drawImage(typeImages[type], x, y, x+size, y+size, 0, 0, typeImages[type].getWidth(), typeImages[type].getHeight());

		// Affichage de la couleur de peinture:
		if (color != null){
			context.setColor(color);
			context.fillRect(x, y, size, size);
		}

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

	/**
	 * Renvoit la position (i,j) de la case dans le board contenant le point (x,y)
	 * @param x
	 * @param y
	 * @return
	 */
	public static Point getCoordTile(float x, float y){
		int i, j;
		i = (int) x / size;
		j = (int) y / size;
		return (new Point(i, j));
	}

	public Shape getShape() {
		return shape;
	}

}
