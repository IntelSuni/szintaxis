package hu.szintaxis.game;

import hu.szintaxis.game.engine.Game;
import hu.szintaxis.game.engine.GameApplication;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import System.Field;
import System.GameField;
import System.Weapon;

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
		//this.gameField.updateUpdatables();
		System.out.println("updated");
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		if (!GameApplication.isStarted()) {
			return;
		}
		//GameField.instanceOf().draw(g);
		this.gameField.draw(g);
	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {		
		Point locationOnScreen = e.getLocationOnScreen();
		
		// valami magic hogy átkonvertáljuk mezõ koordinátákba
		
		Point fieldLocation = null;
		System.out.println(locationOnScreen);
		
		Field field = GameField.instanceOf().getField(fieldLocation);
		
		Weapon.InstanceOf().Use(field);		
	}
}
