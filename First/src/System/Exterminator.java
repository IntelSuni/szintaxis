package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyairt�t megval�s�t� oszt�ly.
 */
public class Exterminator extends Spray {

	public Exterminator() {
		super();
	}

	/* (non-Javadoc)
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

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezo r� helyezei el az {@code ExterminatorSmell} szagot
	 */
	public void use(Field mezo) {
		if(this.capacity > 0){
			ExterminatorSmell exterminatorSmell = new ExterminatorSmell();
			// A mez�re tesz Irt�szagot
			mezo.addSmell(exterminatorSmell);
			
			// A mez� hangya elemein aktiv�lja az irt�szagot.
			for (Element e : mezo.getElements()) {
				if (e instanceof Ant) {
					exterminatorSmell.activate((Ant) e);
				}
			}
			
			// A mez� szomsz�djaira tesz irt�szagot
			for (Field neighbours : mezo.getNeighbours()) {
				neighbours.addSmell(exterminatorSmell);
				for (Element e : neighbours.getElements()) {
					if (e instanceof Ant) {
						exterminatorSmell.activate((Ant) e);
					}
				}
			}
			this.capacity--;
		}
	}

}