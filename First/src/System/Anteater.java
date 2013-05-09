package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.util.ArrayList;
import java.util.Vector;

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
	
	private Vector<View> views;

	public Anteater() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		eatenAnts=0;
		currentField=null;
		direction=Direction.east;
		this.views = new Vector<View>();
//		GameField.instanceOf().registerNewUpdatable(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	/**
	 * Masik constructor hatha kell
	 */
	public Anteater(Field field){
		eatenAnts=0;
		currentField=field;
		direction=Direction.east;
		this.views = new Vector<View>();
		this.NotifyView();
//		GameField.instanceOf().registerNewUpdatable(this);
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
//		GameField.instanceOf().registerNewUpdatable(this);
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
	public Field decideDirection(ArrayList<Field> fields) {
		Tracer.Instance().Trace(TracerDirection.Enter, fields);
		Field result = null;
		int x,y;
		x=currentField.getPoint().x;
		y=currentField.getPoint().y;
		
		switch (direction) {
		case east:	
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y==y){
						//y-t lecser�ltem x-re, mert k�l�nben nem adott vissz eredm�nyt
						if(f.getPoint().x>x)result=f;
					}
				}	
			}
			break;
		case northEast:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y>=y){
						if(f.getPoint().x>x)result=f;
					}
				}
			}
			break;
		case northWest:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x<x)result=f;
					}
				}
			}
			break;
		case west:
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y==y){
						if(f.getPoint().x<x)result=f;
					}
				}
				if (f.getPoint().y==y){
					if(f.getPoint().x<x)result=f;
				}
			}
			break;
		case southWest:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x<y)result=f;
					}
				}
			}
			break;
		case southEast:		
			for(Field f : fields){
				if (f != null) {
					if (f.getPoint().y<=y){
						if(f.getPoint().x>y)result=f;
					}
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
	 * @param ant 

	 */
	public void eat(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter);
		if (this.eatenAnts < 3) {
			this.eatenAnts++;
			ant.kill();
			ant = null;
			System.out.println("\tAnt killed by Anteater.");
			System.out.println("\tAnteater ate an Ant.");
		}
		Tracer.Instance().Trace(TracerDirection.Leave, this.eatenAnts);
	
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
		this.NotifyView();
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
		ArrayList<Field> neighbours = currentField.getNeighbours();
		Field target = decideDirection(neighbours);
		
		if (target != null) {
			Field prev=currentField;
			
			System.out.println("\tAnteater moved from " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");

			currentField.removeElement(this);
			target.addElement(this);
			this.setField(target);

			System.out.println("\tAnteater moved to " + this.currentField.getPoint().x + "," + this.currentField.getPoint().y + ".");
			
			ArrayList<Element> elements = target.getElements();

			// ConcurentModificationException megsz�ntet�se
//			for (Element element : elements) {
//				if(!element.accept(this)){
//					currentField=prev;
//					target.removeElement(this);
//					currentField.addElement(this);
//					direction=direction.negate();
//				}
//			}
			
			int eSize = elements.size();
			for (int i = 0; i < eSize - 1; i++) {
				Element element = elements.get(i);
				if (!element.accept(this)) {
					currentField = prev;
					target.removeElement(this);
					currentField.addElement(this);
					direction = direction.negate();
				}
			}
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
		eat(ant);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
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
		return true;
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
		
		boolean result=stone.moving(direction);
		if (result == true) {
			System.out.println("\tAnteater moved stone.");
		}
		else{
			System.out.println("\tAnteater cannot moved stone.");
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}
	@Override
	public boolean visit(AntHill antHill) {
		return true;
	}


	@Override
	public void Attach(View view) {
		if (this.views.isEmpty()) {
			this.views = new Vector<View>();
		}
		else{
			this.views.add(view);
		}	
	}

	@Override
	public void Detach(View view) {
		if (this.views.contains(view)) {
			this.views.remove(view);
		}
	}

	@Override
	public void NotifyView() {
		for (View view : this.views) {
			view.Update();
		}
	}

}
