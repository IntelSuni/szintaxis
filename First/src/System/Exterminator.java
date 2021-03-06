package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyairt�t megval�s�t� oszt�ly.
 */
public class Exterminator extends Spray {

	/**
	 * L�trehozza a hangyairt�t.
	 */
	public Exterminator() {
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
		return "Exterminator []";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/*
	 * (non-Javadoc)
	 * @see System.Spray#onDraw()
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell}
	 * szagot rak.
	 * 
	 * @param mezo
	 *            r� helyezei el az {@code ExterminatorSmell} szagot
	 */
	public void use(Field mezo) {
		Tracer.Instance().Trace(TracerDirection.Enter, mezo);

		if (this.capacity > 0) {
			ExterminatorSmell exterminatorSmell = new ExterminatorSmell(mezo);
			// A mez�re tesz Irt�szagot
			mezo.addSmell(exterminatorSmell);
			GameField.instanceOf().registerNewUpdatable(exterminatorSmell);
			// mezo.addSmellToNeighbours(exterminatorSmell);

			// A mez� hangya elemein aktiv�lja az irt�szagot.
			for (Element e : mezo.getElements()) {
				if (e instanceof Ant) {
					exterminatorSmell.activate((Ant) e);
				}
			}

			// A mez� szomsz�djaira tesz irt�szagot
			for (Field neighbours : mezo.getNeighbours()) {
				if (neighbours == null) {
					break;
				}
				ExterminatorSmell nExterminatorSmell = new ExterminatorSmell(
						neighbours);
				neighbours.addSmell(nExterminatorSmell);
				GameField.instanceOf().registerNewUpdatable(nExterminatorSmell);
				for (Element e : neighbours.getElements()) {
					if (e instanceof Ant) {
						exterminatorSmell.activate((Ant) e);
					}
				}
			}
			this.capacity--;
			System.out.println(this.getClass().getSimpleName()
					+ " used successfully on " + mezo.getPoint().x + ","
					+ mezo.getPoint().y + " and its neighbours.");
		}

		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}