package hu.szintaxis.game.engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import System.GameField;

/**
 * A játék grafikus változatát megvalósító absztrakt osztálya.
 *
 */
public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	/*
	 * (non-Javadoc)
	 */
	protected boolean over;
	protected String title = "My Game";
	protected int width=400, height=300;
	protected int fps = 60;
	
	protected GameField gameField;
	
	/**
	 * Beállítja és inicializálja a játékos pályát.
	 */
	public void init() {
		gameField = GameField.instanceOf();
		gameField.Initialize();
	}
	/**
	 * Frissíti a játékos pályát.
	 */
	abstract public void update();
	/**
	 * Kirajzolja a játékos pályát.
	 * @param g az objektum, amelyre a pályát rajzolja
	 */
	abstract public void draw(Graphics2D g);


	/**
	 * Visszaadja, hogy az objektumra rámutatttak e.
	 * @return <code>true</code>, ha az egér fölötte volt
	 */
	public boolean isOver() { return over; }
	/**
	 * Visszaadja a játék nevét/címét.
	 * @return a játék neve/címe
	 */
	public String getTitle() { return title; }
	/**
	 * Visszaadja a játékos pálya szélességét.
	 * @return játékos pálya szélessége
	 */
	public int getWidth() { return width; }
	/**
	 * Visszaadja a játékos pálya magasságát
	 * @return a játékos pálya magassága
	 */
	public int getHeight() { return height; }
	/**
	 * Visszaadja a frissítési gyakoriságot.
	 * @return frissítési gyakorsiág
	 */
	public int getFps() { return fps; }
	/**
	 * Átméretezi a játékos pályát.
	 * @param width a játékos pálya új szélessége
	 * @param height width a játékos pálya új magassága
	 */
	public void resize(int width, int height) {}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	public void mouseDragged(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	public void mouseMoved(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseWheelListener#mouseWheelMoved(java.awt.event.MouseWheelEvent)
	 */
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

}
