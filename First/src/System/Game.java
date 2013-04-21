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
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * A j�t�k v�ge, ablak bez�r�sa.
	 */
	public void Exit() {
	}

	/**
	 * Seg�ts�g a j�t�kosnak.
	 */
	public void Help() {
		}

	/**
	 * �j j�t�k ind�t�sa, a j�t�kt�r l�trehoz�sa, inicializ�l�sa.
	 */
	public void newGame() {
		gamefield = GameField.instanceOf();
		gamefield.Initialize();
	}

	/**
	 * A j�t�k felf�ggeszt�se.
	 */
	public void Pause() {
	}

}