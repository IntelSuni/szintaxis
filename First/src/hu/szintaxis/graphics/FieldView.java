package hu.szintaxis.graphics;

import java.awt.Graphics2D;
import java.awt.Polygon;

import System.Field;
import System.View;

/**
 * @author Lipák
 * @version 1.0
 * @created 09-máj.-2013 20:58:33
 */
public class FieldView implements View {

	public Field m_Field;

	public FieldView(){

	}
	
	public FieldView(Field field) {
		this.m_Field = field;
	}

	public void finalize() throws Throwable {

	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		float horPos = m_Field.getPoint().x * 43;
		float vertPos = m_Field.getPoint().y * 38;
		if (m_Field.getPoint().y % 2 == 1) {
			horPos += 21.5;
		}
		vertPos += 50;
		horPos += 50;
		Polygon p = new Polygon();
	    for (int i = 0; i < 6; i++)
	      p.addPoint((int) (horPos + 25 * Math.cos(i * 2 * Math.PI / 6 + (Math.PI / 2))),
	          (int) (vertPos + 25 * Math.sin(i * 2 * Math.PI / 6  + (Math.PI / 2))));

	    g.drawPolygon(p);		
	}

}