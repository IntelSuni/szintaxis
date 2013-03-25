package System;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

import java.util.ArrayList;

/**
 * Hangy�t megval�s�t� oszt�ly.
 */
public class Ant implements Updatable, Visitor, Element {
	/**
	 * A hangya neve.
	 */
	private String name;
	/**
	 * A hangya jelenleg melyik p�ly�n lev� mez�ben van (tart�zkod�si helye).
	 */
	private Field field;
	/**
	 * A hangya �lete.
	 */
	private int HealtPoint;
	/**
	 * A hangya m�rgezetts�gi szinje.
	 */
	private int poisonLevel;
	/**
	 * A hangya eddig mely mez�kben j�rt, miel�tt a jelenlegi mez�be l�pett volna.
	 */
	private ArrayList<Field> visitedFields;

	public Ant() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * L�trehoz egy hangy�t a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen a hangya l�trej�n
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
	 * Visitor tervez�si mint�nak megfelel� accept, a param�terben megkapott {@code Visitor}-on megh�vja annak visit met�dus�t �nmag�val param�terezve.
	 * 
	 * @param visiting visit met�dus�nak megh�v�s�ra
	 */
	public void accept(Visitor visiting) {
		Tracer.Instance().Trace(Direction.Enter, visiting);
		visiting.visit(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code level} �rt�kkel n�veli a hangya m�rgezetts�gi szintj�t.
	 * 
	 * @param level ennyivel n�veli a m�rgezetts�gi szintet
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
	 * Eld�nti �s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} k�z�l a hangya hova l�pjen.
	 * 
	 * @param a a mez�k list�ja, amelyek k�z�l kiv�lasztja a k�vetkez� mez�t
	 * @return Field a k�vetkez� mez�, amelyre a hangya l�p
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
				// nem tudom hogy mit kell kezdeni az elementekkel amikor ir�nyt
				// d�nt�k el.
			}

			// eldonteni a szag alapjan �s az alapjan hogy blokkolt e a mezo
			// a true a blokkolts�g vizsg�lata valahogy:)
			if ((actual_intensity > lastintensity) && (true)) {
				lastintensity = actual_intensity;
				eredmeny = l;
			}
		}

		Tracer.Instance().Trace(Direction.Leave, field);
		return eredmeny;
	}

	/**
	 * Cs�kkenti a hangya �letpontj�t.
	 */
	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * A hangya meghal, elt�vol�tja saj�t mag�t a mez�j�b�l.
	 */
	public void kill() {
		Tracer.Instance().Trace(Direction.Enter);
		this.field.removeElement(this);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Be�ll�tja a {@code Field} param�tert a saj�t mez�j�re.
	 * 
	 * @param field a mez�, amelyre be�ll�tja a saj�t mez�j�t
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(Direction.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Megk�ri az aktu�lis mez�t mondja meg ki a 
	 * szomsz�dja. Az eredm�nyen megh�vja a DecideDirection f�ggv�nyt, majd t�rli a hangya
	 * mag�t a aktu�lis mez�b�l �s hozz�adja mag�t a m�sik mez�re.
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
		
		// m�regszint alapj�n az �letpontok friss�t�se
		ArrayList<Smell> smells = this.field.getSmells();
		for (Smell s : smells) {
			s.activate(this);
		}
		
		this.decreaseHealtPoint();

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Antlion} l�togat�sa eset�n a hangya meghal.
	 * 
	 * @param antlion visit�l� objektum
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Ant} l�togat�sa.
	 * 
	 * @param ant visit�l� objektum
	 */
	public void visit(Ant ant) {
		Tracer.Instance().Trace(Direction.Enter, ant);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Block} l�togat�sa.
	 * 
	 * @param akadaly visit�l� objektum
	 */
	public void visit(Block akadaly) {
		Tracer.Instance().Trace(Direction.Enter, akadaly);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code FoodStore} l�togat�sa.
	 * 
	 * @param foodstore
	 *            a hangya a megl�togatott {@code FoodStore}-ban eszik majd, miut�n evett meghal
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		foodstore.eat();
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Anteater} l�togat�sa eset�n a hangya meghal.
	 * 
	 * @param anteater visit�l� objektum
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		this.kill();
		Tracer.Instance().Trace(Direction.Leave);
	}

}