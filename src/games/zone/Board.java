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
	}

	public void initBoard(){
		int x_top = ThreadLocalRandom.current().nextInt(widthLen);
		int x_bottom = ThreadLocalRandom.current().nextInt(widthLen);
		ArrayList<Integer> river = new ArrayList<>();
		river.add(x_top); river.add(x_bottom);
		int n = (int)Math.log(heightLen)+1;
		for (int k = 2; k < n; k++) {
			for (int i = river.size()-2; i >= 0; i--) {
				river.add(i+1, (river.get(i)+river.get(i+1))/2);
			}
			for (int i = 0; i < river.size(); i++) {
				river.set(i, river.get(i)+ThreadLocalRandom.current().nextInt((int)(widthLen/Math.pow(2, k))));
			}
		}
		for (int j = 0; j < heightLen; j++) {
			board[j][river.get(j)-1] = new Tile(3, Color.blue, j, river.get(j)-1);
			board[j][river.get(j)] = new Tile(3, Color.blue, j, river.get(j));
			board[j][river.get(j)+1] = new Tile(3, Color.blue, j, river.get(j)+1);
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
