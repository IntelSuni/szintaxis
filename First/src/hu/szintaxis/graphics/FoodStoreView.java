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
 * @author Lip�k
 * @version 1.0
 * @created 09-m�j.-2013 20:58:34
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
		
		int radius = (int) (20 * Math.sqrt(3));
		
		//Az m�ret annak megfelel�en, ha a Field kirajzol�sa m�r k�szen van.
		if (points.x % 2 == 0) {
			g.drawImage(image, points.x * radius, points.y * radius, image.getWidth()/8, image.getHeight()/8, null);
		}
		else{
			g.drawImage(image, 10 + points.x * radius, 10 + points.y * radius, image.getWidth()/8, image.getHeight()/8, null);
		}
		
		System.out.println("FoodStore draw at: " + points.x + " - " + points.y);
	}

}