package game.java;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
	void clearCell() {
		content = Mark.EMPTY;
	}

	/** Paint the cell using Graphics */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(GameMain.MARK_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		
		// Draw the mark in cell.
		int x1 = col * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		int y1 = row * GameMain.CELL_SIZE + GameMain.CELL_PADDING;
		if(content.equals(Mark.X)) {
			g2d.setColor(Color.RED);
			int x2 = (col+1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			int y2 = (row+1) * GameMain.CELL_SIZE - GameMain.CELL_PADDING;
			g2d.drawLine(x1, y1, x2, y2);
			g2d.drawLine(x2, y1, x1, y2);
		} else if(content.equals(Mark.O)){
			g2d.setColor(Color.blue);
			g2d.drawOval(x1, y1, GameMain.MARK_SIZE, GameMain.MARK_SIZE);
		}
	}
}