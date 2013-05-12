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
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:33
 */
public class AntView implements View {

	public Ant m_Ant;
	private BufferedImage image = null;

	public AntView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/ant.gif"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

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