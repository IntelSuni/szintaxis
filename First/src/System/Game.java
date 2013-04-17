package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * J�t�kot megval�s�t� oszt�ly.
 */
public class Game {

	/**
	 * A p�lya mely tartalmazza a mez�ket.
	 */
	private GameField gamefield;

	public Game() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A j�t�k v�ge, ablak bez�r�sa.
	 */
	public void Exit() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Seg�ts�g a j�t�kosnak.
	 */
	public void Help() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * �j j�t�k ind�t�sa, a j�t�kt�r l�trehoz�sa, inicializ�l�sa.
	 */
	public void newGame() {
		Tracer.Instance().Trace(Direction.Enter);
		gamefield = GameField.instanceOf();
		gamefield.Initialize();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A j�t�k felf�ggeszt�se.
	 */
	public void Pause() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}