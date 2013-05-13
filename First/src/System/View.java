package System;

import java.awt.Graphics2D;

/**
 * Interfész a kirajzolható objektumoknak.
 */
public interface View {

	/**
	 * Kirajzolja az objektumot.
	 * @param g erre az obejktumra rajzolja ki a kirajzolható elem nézetét
	 */
	public void draw(Graphics2D g);
	
}
