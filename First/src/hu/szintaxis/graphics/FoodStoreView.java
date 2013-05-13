package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.FoodStore;
import System.View;

/**
 * Az ételraktár kirajzolásáért felelõs osztály.
 */
public class FoodStoreView implements View {

	public FoodStore m_FoodStore;
	private BufferedImage image = null;

	/**
	 * Létrehozza a nézetet.
	 */
	public FoodStoreView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/foodstore.jpg"));
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
	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_FoodStore != null) {
			points = Antfarm.fieldToMouse(m_FoodStore.getField().getPoint());
		}

		// Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x - (image.getWidth() / 16), points.y
				- (image.getHeight() / 16), image.getWidth() / 8,
				image.getHeight() / 8, null);

	}

}