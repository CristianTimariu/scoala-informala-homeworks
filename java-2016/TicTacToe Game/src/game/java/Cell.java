package game.java;

/**
 * Cell class represents each cell that builds the game board.
 * 
 * @author TimariuCristian
 *
 */
public class Cell {

	Mark content;
	int row, col;

	/**
	 * Constructor to initialize the cell with specified parameters.
	 * 
	 * @param row
	 * @param col
	 */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clearCell();
	}

	/** Set the content of the cell to "empty" */
	private void clearCell() {
		content = Mark.EMPTY;
	}
}