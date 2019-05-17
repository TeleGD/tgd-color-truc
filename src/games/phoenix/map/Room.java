package games.phoenix.map;

import java.util.ArrayList;

import games.phoenix.Enemy;

public class Room {
	
	private int difficulty;
	
	private ArrayList<Enemy> enemies = new ArrayList<>();

	/**
	 * Instancie l'objet Room selon sa difficulté
	 * 
	 * 1 - 4 : salle avec des ennemies (nombre et niveau des ennemies)
	 * 0 : salle de départ
	 * -1 : salle spéciale //TODO à définir
	 * @param difficulty
	 */
	public Room(int difficulty) {
		this.difficulty = difficulty;
		
		init();
	}
	
	
	
	/**
	 * Fonction initialisant la salle selon sa difficulté :
	 *  - ennemies
	 *  - décors
	 *  - obstacles
	 */
	private void init() {
		
		switch (difficulty) {
		case 0:
			
		case 1:
			
		}
		
		
	}
	
}
