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
 * A j�t�k grafikus v�ltozat�t megval�s�t� absztrakt oszt�lya.
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
	 * Be�ll�tja �s inicializ�lja a j�t�kos p�ly�t.
	 */
	public void init() {
		gameField = GameField.instanceOf();
		gameField.Initialize();
	}
	/**
	 * Friss�ti a j�t�kos p�ly�t.
	 */
	abstract public void update();
	/**
	 * Kirajzolja a j�t�kos p�ly�t.
	 * @param g az objektum, amelyre a p�ly�t rajzolja
	 */
	abstract public void draw(Graphics2D g);


	/**
	 * Visszaadja, hogy az objektumra r�mutatttak e.
	 * @return <code>true</code>, ha az eg�r f�l�tte volt
	 */
	public boolean isOver() { return over; }
	/**
	 * Visszaadja a j�t�k nev�t/c�m�t.
	 * @return a j�t�k neve/c�me
	 */
	public String getTitle() { return title; }
	/**
	 * Visszaadja a j�t�kos p�lya sz�less�g�t.
	 * @return j�t�kos p�lya sz�less�ge
	 */
	public int getWidth() { return width; }
	/**
	 * Visszaadja a j�t�kos p�lya magass�g�t
	 * @return a j�t�kos p�lya magass�ga
	 */
	public int getHeight() { return height; }
	/**
	 * Visszaadja a friss�t�si gyakoris�got.
	 * @return friss�t�si gyakorsi�g
	 */
	public int getFps() { return fps; }
	/**
	 * �tm�retezi a j�t�kos p�ly�t.
	 * @param width a j�t�kos p�lya �j sz�less�ge
	 * @param height width a j�t�kos p�lya �j magass�ga
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
