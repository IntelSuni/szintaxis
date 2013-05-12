package hu.szintaxis.graphics;

import hu.szintaxis.game.Antfarm;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import System.Antlion;
import System.View;

/**
 * @author Lip�k
 * @version 1.0
 * @created 09-m�j.-2013 20:58:33
 */
public class AntLionView implements View {

	public Antlion m_AntLion;
	private BufferedImage image = null;

	public AntLionView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/antlion.gif"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		points = Antfarm.fieldToMouse(m_AntLion.getField().getPoint());
		// Az m�ret annak megfelel�en, ha a Field kirajzol�sa m�r k�szen van.
		g.drawImage(image, points.x - (image.getWidth() / 12), points.y
				- (image.getHeight() / 12), image.getWidth() / 6,
				image.getHeight() / 6, null);
	}

}