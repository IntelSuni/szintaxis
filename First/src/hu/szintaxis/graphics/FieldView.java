package hu.szintaxis.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import System.AntSmell;
import System.ExterminatorSmell;
import System.Field;
import System.FoodSmell;
import System.Smell;
import System.View;

/**
 * A mezõ kirajzolásáért felelõs osztály.
 */
public class FieldView implements View {

	public Field m_Field;

	/**
	 * Létrehozza a nézetet.
	 */
	public FieldView() {

	}

	/**
	 * Létrehozza a nézetet.
	 * @param field a mezõ, amelyhez létrehozza a nézetet
	 */
	public FieldView(Field field) {
		this.m_Field = field;
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
		// TODO Auto-generated method stub
		float horPos = m_Field.getPoint().x * 43;
		float vertPos = m_Field.getPoint().y * 38;
		if (m_Field.getPoint().y % 2 == 1) {
			horPos += 21.5;
		}
		vertPos += 50;
		horPos += 50;
		Polygon p = new Polygon();
		for (int i = 0; i < 6; i++) {
			p.addPoint(
					(int) (horPos + 25 * Math.cos(i * 2 * Math.PI / 6
							+ (Math.PI / 2))),
					(int) (vertPos + 25 * Math.sin(i * 2 * Math.PI / 6
							+ (Math.PI / 2))));
		}

		int smellType = 0;

		for (Smell smell : m_Field.getSmells()) {
			int type = 0;
			if (smell instanceof AntSmell) {
				type = 2;
			} else if (smell instanceof FoodSmell) {
				type = 1;
			} else if (smell instanceof ExterminatorSmell) {
				type = 3;
			}

			smellType = Math.max(smellType, type);
		}

		if (smellType == 3) {
			g.setColor(Color.green);
			g.fillPolygon(p);
		} else if (smellType == 2) {
			g.setColor(Color.yellow);
			g.fillPolygon(p);
		} else if (smellType == 1) {
			g.setColor(Color.orange);
			g.fillPolygon(p);
		}
		g.setColor(Color.black);
		g.drawPolygon(p);
	}

}