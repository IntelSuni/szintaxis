package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.Ant;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:33
 */
public class AntView implements View {

	public Ant m_Ant;
	private BufferedImage image = null;
	
	public AntView(){
		try {
			image = ImageIO.read(new FileInputStream("pics/ant.gif"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}
	
	public void draw(Graphics2D g){
		Point points = new Point();
		if (this.m_Ant != null) {
			points = this.m_Ant.getField().getPoint();
		}

		int radius = (int) (20 * Math.sqrt(3));
		
		//Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		if (points.x % 2 == 0) {
			g.drawImage(image, points.x * radius, points.y * radius, image.getWidth()/10, image.getHeight()/10, null);
		}
		else{
			g.drawImage(image, 10 + points.x * radius, 10 + points.y * radius, image.getWidth()/10, image.getHeight()/10, null);
		}
		
		System.out.println("Ant draw at: " + points.x + " - " + points.y);
	}
}