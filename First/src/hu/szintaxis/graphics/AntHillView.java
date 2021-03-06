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
 * A hangyaboly kirajzol�s��rt felel�s oszt�ly.
 */
public class AntHillView implements View {

	public AntHill m_AntHill;
	private BufferedImage image = null;

	/**
	 * L�trehozza a n�zetet.
	 */
	public AntHillView() {
		try {
			image = ImageIO.read(new FileInputStream("pics/ant_hill.png"));
		} catch (IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {

	}

	/*
	 * (non-Javadoc)
	 * @see System.View#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		Point points = new Point();
		if (this.m_AntHill != null) {
			points = Antfarm.fieldToMouse(m_AntHill.getField().getPoint());
		}
		
		// Az m�ret annak megfelel�en, ha a Field kirajzol�sa m�r k�szen van.
		g.drawImage(image, points.x - (image.getWidth() / 10), points.y
				- (image.getHeight() / 10), image.getWidth() / 5,
				image.getHeight() / 5, null);

	}

}