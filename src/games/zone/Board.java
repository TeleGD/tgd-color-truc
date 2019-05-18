package games.zone;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Board {
	private Tile[][] board;
	private int widthLen;
	private int heightLen;

	public Board(int widthLen, int heightLen){
		board = new Tile[heightLen][widthLen];
		this.widthLen = widthLen;
		this.heightLen = heightLen;
		initBoard();
	}
	
	public void setBlock(int i, int j, int type, Color color) {
		setBlock(i, j, new Tile(type, color, i, j));
	}
	
	public void setBlock(int i, int j, Tile t) {
		if (0 <= i && i < heightLen && 0 <= j && j < widthLen) {
			this.board[i][j] = t;
		}
	}
	
	public void setBlockType(int i, int j, int type) {
		if (0 <= i && i < heightLen && 0 <= j && j < widthLen) {
			this.board[i][j].setType(type);
		}
	}

	public void initBoard2(){
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[0].length ; j++){
				board[i][j] = new Tile(0, null, i, j);
			}
		}
	}

	public void initBoard(){
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[0].length ; j++){
				board[i][j] = new Tile(0, null, i, j);
			}
		}
		// Génération de la rivière :
		int x_top = ThreadLocalRandom.current().nextInt(widthLen);
		int x_bottom = ThreadLocalRandom.current().nextInt(widthLen);
		ArrayList<Integer> river = new ArrayList<>();
		river.add(x_top); river.add(x_bottom);
		int n = (int)(Math.log(heightLen)/Math.log(2))+1;
		for (int k = 1; k < n + 1; k++) {
			for (int i = river.size()-2; i >= 0; i--) {
				river.add(i+1, (river.get(i)+river.get(i+1))/2);
			}
			for (int i = 0; i < river.size(); i++) {
				int caca = (int)(widthLen/Math.pow(2, k))+1;
				river.set(i, river.get(i)+ThreadLocalRandom.current().nextInt(caca));
			}
		}
		for (int i = 0; i < heightLen; i++) {
			for (int di = -1; di <= 1; di++) {
				for (int dj = -1; dj <= 1; dj++) {
					setBlockType(i+di, river.get(i)+dj, 3);
				}
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
