package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

import java.util.List;

/**
 * Hangy�szt megval�s�t� oszt�ly.
 */
public class Anteater implements Updatable, Element, Visitor {

	/**
	 * A hangy�sz ezen a mez�n van.
	 */
	private Field currentField;
	/**
	 * A hangy�sz �ltal megevett hangy�k sz�ma.
	 */
	private int eatenAnts;

	public Anteater() {
		Tracer.Instance().Trace(Direction.Enter);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Anteater []";
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
	 * Eld�nti �s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} k�z�l a hangy�sz hova l�pjen.
	 * 
	 * @param fields a mez�k list�ja, amelyek k�z�l kiv�lasztja a k�vetkez� mez�t
	 * @return Field a k�vetkez� mez�, amelyre a hangya l�p
	 */
	public Field decideDirection(List<Field> fields) {
		Tracer.Instance().Trace(Direction.Enter, fields);
		Field result = null;
		Tracer.Instance().Trace(Direction.Leave, result);
		return result;
	}

	/**
	 * N�veli a megevett hangy�k sz�m�t, ha m�g ehet ({@code eatenAnts} < 3) 
	 * �s meg�li a mez�n szerepl� hangy�t
	 */
	public void eat() {
		Tracer.Instance().Trace(Direction.Enter);
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
		currentField = field;
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Megk�ri az aktu�lis mez�t mondja meg ki a 
	 * szomsz�dja. Az eredm�nyen megh�vja a DecideDirection f�ggv�nyt, majd t�rli a hangy�sz
	 * mag�t a aktu�lis mez�b�l �s hozz�adja mag�t a m�sik mez�re. 
	 * Ha a mez�n hangya van, akkor megeszi.
	 */
	public void update() {
		Tracer.Instance().Trace(Direction.Enter);
		List<Field> neighbours = currentField.getNeighbours();
		Field target = decideDirection(neighbours);

		// A teszt miatt, mivel a decideDirection m�g nincs implement�lva.
		target = neighbours.get(0);

		target.addElement(this);

		setField(target);

		List<Element> elements = target.getElements();

		for (Element element : elements) {
			element.accept(this);
		}

		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Antlion} l�togat�sa.
	 * 
	 * @param antlion visit�l� objektum
	 */
	public void visit(Antlion antlion) {
		Tracer.Instance().Trace(Direction.Enter, antlion);
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
	 * @param foodstore visit�l� objektum
	 */
	public void visit(FoodStore foodstore) {
		Tracer.Instance().Trace(Direction.Enter, foodstore);
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * {@code Anteater} l�togat�sa eset�n a hangya meghal.
	 * 
	 * @param anteater visit�l� objektum
	 */
	public void visit(Anteater anteater) {
		Tracer.Instance().Trace(Direction.Enter, anteater);
		Tracer.Instance().Trace(Direction.Leave);
	}

}
