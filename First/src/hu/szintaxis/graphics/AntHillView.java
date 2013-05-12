package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.AntHill;
import System.View;

/**
 * @author Lip�k
 * @version 1.0
 * @created 09-m�j.-2013 20:58:33
 */
public class AntHillView implements View {

	public AntHill m_AntHill;
	private BufferedImage image = null;
	
	public AntHillView(){
		try {
			image = ImageIO.read(new FileInputStream("pics/ant_hill.png"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		//if (this.m_AntHill != null) {
			points = this.m_AntHill.getField().getPoint();
		//}
			int radiusH = (int) (20 * Math.sqrt(3));
			int radiusV = (int) (0.866 * 20);
			
			//Az m�ret annak megfelel�en, ha a Field kirajzol�sa m�r k�szen van.
			if (points.x % 2 == 0) {
				g.drawImage(image, points.x * radiusH, points.y * radiusV, image.getWidth()/5, image.getHeight()/5, null);
			}
			else{
				g.drawImage(image, 10 + points.x * radiusH, 10 + points.y * radiusV, image.getWidth()/5, image.getHeight()/5, null);
			}
		System.out.println("AntHill draw at: " + points.x + " - " + points.y);
	}

}