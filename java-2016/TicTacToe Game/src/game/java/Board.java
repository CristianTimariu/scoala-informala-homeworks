package game.java;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Board class that use cells to create game board.
 * 
 * @author TimariuCristian
 *
 */
public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	
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
	
	public void initGameBoard() {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				cells[row][col].clearCell(); // clear the cell content
			}
		}
	}

	/**
	 * Determines if there is a winner.
	 * @param playerMark 
	 * 
	 * @return True, if someone wins.
	 */
	public boolean hasWon(Mark playerMark) {
		return (// search for 3 in a row.
		cells[0][0].content.equals(playerMark) && cells[0][1].content.equals(playerMark) && cells[0][2].content.equals(playerMark)
				|| cells[1][0].content.equals(playerMark) && cells[1][1].content.equals(playerMark) && cells[1][2].content.equals(playerMark)
				|| cells[2][0].content.equals(playerMark) && cells[2][1].content.equals(playerMark) && cells[2][2].content.equals(playerMark)
				// search for 3 in a column.
				|| cells[0][0].content.equals(playerMark) && cells[1][0].content.equals(playerMark) && cells[2][0].content.equals(playerMark)
				|| cells[0][1].content.equals(playerMark) && cells[1][1].content.equals(playerMark) && cells[2][1].content.equals(playerMark)
				|| cells[0][2].content.equals(playerMark) && cells[1][2].content.equals(playerMark) && cells[2][2].content.equals(playerMark)
				// search for 3 in the diagonal
				|| cells[0][0].content.equals(playerMark) && cells[1][1].content.equals(playerMark) && cells[2][2].content.equals(playerMark)
				// search for 3 in the opposite-diagonal
				|| cells[0][2].content.equals(playerMark) && cells[1][1].content.equals(playerMark) && cells[2][0].content.equals(playerMark));
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

	/** Paint the board game, given the Graphics context */

	public void paint(Graphics g) {
		// Draw the grid-lines
		g.setColor(Color.DARK_GRAY);
		for (int row = 1; row < 3; ++row) {
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GameMain.GRID_LINE, GameMain.BOARD_WIDTH - 1,
					GameMain.GRID_LINE, GameMain.GRID_LINE, GameMain.GRID_LINE);
		}
		for (int col = 1; col < 3; ++col) {
			g.fillRoundRect(GameMain.CELL_SIZE * col - GameMain.GRID_LINE, 0, GameMain.GRID_LINE,
					GameMain.BOARD_HEIGHT - 1, GameMain.GRID_LINE, GameMain.GRID_LINE);
		}

		// Draw all the cells
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				cells[row][col].paint(g); // paint the cells
			}
		}
	}
}