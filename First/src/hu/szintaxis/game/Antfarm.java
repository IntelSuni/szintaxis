package hu.szintaxis.game;

import hu.szintaxis.game.engine.Game;
import hu.szintaxis.game.engine.GameApplication;
import hu.szintaxis.game.engine.GameLoop;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

import System.GameField;

public class Antfarm extends Game implements ImageObserver{

	public Antfarm() {
		title = "Antfarm";
		fps = 1;
		height = 600;
		width = 600;
	}
		
	public static void main(String[] args) {
		GameApplication.start(new Antfarm());
	}
	
	@Override
	public void update() {
		System.out.println("updated");
		
	}

	@Override
	public void draw(Graphics2D g) {
		
//		Image image = null;
//		try {
//			image = ImageIO.read(new FileInputStream("bin/anteater.png"));
//		} catch (IOException e) {
//			System.out.println("An error occured");
//		}
//		
//		for (int i = 0; i < 400; i += 40) {
//			for (int j = 0, rowCount = 0; j < 400; j += 40, rowCount++) {
//				if(rowCount % 2 == 0){
//					int[] x = new int[]{i, i+20, i+40, i+40, i+20, i};
//					int[] y = new int[]{j+20, j, j+20, j+40, j+60, j+40};
//					g.drawPolygon(x, y, x.length);
//				}
//				else{
//					int[] x = new int[]{i+20, i+40, i+60, i+60, i+40, i+20};
//					int[] y = new int[]{j+20, j, j+20, j+40, j+60, j+40};
//					g.drawPolygon(x, y, x.length);
//				}
//			}
//		}
//		g.drawImage(image, 50, 50, image.getWidth(this)/5, image.getHeight(this)/5, this);
//		g.drawLine(30, 30, 80, 80);
		if (!GameApplication.isStarted()) {
			return;
		}
		GameField.instanceOf().draw(g);
	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {

	}

	/* (non-Javadoc)
	 * @see hu.szintaxis.game.engine.Game#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y,
			int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
