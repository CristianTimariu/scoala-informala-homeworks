package game.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Tic-Tac-Toe game main. Class used to make graphic design.
 * 
 * @author TimariuCristian
 */
public class GameMain extends JPanel {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;

	// Constants that helps modify dimensions for graphic drawing.
	public static final int CELL_SIZE = 120; // cell width&height;
	// board size;
	public static final int BOARD_WIDTH = CELL_SIZE * 3;
	public static final int BOARD_HEIGHT = CELL_SIZE * 3;
	public static final int GRID_LINE = 10;
	// cell padding from border for cell content;
	public static final int CELL_PADDING = CELL_SIZE / 6;
	public static final int MARK_SIZE = CELL_SIZE - CELL_PADDING * 2;
	public static final int MARK_STROKE_WIDTH = 8; // pen's stroke width

	private Board board;
	private GameStatus currentState;
	private Mark currentPlayer;
	private JLabel statusBar;

	/** Constructor for Tic-Tac-Toe game, with UI setup */
	public GameMain() {
		board = new Board();
		initGame();

		statusBar = new JLabel("           ");
		statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 10));
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusBar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, CELL_PADDING));

		setLayout(new BorderLayout());
		add(statusBar, BorderLayout.PAGE_START);
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
	}

	/**
	 * Method that clears game-board contents. Used to start (or restart) the
	 * game and set the first player with X mark.
	 */
	private void initGame() {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				board.cells[row][col].content = Mark.EMPTY;
			}
		}
		currentState = GameStatus.PLAYING;
		currentPlayer = Mark.X;
	}
}