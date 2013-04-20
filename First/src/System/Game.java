package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * J�t�kot megval�s�t� oszt�ly.
 */
public class Game {

	/**
	 * A p�lya mely tartalmazza a mez�ket.
	 */
	private GameField gamefield;

	public Game() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A j�t�k v�ge, ablak bez�r�sa.
	 */
	public void Exit() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Seg�ts�g a j�t�kosnak.
	 */
	public void Help() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * �j j�t�k ind�t�sa, a j�t�kt�r l�trehoz�sa, inicializ�l�sa.
	 */
	public void newGame() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		gamefield = GameField.instanceOf();
		gamefield.Initialize();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A j�t�k felf�ggeszt�se.
	 */
	public void Pause() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}