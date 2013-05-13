package System;

import java.awt.Graphics2D;

/**
 * Interf�sz a kirajzolhat� objektumoknak.
 */
public interface View {

	/**
	 * Kirajzolja az objektumot.
	 * @param g erre az obejktumra rajzolja ki a kirajzolhat� elem n�zet�t
	 */
	public void draw(Graphics2D g);
	
}
