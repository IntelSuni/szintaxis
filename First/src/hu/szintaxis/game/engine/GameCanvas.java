package hu.szintaxis.game.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

/**
 * A játék grafikus változatát megjelenítõ osztály.
 *
 */
public class GameCanvas extends JComponent implements ComponentListener {

	private Game game;

	/**
	 * Létrehozza a játék grafikus változatát.
	 */
	public GameCanvas() {
	}

	/**
	 * Létrehozza a játék grafikus változatát.
	 * @param game a játék, amellyel létrehozza
	 */
    public GameCanvas(Game game) {
		this.game = game;
		addKeyListener(game);
		addMouseListener(game);
		addMouseMotionListener(game);
		addMouseWheelListener(game);
		requestFocus();
		addComponentListener(this);
    }

    /**
     * Beállítja a játék grafikus változatát.
     * @param game a játék, amelyre beállítja
     */
	public void setGame(Game game) {
		this.game = game;
		addKeyListener(game);
		addMouseListener(game);
		addMouseMotionListener(game);
		requestFocus();
		addComponentListener(this);
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		game.draw((Graphics2D)g);
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentResized(ComponentEvent ce) {
		game.resize(ce.getComponent().getWidth(), ce.getComponent().getHeight());	
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentMoved(ComponentEvent ce) {
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentShown(ComponentEvent ce) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
	 */
	@Override
	public void componentHidden(ComponentEvent ce) {
		
	}

}
