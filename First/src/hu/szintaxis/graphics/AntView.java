package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
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
		g.drawImage(image, 50, 50, null);
	}
}