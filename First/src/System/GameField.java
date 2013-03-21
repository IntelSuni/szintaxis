package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.awt.Point;
import java.util.ArrayList;

import javax.lang.model.element.ElementKind;

/**
 * Pálya
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:47
 */
public class GameField {

	private int anteaterNo;
	private int antHillNo;
	private int blockNo;
	private int foodStoreNo;
	private static GameField instance;
	private Point size;
	private ArrayList<Updatable> toUpdate;
	public Field m_Field;
	public Updatable m_Updatable;
	public Game m_Game;

	public void finalize() throws Throwable {

	}

	// csak a próba miatt public, eredetileg private !
	public GameField() {
		Tracer.Instance().Trace(Direction.Enter);
		// System.out.println(getClass().getName() + " created.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param element
	 * @param field
	 */
	public void addElementToField(Element element, Field field) {

	}

	/**
	 * 
	 * @param f
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(Direction.Enter, f);
		// final StackTraceElement[] ste =
		// Thread.currentThread().getStackTrace();
		// System.out.println(getClass().getName() + " " + ste[ste.length - 1 -
		// 1].getMethodName() + "() method called with "
		// + f.getClass().getName() + " parameter.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param points
	 */
	public Field getField(Point points) {
		return null;
	}

	public void Initialize() {

	}

	public static GameField instanceOf() {
		return null;
	}

	/**
	 * 
	 * @param element
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(Direction.Enter, element);
		// final StackTraceElement[] ste =
		// Thread.currentThread().getStackTrace();
		// System.out.println(getClass().getName() + " "
		// + ste[ste.length - 1 - 2].getMethodName()
		// + "() method called with " + element.getClass().getName()
		// + " parameter.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void updateUpdatables() {

	}

}