package butter;

import java.lang.reflect.Array;
import java.util.Random;

public class Board {
	static int[][] board;
	static int numberOfFieldsX;
	static int numberOfFieldsY;
	static Random random = new Random();
	
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
	
	public static void populate(int numberOfObjectTypes) {
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				board[x][y]=random.nextInt((numberOfObjectTypes));
				System.out.print(board[x][y]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void print() {
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				System.out.print(board[x][y]+" ");
			}
			System.out.println("");
		}
	}

}
