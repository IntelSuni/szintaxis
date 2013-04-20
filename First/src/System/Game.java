package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Játékot megvalósító osztály.
 */
public class Game {

	/**
	 * A pálya mely tartalmazza a mezõket.
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
	 * A játék vége, ablak bezárása.
	 */
	public void Exit() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Segítség a játékosnak.
	 */
	public void Help() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Új játék indítása, a játéktér létrehozása, inicializálása.
	 */
	public void newGame() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		gamefield = GameField.instanceOf();
		gamefield.Initialize();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A játék felfüggesztése.
	 */
	public void Pause() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}