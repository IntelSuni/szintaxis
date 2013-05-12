package hu.szintaxis.game;

import hu.szintaxis.game.engine.Game;
import hu.szintaxis.game.engine.GameApplication;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import System.Field;
import System.GameField;
import System.Weapon;

public class Antfarm extends Game {

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
		// this.gameField.updateUpdatables();
		System.out.println("updated");

	}

	@Override
	public void draw(Graphics2D g) {

		if (!GameApplication.isStarted()) {
			return;
		}
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		// GameField.instanceOf().draw(g);
		this.gameField.draw(g);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.szintaxis.game.engine.Game#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.szintaxis.game.engine.Game#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Point clickLocation = e.getPoint();

		// valami magic hogy átkonvertáljuk mezõ koordinátákba

		Point fieldLocation = mouseToField(clickLocation);

		System.out.println(clickLocation);

		Field field = GameField.instanceOf().getField(fieldLocation);

		Weapon.InstanceOf().Use(field);
	}

	public static Point mouseToField(Point mouseCoords) {

		int mouseX = mouseCoords.x;
		int mouseY = mouseCoords.y;

		// függõleges hely meghatározása:
		int row = Math.round((mouseY - 50) / 38.0f);
		int column = Math.round((row % 2 == 0 ? (mouseX - 50) / 43
				: (mouseX - 71.5f) / 43));

		return new Point(column, row);
	}

	public static Point fieldToMouse(Point fieldCoords) {

		int mouseY = (int) ((fieldCoords.y * 38.0f) + 50);
		int mouseX = (int) (fieldCoords.y % 2 == 0 ? (fieldCoords.x * 43) + 50 : (fieldCoords.x * 43) + 71.5f); 

		return new Point(mouseX, mouseY);
	}
}
