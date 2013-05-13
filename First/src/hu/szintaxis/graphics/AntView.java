package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.Ant;
import System.View;

/**
 * A hangya kirazolásáért felelõs osztály.
 */
public class AntView implements View {

	public Ant m_Ant;
	private BufferedImage image = null;

	/**
	 * Létrehozza a nézetet.
	 */
	public AntView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/ant.gif"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	/*
	 * (non-Javadoc)
	 * @see System.View#draw(java.awt.Graphics2D)
	 */
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_Ant != null) {
			points = Antfarm.fieldToMouse(m_Ant.getField().getPoint());
		}

		// Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x - (image.getWidth() / 20), points.y
				- (image.getHeight() / 20), image.getWidth() / 10,
				image.getHeight() / 10, null);

	}
}