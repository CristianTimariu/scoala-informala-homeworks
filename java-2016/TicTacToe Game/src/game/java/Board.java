package game.java;

/**
 * Board class that use cells to create game board.
 * 
 * @author TimariuCristian
 *
 */
public class Board {

	Cell[][] cells; // two dimensions array.

	/**
	 * Constructor for game board.
	 */
	public Board() {
		cells = new Cell[3][3]; // 3x3 cells.
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
}