package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.AntHill;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:33
 */
public class AntHillView implements View {

	public AntHill m_AntHill;
	private BufferedImage image = null;

	public AntHillView() {
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
		// if (this.m_AntHill != null) {
		points = Antfarm.fieldToMouse(m_AntHill.getField().getPoint());
		// }
		// Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x - (image.getWidth() / 10), points.y
				- (image.getHeight() / 10), image.getWidth() / 5,
				image.getHeight() / 5, null);

		System.out.println("AntHill draw at: " + points.x + " - " + points.y);
	}

}