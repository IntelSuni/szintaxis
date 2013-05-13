package hu.szintaxis.game.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

/**
 * A j�t�k grafikus v�ltozat�t megjelen�t� oszt�ly.
 *
 */
public class GameCanvas extends JComponent implements ComponentListener {

	private Game game;

	/**
	 * L�trehozza a j�t�k grafikus v�ltozat�t.
	 */
	public GameCanvas() {
	}

	/**
	 * L�trehozza a j�t�k grafikus v�ltozat�t.
	 * @param game a j�t�k, amellyel l�trehozza
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
     * Be�ll�tja a j�t�k grafikus v�ltozat�t.
     * @param game a j�t�k, amelyre be�ll�tja
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
