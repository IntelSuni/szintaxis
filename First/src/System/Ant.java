package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.util.ArrayList;

/**
 * bool változó tárolja, hogy a hangya mérgezett e; csökkenti az életét
 * 
 * @author gbeatrix
 * @version 1.0
 * @created 20-márc.-2013 10:42:45
 */
public class Ant implements Updatable, Visitor, Element {
	private String name;
	private Field field;
	private int HealtPoint;
	private int poisonLevel;
	private ArrayList<Field> visitedFields;

	public Ant() {
		Tracer.Instance().Trace(Direction.Enter);
		// System.out.println(getClass().getName() + " created.");
		Tracer.Instance().Trace(Direction.Leave);
	}

	public Ant(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ant [name=" + name + "]";
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param visiting
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param level
	 */
	public void addPoisonLevel(int level) {
		Tracer.Instance().Trace(Direction.Enter, level);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param f
	 */
	public void blocked_direction(Field f) {
		Tracer.Instance().Trace(Direction.Enter, f);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param a
	 */
	public Field decideDirection(ArrayList<Field> a) {
		Tracer.Instance().Trace(Direction.Enter, a);
		ArrayList<Smell> q = null;
		ArrayList<Element> z = null;
		Field eredmeny = null;
		int lastintensity = -1, actual_intensity = 0;
		for (Field l : a) {
			actual_intensity = 0;
			q = l.getSmells();
			for (Smell s : q) {
				actual_intensity += s.getIntensity();
			}
			z = l.getElements();
			for (Element s : z) {
				// nem tudom hogy mit kell kezdeni az elementekkel amikor irányt
				// döntök el.
			}

			// eldonteni a szag alapjan és az alapjan hogy blokkolt e a mezo
			// a true a blokkoltság vizsgálata valahogy:)
			if ((actual_intensity > lastintensity) && (true)) {
				lastintensity = actual_intensity;
				eredmeny = l;
			}
		}

		Tracer.Instance().Trace(Direction.Leave, field);
		return eredmeny;
	}

	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * meghalaskor hivja a hangya kiszedi magát az aktuális mezõbõl
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		this.field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param field
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * az update függvény megkéri az aktuális mezõt hogy mondja meg hogy ki a
	 * szomszédja az eredmenyen meghívja a decide directiont majd törli a hangya
	 * magát a aktuális mezõbõl átmozog a másik mezõre
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		// a kovetkezo mezo eldontese
		Field next_field;
		ArrayList<Field> neighbours = field.getNeighbours();
		next_field = decideDirection(neighbours);

		// atmozgas a kovetkezo mezore
		field.removeElement(this);
		next_field.addElement(this);
		field = next_field;

		// visitor minta alkalmazasa
		ArrayList<Element> aktualis_mezoe = field.getElements();
		for (Element s : aktualis_mezoe) {
			s.accept(this);
		}

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param antlion
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param ant
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter, ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param akadaly
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter, akadaly);
		Tracer.Instance().Trace(Direction.Leave);

	}

	/**
	 * 
	 * @param foodstore
	 *            a hangya a meglátogatott foodstore ban eszik majd miutan evett
	 *            meghal a jollakottsagtol
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		foodstore.eat();
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * 
	 * @param anteater
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		Tracer.Instance().Trace(Direction.Leave);
	}

}