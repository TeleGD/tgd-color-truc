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
	
	public void setBlock(int y, int x, int type, Color color) {
		setBlock(y, x, new Tile(type, color, y, x));
	}
	
	public void setBlock(int y, int x, Tile t) {
		if (0 < y && y < heightLen && 0 < x && x < widthLen) {
			board[y][x] = t;
		}
	}

	public void initBoard(){
		//TODO : init procédural (avec de la diversité)
		for (int i = 0 ; i < board.length ; i++) {
			for (int j = 0 ; j < board[0].length ; j++){
				board[i][j] = new Tile(0, null, i, j);
			}
		}
	}

	public void initBoard2(){
		int x_top = ThreadLocalRandom.current().nextInt(widthLen);
		int x_bottom = ThreadLocalRandom.current().nextInt(widthLen);
		ArrayList<Integer> river = new ArrayList<>();
		river.add(x_top); river.add(x_bottom);
		int n = (int)(Math.log(heightLen)/Math.log(2))+1;
		for (int k = 2; k < n + 2; k++) {
			for (int i = river.size()-2; i >= 0; i--) {
				river.add(i+1, (river.get(i)+river.get(i+1))/2);
			}
			for (int i = 0; i < river.size(); i++) {
				river.set(i, river.get(i)+ThreadLocalRandom.current().nextInt((int)(widthLen/Math.pow(2, k))));
			}
		}
		for (int j = 0; j < heightLen; j++) {
			setBlock(j, river.get(j)-1, 3, Color.blue);
			setBlock(j, river.get(j), 3, Color.blue);
			setBlock(j, river.get(j)+1, 3, Color.blue);
		}
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
