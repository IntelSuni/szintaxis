package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Akad�lyt megval�s�t� oszt�ly.
 */
public class Block implements Element {

	public Block() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Block []";
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
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 * 
	 * @param visitor visit met�dus�nak megh�v�s�ra
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter,visitor);
		boolean result=visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}