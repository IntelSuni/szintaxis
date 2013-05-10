package hu.szintaxis.game.engine;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hu.szintaxis.graphics.MainWindow;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import System.GameField;

public class GameApplication {

	private static GameLoop gameLoop;

	/**
	 * 
	 * @see hu.szintaxis.game.engine.GameLoop#pauseGame()
	 */
	public static void pauseGame() {
		gameLoop.pauseGame();
	}

	/**
	 * 
	 * @see hu.szintaxis.game.engine.GameLoop#resumeGame()
	 */
	public static void resumeGame() {
		gameLoop.resumeGame();
	}

	/**
	 * 
	 * @see hu.szintaxis.game.engine.GameLoop#stopGame()
	 */
	public static void stopGame() {
		gameLoop.stopGame();
	}
	
	public static boolean isStarted() {
		return gameLoop.isAlive();
	}

	private static boolean isPaused = false;
	private static Object helpString = "Here comes the help instructions.";

	public static void start(final Game game) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame(game.getTitle());
				frame.setSize(game.getWidth(), game.getHeight());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				final MainWindow mainWindow = new MainWindow();

				GameCanvas canvas = new GameCanvas();
				mainWindow.add(canvas, BorderLayout.CENTER);

				canvas.setGame(game);
				frame.add(mainWindow);
				frame.setVisible(true);
				canvas.requestFocus();

				mainWindow.btnPause.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (isPaused == false) {
							pauseGame();
							isPaused = true;
						} else if (isPaused == true) {
							resumeGame();
							isPaused = false;
						}
					}
				});

				mainWindow.btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						stopGame();
					}
				});

				mainWindow.btnHelp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pauseGame();
						int response = JOptionPane.showConfirmDialog(
								mainWindow.panel, helpString, "Help",
								JOptionPane.YES_NO_OPTION);
						if (response == JOptionPane.YES_OPTION
								|| response == JOptionPane.NO_OPTION) {
							resumeGame();
						}
					}
				});

				gameLoop = new GameLoop(game, canvas);
				// gameLoop.start();

				mainWindow.btnNewGame.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GameField.instanceOf().Initialize();
						gameLoop.start();
					}
				});

			}
		});
	}
}
