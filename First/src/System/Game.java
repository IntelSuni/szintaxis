package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Játékot megvalósító osztály.
 */
public class Game {

	/**
	 * A pálya mely tartalmazza a mezõket.
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
	 * A játék vége, ablak bezárása.
	 */
	public void Exit() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Segítség a játékosnak.
	 */
	public void Help() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Új játék indítása, a játéktér létrehozása, inicializálása.
	 */
	public void newGame() {
		Tracer.Instance().Trace(Direction.Enter);
		gamefield = GameField.instanceOf();
		gamefield.Initialize();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A játék felfüggesztése.
	 */
	public void Pause() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

}