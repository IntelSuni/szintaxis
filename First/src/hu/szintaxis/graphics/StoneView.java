package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

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

	public StoneView() {
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
			points = Antfarm.fieldToMouse(m_Stone.getField().getPoint());
		}

		g.drawImage(image, points.x - (image.getWidth() / 10), points.y
				- (image.getHeight() / 10), image.getWidth() / 5,
				image.getHeight() / 5, null);

		System.out.println("Stone draw at: " + points.x + " - " + points.y);
	}

}