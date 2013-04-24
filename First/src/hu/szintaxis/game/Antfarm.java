package hu.szintaxis.game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import hu.szintaxis.game.engine.Game;
import hu.szintaxis.game.engine.GameApplication;

public class Antfarm extends Game{

	public Antfarm() {
		title = "Antfarm";
		fps = 1;
		height = 600;
		width = 600;
	}

	public static void main(String[] args) {
		GameApplication.start(new Antfarm());
	}
	
	@Override
	public void update() {
		System.out.println("updated");
	}

	@Override
	public void draw(Graphics2D g) {
	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'p') {
			GameApplication.pauseGame();
		} else if (e.getKeyChar() == 'r') {
			GameApplication.resumeGame();
		} else if (e.getKeyChar() == 's') {
			GameApplication.stopGame();
		}
	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	
}
