package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Hangyaszag semleges�t�t megval�s�t� oszt�ly.

 */
public class Neutralizer extends Spray {

	public Neutralizer(){
		super();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/* (non-Javadoc)
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
	public void onDraw(){
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Field} param�terre �s szomsz�djaira {@code ExterminatorSmell} szagot rak.
	 * 
	 * @param mezoelt�vol�tja a mez�r�l �s a szomsz�djair�l a hangyaszagot
	 */
	public void use(Field mezo){
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if (this.capacity > 0) {
			// Elt�nteti a mez�r�l a hangyaszagot.
			for (Smell smells : mezo.getSmells()) {
				if (smells.getClass().getName().contains("AntSmell")) {
					mezo.getSmells().remove(smells);
				}
			}
			//Elt�nteti a mez� szomsz�djair�l a hangyaszagot.
			ArrayList<Field> neighbours = mezo.getNeighbours();
			for (Field field : neighbours) {
				for (Smell smells : field.getSmells()) {
					if (smells.getClass().getName().contains("AntSmell")) {
						field.getSmells().remove(smells);
					}
				}
			}
			this.capacity--;
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}