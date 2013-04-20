package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.util.ArrayList;

/**
 * Hangy�t megval�s�t� oszt�ly.
 */
public class Ant implements Updatable, Visitor, Element {
	/**
	 * A hangya halad�si ir�nya.
	 */
	private Direction direction;
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
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.HealtPoint = 20;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * L�trehoz egy hangy�t a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen a hangya l�trej�n
	 */
	public Ant(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.HealtPoint = 20;
		Tracer.Instance().Trace(TracerDirection.Leave);
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
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * {@code level} �rt�kkel n�veli a hangya m�rgezetts�gi szintj�t.
	 * 
	 * @param level ennyivel n�veli a m�rgezetts�gi szintet
	 */
	public void addPoisonLevel(int level) {
		Tracer.Instance().Trace(TracerDirection.Enter, level);
		this.poisonLevel += level;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * 
	 * @param f
	 */
	public void blocked_direction(Field f) {
		Tracer.Instance().Trace(TracerDirection.Enter, f);
		this.visitedFields.add(f);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Eld�nti �s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} k�z�l a hangya hova l�pjen.
	 * 
	 * @param a a mez�k list�ja, amelyek k�z�l kiv�lasztja a k�vetkez� mez�t
	 * @return Field a k�vetkez� mez�, amelyre a hangya l�p
	 */
	public Field decideDirection(ArrayList<Field> a) {
		Tracer.Instance().Trace(TracerDirection.Enter, a);
		
		ArrayList<Smell> smells = new ArrayList<Smell>();
		Field chosenField = null;
		int intensity = 0, smellIntensity = 0;
		
		// A mez� szomsz�djain lev� hangya- �s �telszagokat �sszegzi
		// �s azt v�lasztja, amelyik ezek k�z�l a legnagyobb
		// (A legutols�t v�lasztja.)
		for (Field field : a) {
			smells.addAll(field.getSmells());
			
			for (Smell smell : smells) {
				String smellClassName = smell.getClass().getName();
				if (smellClassName.contains("AntSmell") || smellClassName.contains("FoodSmell")) {
					smellIntensity += smell.getIntensity();
				}
			}
			
			if (smellIntensity >= intensity) {
				intensity = smellIntensity;
				chosenField = field;
			}
			smells.clear();
		}

		Tracer.Instance().Trace(TracerDirection.Leave, field);
		
		return chosenField;
	}

	/**
	 * Cs�kkenti a hangya �letpontj�t.
	 */
	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		// M�rgezetts�g eset�n cs�kken a HP.
		if (this.poisonLevel > 0) {
			this.HealtPoint -= this.poisonLevel;
		}
		// Ha nincs HP, a hangya meghal.
		if (this.HealtPoint <= 0) {
			this.kill();
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A hangya meghal, elt�vol�tja saj�t mag�t a mez�j�b�l.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.field.removeElement(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Be�ll�tja a {@code Field} param�tert a saj�t mez�j�re.
	 * 
	 * @param field a mez�, amelyre be�ll�tja a saj�t mez�j�t
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megk�ri az aktu�lis mez�t mondja meg ki a 
	 * szomsz�dja. Az eredm�nyen megh�vja a DecideDirection f�ggv�nyt, majd t�rli a hangya
	 * mag�t a aktu�lis mez�b�l �s hozz�adja mag�t a m�sik mez�re.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
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

		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code Antlion} l�togat�sa eset�n a hangya meghal.
	 * 
	 * @param antlion visit�l� objektum
	 */
	public boolean visit(Antlion antlion) {
		Tracer.Instance().Trace(TracerDirection.Enter, antlion);
		this.kill();
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Ant} l�togat�sa.
	 * 
	 * @param ant visit�l� objektum
	 * @return 
	 */
	public boolean visit(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter, ant);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * {@code Block} l�togat�sa.
	 * 
	 * @param akadaly visit�l� objektum
	 * @return 
	 */
	public boolean visit(Block akadaly) {
		Tracer.Instance().Trace(TracerDirection.Enter, akadaly);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * {@code FoodStore} l�togat�sa.
	 * 
	 * @param foodstore
	 *            a hangya a megl�togatott {@code FoodStore}-ban eszik majd, miut�n evett meghal
	 */
	public boolean visit(FoodStore foodstore) {
		Tracer.Instance().Trace(TracerDirection.Enter, foodstore);
		foodstore.eat();
		this.kill();
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Anteater} l�togat�sa eset�n a hangya meghal.
	 * 
	 * @param anteater visit�l� objektum
	 */
	public boolean visit(Anteater anteater) {
		Tracer.Instance().Trace(TracerDirection.Enter, anteater);
		anteater.eat(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Stone} l�togat�sa.
	 * 
	 * @param stone visit�l� objektum
	 */
	@Override
	public boolean visit(Stone stone) {
		Tracer.Instance().Trace(TracerDirection.Enter, stone);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	@Override
	public boolean visit(AntHill antHill) {
		// TODO Auto-generated method stub
		return true;
	}

}