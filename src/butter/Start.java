package butter;

public class Start {
	
	// data
	private int numOfFieldsX = 16;
	private int numOfFieldsY = 10;
	Board gameBoard;
	static Start game;
	
	public Start() {
		gameBoard = new Board(numOfFieldsX,numOfFieldsY);
		gameBoard.clear();
		gameBoard.print();
		gameBoard.setInvisibleFrame();
		gameBoard.setBlockPattern(8);
		gameBoard.populate(8);
		gameBoard.print();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Butter is on it´s way...");
		game = new Start();
		}

}
