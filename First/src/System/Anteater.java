package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

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
	private Direction direction;

	public Anteater() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		eatenAnts=0;
		currentField=null;
		direction=Direction.east;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	/**
	 * Masik constructor hatha kell
	 */
	public Anteater(Field field){
		eatenAnts=0;
		currentField=field;
		direction=Direction.east;
	}
	/**
	 * Az alap irany megvalasztasa létrehozáskor
	 * @param field
	 * @param defDirection
	 */
	public Anteater(Field field,Direction defDirection){
		eatenAnts=0;
		currentField=field;
		direction=defDirection;
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
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * Eld�nti �s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} k�z�l a hangy�sz hova l�pjen.
	 * 
	 * @param fields a mez�k list�ja, amelyek k�z�l kiv�lasztja a k�vetkez� mez�t
	 * @return Field a k�vetkez� mez�, amelyre a hangya l�p
	 */
	public Field decideDirection(List<Field> fields) {
		Tracer.Instance().Trace(TracerDirection.Enter, fields);
		Field result = null;
		int x,y;
		x=currentField.getPoint().x;
		y=currentField.getPoint().y;
		switch (direction) {
		case east:	
				for(Field f : fields){
					if (f.getPoint().y==y){
						if(f.getPoint().x>y)result=f;
					}
				}
			break;
		case northEast:		
			for(Field f : fields){
				if (f.getPoint().y>=y){
					if(f.getPoint().x>x)result=f;
				}
			}
			break;
		case northWest:		
			for(Field f : fields){
				if (f.getPoint().y<=y){
					if(f.getPoint().x<x)result=f;
				}
			}
			break;
		case west:
			for(Field f : fields){
				if (f.getPoint().y==y){
					if(f.getPoint().x<x)result=f;
				}
			}
			break;
		case southWest:		
			for(Field f : fields){
				if (f.getPoint().y<=y){
					if(f.getPoint().x<y)result=f;
				}
			}
			break;
		case southEast:		
			for(Field f : fields){
				if (f.getPoint().y<=y){
					if(f.getPoint().x>y)result=f;
				}
			}
			break;
		
		default:
			break;
		
		}
		Tracer.Instance().Trace(TracerDirection.Leave, result);
		return result;
	}

	/**
	 * N�veli a megevett hangy�k sz�m�t, ha m�g ehet ({@code eatenAnts} < 3) 
	 * �s meg�li a mez�n szerepl� hangy�t
	 */
	public void eat() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		if (this.eatenAnts <= 3) {
			this.eatenAnts++;
		}
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
		currentField = field;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megk�ri az aktu�lis mez�t mondja meg ki a 
	 * szomsz�dja. Az eredm�nyen megh�vja a DecideDirection f�ggv�nyt, majd t�rli a hangy�sz
	 * mag�t a aktu�lis mez�b�l �s hozz�adja mag�t a m�sik mez�re. 
	 * Ha a mez�n hangya van, akkor megeszi.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		List<Field> neighbours = currentField.getNeighbours();
		Field target = decideDirection(neighbours);
		
		currentField.removeElement(this);
		target.addElement(this);
		setField(target);

		List<Element> elements = target.getElements();

		for (Element element : elements) {
			element.accept(this);
		}

		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code Antlion} l�togat�sa.
	 * 
	 * @param antlion visit�l� objektum
	 */
	public boolean visit(Antlion antlion) {
		Tracer.Instance().Trace(TracerDirection.Enter, antlion);
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
	 * @param foodstore visit�l� objektum
	 */
	public boolean visit(FoodStore foodstore) {
		Tracer.Instance().Trace(TracerDirection.Enter, foodstore);
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
