package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyaszag semleges�t�t megval�s�t� oszt�ly.
 */
public class Neutralizer extends Spray {

	public Neutralizer() {
		super();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Neutralizer []";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell}
	 * szagot rak.
	 * 
	 * @param mezoelt�vol�tja
	 *            a mez�r�l �s a szomsz�djair�l a hangyaszagot
	 */
	public void use(Field mezo) {
		// Tracer.Instance().Trace(TracerDirection.Enter);

		if (this.capacity > 0) {

			// Elt�nteti a mez�r�l a hangyaszagot.
			ArrayList<Smell> Smells = mezo.getSmells();
			int sSize = Smells.size();
			for (int i = 0; i < sSize; i++) {
				Smell s = Smells.get(i);
				if (s instanceof AntSmell || s instanceof FoodSmell) {
					Smells.remove(s);
				}
			}

			// Elt�nteti a mez� szomsz�djair�l a hangyaszagot.
			ArrayList<Field> neighbours = mezo.getNeighbours();
			int nSize = neighbours.size();
			for (int i = 0; i < nSize; i++) {
				Field f = neighbours.get(i);
				ArrayList<Smell> nSmells = f.getSmells();
				int nSSize = nSmells.size();
				for (int j = 0; j < nSSize; j++) {
					if (j >= nSmells.size()) {
						break;
					}
					Smell s = nSmells.get(j);
					if (s instanceof AntSmell || s instanceof FoodSmell) {
						nSmells.remove(s);
					}
				}
			}
			this.capacity--;
			System.out.println(this.getClass().getSimpleName()
					+ " used successfully on " + mezo.getPoint().x + ","
					+ mezo.getPoint().y + " and its neighbours.");
		}
		// Tracer.Instance().Trace(TracerDirection.Leave);
	}

}