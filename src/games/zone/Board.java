package games.zone;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Board {
	private Tile[][] board;

	public Board(int widthLen, int heightLen){
		board = new Tile[heightLen][widthLen];
	}

	public void initBoard(){
		//TODO : init procédural (avec de la diversité)
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[0].length ; j++){
				board[i][j] = new Tile(0, null, i, j);
			}
		}
	}

	public void render (GameContainer container, StateBasedGame game, Graphics context) {
		for (Tile[] line : board){
			for (Tile tile : line){
				tile.render(container, game, context);
			}
		}
	}
}
