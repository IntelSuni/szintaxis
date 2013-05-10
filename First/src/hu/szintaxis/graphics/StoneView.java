package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.Stone;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:34
 */
public class StoneView implements View {

	public Stone m_Stone;
	private BufferedImage image = null;
	
	public StoneView(){
		try {
			image = ImageIO.read(new FileInputStream("pics/Stone.gif"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_Stone != null) {
			points = this.m_Stone.getField().getPoint();
		}
		//Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x, points.y, image.getWidth()/8, image.getHeight()/8, null);
	}

}