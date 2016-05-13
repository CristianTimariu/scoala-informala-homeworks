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

	/**
	 * Determines if there is a winner.
	 * 
	 * @param mark
	 *            (X, O, Empty)
	 * @return True, if someone wins.
	 */
	public boolean hasWon(Mark mark) {
		return (// search for 3 in a row.
		cells[0][0].content.equals(mark) && cells[0][1].equals(mark) && cells[0][2].equals(mark)
				|| cells[1][0].content.equals(mark) && cells[1][1].equals(mark) && cells[1][2].equals(mark)
				|| cells[2][0].content.equals(mark) && cells[2][1].equals(mark) && cells[2][2].equals(mark)
				// search for 3 in a col.
				|| cells[0][0].content.equals(mark) && cells[1][0].equals(mark) && cells[2][0].equals(mark)
				|| cells[0][1].content.equals(mark) && cells[1][1].equals(mark) && cells[2][1].equals(mark)
				|| cells[0][2].content.equals(mark) && cells[1][2].equals(mark) && cells[2][2].equals(mark)
				// search for 3 in the diagonal
				|| cells[0][0].content.equals(mark) && cells[1][1].equals(mark) && cells[2][2].equals(mark)
				// search for 3 in the opp-diagonal
				|| cells[0][2].content.equals(mark) && cells[1][1].equals(mark) && cells[2][0].equals(mark));
	}

	/**
	 * Boolean method to determine if the game is "draw".
	 * 
	 * @return True, if there are no more moves. False, if finds empty cells.
	 */
	public boolean isDraw() {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				// Goes through board and search if there are empty cells
				// left.
				if (cells[row][col].content == Mark.EMPTY) {
					// If one cell is empty, game continues.
					return false;
				}
			}
		}
		return true;
	}
}