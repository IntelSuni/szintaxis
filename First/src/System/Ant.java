package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.util.ArrayList;

/**
 * Hangyát megvalósító osztály.
 */
public class Ant implements Updatable, Visitor, Element {
	/**
	 * A hangya neve.
	 */
	private String name;
	/**
	 * A hangya jelenleg melyik pályán levõ mezõben van (tartózkodási helye).
	 */
	private Field field;
	/**
	 * A hangya élete.
	 */
	private int HealtPoint;
	/**
	 * A hangya mérgezettségi szinje.
	 */
	private int poisonLevel;
	/**
	 * A hangya eddig mely mezõkben járt, mielõtt a jelenlegi mezõbe lépett volna.
	 */
	private ArrayList<Field> visitedFields;

	public Ant() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Létrehoz egy hangyát a {@code field} mezõn.
	 * 
	 * @param field a mezõ, amelyen a hangya létrejön
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 * 
	 * @param visiting visit metódusának meghívására
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		visiting.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code level} értékkel növeli a hangya mérgezettségi szintjét.
	 * 
	 * @param level ennyivel növeli a mérgezettségi szintet
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
	 * Eldönti és {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} közül a hangya hova lépjen.
	 * 
	 * @param a a mezõk listája, amelyek közül kiválasztja a következõ mezõt
	 * @return Field a következõ mezõ, amelyre a hangya lép
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

	/**
	 * Csökkenti a hangya életpontját.
	 */
	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangya meghal, eltávolítja saját magát a mezõjébõl.
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		this.field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Beállítja a {@code Field} paramétert a saját mezõjére.
	 * 
	 * @param field a mezõ, amelyre beállítja a saját mezõjét
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Megkéri az aktuális mezõt mondja meg ki a 
	 * szomszédja. Az eredményen meghívja a DecideDirection függvényt, majd törli a hangya
	 * magát a aktuális mezõbõl és hozzáadja magát a másik mezõre.
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
		this.setField(next_field);

		// visitor minta alkalmazasa
		ArrayList<Element> aktualis_mezoe = this.field.getElements();
		for (Element s : aktualis_mezoe) {
			s.toString();
			s.accept(this);
		}
		
		// méregszint alapján az életpontok frissítése
		ArrayList<Smell> smells = this.field.getSmells();
		for (Smell s : smells) {
			s.activate(this);
		}
		
		this.decreaseHealtPoint();

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Antlion} látogatása esetén a hangya meghal.
	 * 
	 * @param antlion visitáló objektum
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Ant} látogatása.
	 * 
	 * @param ant visitáló objektum
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter, ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Block} látogatása.
	 * 
	 * @param akadaly visitáló objektum
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter, akadaly);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code FoodStore} látogatása.
	 * 
	 * @param foodstore
	 *            a hangya a meglátogatott {@code FoodStore}-ban eszik majd, miután evett meghal
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		foodstore.eat();
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Anteater} látogatása esetén a hangya meghal.
	 * 
	 * @param anteater visitáló objektum
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

}