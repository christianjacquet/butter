package butter;

public class Start {
	
	// data
	private int numOfFieldsX = 10;
	private int numOfFieldsY = 10;
	Board gameBoard;
	static Start game;
	
	public Start() {
		gameBoard = new Board(numOfFieldsX,numOfFieldsY);
		gameBoard.clear();
		gameBoard.populate(10);
		gameBoard.print();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Butter is on it´s way...");
		game = new Start();
		}

}
