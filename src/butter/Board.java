package butter;

import java.lang.reflect.Array;

public class Board {
	static int[][] board;
	static int numberOfFieldsX;
	static int numberOfFieldsY;
	
	public Board(int numberOfFieldsX,int numberOfFieldsY) {
		this.numberOfFieldsX = numberOfFieldsX;
		this.numberOfFieldsY = numberOfFieldsY;
		board = new int[numberOfFieldsX][numberOfFieldsY];
	}
	
	public static void clear() {
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				board[x][y]=0;
			}
		}
	}

}
