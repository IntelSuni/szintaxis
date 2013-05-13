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

/**
 * A játék grafikus változatát megvalósító osztálya.
 *
 */
public class Antfarm extends Game {

	/**
	 * Beállítja a játékos pálya szélességét, magasságát 
	 * és a frissítési gyakoriságát (FPS).
	 */
	public Antfarm() {
		title = "Antfarm";
		fps = 1;
		height = 600;
		width = 600;
	}

	/**
	 * A játék grafikus változatának belépési pontja. 
	 * @param args parancssori argumentum
	 */
	public static void main(String[] args) {
		GameApplication.start(new Antfarm());
	}

	/*
	 * (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#update()
	 */
	@Override
	public void update() {
		// this.gameField.updateUpdatables();
		gameField.updateUpdatables();

	}

	/*
	 * (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#draw(java.awt.Graphics2D)
	 */
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

		// valami magic hogy �tkonvert�ljuk mez� koordin�t�kba

		Point fieldLocation = mouseToField(clickLocation);

		System.out.println(clickLocation);

		Field field = GameField.instanceOf().getField(fieldLocation);

		Weapon.InstanceOf().Use(field);
		
		//GameApplication.mainWindow.lblExterminator.setText("[ " + Weapon.InstanceOf().extSpray.getCapacity() + " ]");
		//GameApplication.mainWindow.lblNeutralitzer.setText("[ " + Weapon.InstanceOf().neutSpray.getCapacity() + " ]");
	}

	/**
	 * Az egér koordinátáit mezőkoordinátákká alakítja
	 * @param mouseCoords egérkoordináták
	 * @return <code>Point</code> mezőkoordináták
	 */
	public static Point mouseToField(Point mouseCoords) {

		int mouseX = mouseCoords.x;
		int mouseY = mouseCoords.y;

		// f�gg�leges hely meghat�roz�sa:
		int row = Math.round((mouseY - 50) / 38.0f);
		int column = Math.round((row % 2 == 0 ? (mouseX - 50) / 43.0f
				: (mouseX - 71.5f) / 43.0f));

		return new Point(column, row);
	}

	/**
	 * A mezőkkordinátákat egérkoordinátákká alakítja.
	 * @param fieldCoords mezőkoordináták
	 * @return <code>Point</code> egérkoordináták
	 */
	public static Point fieldToMouse(Point fieldCoords) {

		int mouseY = (int) ((fieldCoords.y * 38.0f) + 50);
		int mouseX = (int) (fieldCoords.y % 2 == 0 ? (fieldCoords.x * 43) + 50 : (fieldCoords.x * 43) + 71.5f); 

		return new Point(mouseX, mouseY);
	}
}
