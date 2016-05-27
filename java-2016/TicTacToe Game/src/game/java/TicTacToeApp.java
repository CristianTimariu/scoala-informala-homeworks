package game.java;

import java.awt.Dimension;

import javax.swing.JFrame;

public class TicTacToeApp {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Tic-Tac-Toe");
		frame.setContentPane(new GameMain());
		frame.setSize(new Dimension(360, 440));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
