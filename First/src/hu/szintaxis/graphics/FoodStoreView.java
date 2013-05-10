package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.FoodStore;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:34
 */
public class FoodStoreView implements View {

	public FoodStore m_FoodStore;
	private BufferedImage image = null;

	public FoodStoreView(){
		try {
			image = ImageIO.read(new FileInputStream("pics/foodstore.jpg"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_FoodStore != null) {
			points = this.m_FoodStore.getField().getPoint();
		}
		//Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x, points.y, image.getWidth()/8, image.getHeight()/8, null);
	}

}