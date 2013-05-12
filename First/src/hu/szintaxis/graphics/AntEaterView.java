package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.Anteater;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:32
 */
public class AntEaterView implements View {

	public Anteater m_AntEater;
	private BufferedImage image = null;

	public AntEaterView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/anteater.png"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_AntEater != null) {
			points = Antfarm.fieldToMouse(m_AntEater.getField().getPoint());
		}
		// Az méret annak megfelelõen, ha a Field kirajzolása már készen van.
		g.drawImage(image, points.x - (image.getWidth() / 16), points.y
				- (image.getHeight() / 16), image.getWidth() / 8,
				image.getHeight() / 8, null);
	}

}