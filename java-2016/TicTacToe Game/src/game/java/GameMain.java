package game.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

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
		statusBar = new JLabel("           ");
		statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
		statusBar.setBackground(Color.LIGHT_GRAY);
		statusBar.setBorder(BorderFactory.createMatteBorder(5, 4, 5, 4, Color.DARK_GRAY));
		statusBar.setOpaque(true);
		setLayout(new BorderLayout());
		add(statusBar, BorderLayout.PAGE_END);
		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

		board = new Board();

		initGame();

		Thread t1 = new Thread(new Player(Mark.X));
		Thread t2 = new Thread(new Player(Mark.O));

		t1.start();
		t2.start();

	}

	/** Customize painting on JPannel */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.GRAY);
		// Painting the board.
		board.paint(g);
		// Print status bar message.
		if (currentState == GameStatus.PLAYING) {
			statusBar.setForeground(Color.BLACK);
			if (currentPlayer.equals(Mark.X)) {
				statusBar.setText("X's Turn");
			} else {
				statusBar.setText("O's turn");
			}
		} else if (getCurrentState().equals(GameStatus.X_WON)) {
			statusBar.setForeground(Color.RED);
			statusBar.setText("'X' Won!");
		} else if (getCurrentState().equals(GameStatus.O_WON)) {
			statusBar.setForeground(Color.BLUE);
			statusBar.setText("'O' Won!");
		} else if (currentState == GameStatus.DRAW) {
			statusBar.setForeground(Color.BLACK);
			statusBar.setText("It's a Draw! Click to play again.");
		}
	}

	// Getter & setter
	public GameStatus getCurrentState() {
		return currentState;
	}

	public void setCurrentState(GameStatus currentState) {
		this.currentState = currentState;
	}

	/**
	 * Method that clears game-board contents. Used to start the game and set
	 * the first player with X mark.
	 */
	public void initGame() {
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 3; ++col) {
				board.cells[row][col].content = Mark.EMPTY;
			}
		}
		currentState = GameStatus.PLAYING;
		currentPlayer = Mark.X;
	}

	/** Main steps that a thread make every round */
	private synchronized void playGame(Mark playerMark) {
		markCell(playerMark);
		checkGameStatus(playerMark);
		repaint();
	}

	/**
	 * See if there is a winner or the game is draw. Else the game continues.
	 * 
	 * @param playerMark
	 */
	private void checkGameStatus(Mark playerMark) {
		if (board.hasWon(playerMark)) { // check for winner.
			setCurrentState((playerMark.equals(Mark.X)) ? GameStatus.X_WON : GameStatus.O_WON);
		} else if (board.isDraw()) { // check for draw
			setCurrentState(GameStatus.DRAW);
		}
		// Switch players
		currentPlayer = (currentPlayer.equals(Mark.X)) ? Mark.O : Mark.X;
	}

	/** Method used by Players to put their symbol in a random cell. */
	private void markCell(Mark playerMark) {

		Random random = new Random();
		int row = random.nextInt(3);
		int col = random.nextInt(3);
		if (getCurrentState().equals(GameStatus.PLAYING)) {
			while (!board.cells[row][col].content.equals(Mark.EMPTY)) {
				//search for a random position
				row = random.nextInt(3);
				col = random.nextInt(3);
			}
			
			board.cells[row][col].content = playerMark;
		}
	}

	/**
	 * Inner Class Player that implements runnable. Used to run and play
	 * tic-tac-toe.
	 * 
	 * @author TimariuCristian
	 *
	 */
	public class Player implements Runnable {

		private Mark playerMark;

		public Player(Mark playerMark) {
			this.playerMark = playerMark;
		}

		@Override
		public void run() {
			try {
				while (currentState.equals(GameStatus.PLAYING)) {
					playGame(playerMark);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
			}
		}
	}
}