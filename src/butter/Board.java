package butter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	static int[][] board;
	static int numberOfFieldsX;
	static int numberOfFieldsY;
	static Random random = new Random();
	static final int CELL_INVISIBLE=99;
	static final int CELL_BLOCKED=11; 
	static final int CELL_EMPTY=97; 
	
	
	
	public Board(int numberOfFieldsX,int numberOfFieldsY) {
		this.numberOfFieldsX = numberOfFieldsX+2;
		this.numberOfFieldsY = numberOfFieldsY+2;
		board = new int[this.numberOfFieldsX][this.numberOfFieldsY];
	}
	
	public void setInvisibleFrame() {
		for (int x=0; x<numberOfFieldsX; x++) {board[x][0]=CELL_INVISIBLE; board[x][numberOfFieldsY-1]=CELL_INVISIBLE;} 
		for (int y=0; y<numberOfFieldsY; y++) {board[0][y]=CELL_INVISIBLE; board[numberOfFieldsX-1][y]=CELL_INVISIBLE;}
	}
	
	public void setBlockPattern(int blockPattern) {
		int x1of3 = (numberOfFieldsX-2) / 3+1;
		int y1of3 = (numberOfFieldsY-2) / 3+1;
		int midX = numberOfFieldsX / 2;
		int midY = numberOfFieldsY / 2;
		if (blockPattern>0) {for (int x=0; x<numberOfFieldsX; x++) {board[x][0]=CELL_BLOCKED;}} 
		if (blockPattern>1) {for (int y=0; y<numberOfFieldsY; y++) {board[0][y]=CELL_BLOCKED;}}
		if (blockPattern>2) {for (int x=0; x<numberOfFieldsX; x++) {board[x][numberOfFieldsY-1]=CELL_BLOCKED;}}
		if (blockPattern>3) {for (int y=0; y<numberOfFieldsY; y++) {board[numberOfFieldsX-1][y]=CELL_BLOCKED;}}
		if (blockPattern>4) {for (int x=0; x<x1of3; x++) {board[x][midY]=CELL_BLOCKED;}}
		if (blockPattern>5) {for (int x=numberOfFieldsX-x1of3; x<numberOfFieldsX; x++) {board[x][midY]=CELL_BLOCKED;}}	
		if (blockPattern>6) {for (int y=0; y<y1of3; y++) {board[midX][y]=CELL_BLOCKED;}}
		if (blockPattern>7) {for (int y=numberOfFieldsY-y1of3; y<numberOfFieldsY; y++) {board[midX][y]=CELL_BLOCKED;}}	
	}
	
	public void clear() {
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				board[x][y]=CELL_EMPTY;
			}
		}
	}
	
	public ArrayList<Integer> getRandomPairs(int numberOfPairs, int numberOfFlyTypes) {
		int randomFly;
		int randomPos;
		ArrayList<Integer> listOfRandomPairs = new ArrayList<Integer>();
		ArrayList<Integer> randomizedList = new ArrayList<Integer>();
		for (int pair=0; pair<numberOfPairs; pair++) {
			randomFly = random.nextInt((numberOfFlyTypes));
			listOfRandomPairs.add(randomFly);
			listOfRandomPairs.add(randomFly);
		}
		while (!listOfRandomPairs.isEmpty()) {
			randomPos = random.nextInt(listOfRandomPairs.size());
			randomizedList.add(listOfRandomPairs.get(randomPos));
			listOfRandomPairs.remove(randomPos);
		}
		System.out.println("randomlist:"+randomizedList.size());
		return randomizedList;
	}
	
	public int getNumOfEmpty() {
		int empty=0;
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				if (board[x][y]==CELL_EMPTY) empty++;
			}
		}
		return empty;
	}
	
	public void populate(int numberOfFlyTypes) {
		ArrayList<Integer> flies = getRandomPairs(getNumOfEmpty()/2, numberOfFlyTypes);
		System.out.println("--Empty:"+getNumOfEmpty());
		for (int x=0; x<numberOfFieldsX; x++) {
			for (int y=0; y<numberOfFieldsY; y++) {
				if(board[x][y]==CELL_EMPTY) {
					board[x][y]=flies.get(0);
					flies.remove(0);
				}
				System.out.print(board[x][y]+" ");
			}
			System.out.println("");
		}
	}
	
	public void print() {
		for (int y=numberOfFieldsY-1; y>=0; y--) {
			for (int x=0; x<numberOfFieldsX; x++) {
				if(board[x][y]<10)System.out.print("0");
				System.out.print(board[x][y]+" ");
			}
			System.out.println("");
		}
		System.out.println("Empty:"+getNumOfEmpty());
	}

}
