package hu.szintaxis.game.engine;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import System.GameField;

public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	protected boolean over;
	protected String title = "My Game";
	protected int width=400, height=300;
	protected int fps = 60;
	
	protected GameField gameField = new GameField(new Point(10, 10));
	
	public void init() {
		gameField.Initialize();
	}
	abstract public void update();
	abstract public void draw(Graphics2D g);


	public boolean isOver() { return over; }
	public String getTitle() { return title; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getFps() { return fps; }
	public void resize(int width, int height) {}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
	}

}
