package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Hangyï¿½szt megvalï¿½sï¿½tï¿½ osztï¿½ly.
 */
public class Anteater implements Updatable, Element, Visitor {

	/**
	 * A hangyï¿½sz ezen a mezï¿½n van.
	 */
	private Field currentField;
	/**
	 * A hangyï¿½sz ï¿½ltal megevett hangyï¿½k szï¿½ma.
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
	 * Az alap irany megvalasztasa lÃ©trehozÃ¡skor
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
	 * Visitor tervezï¿½si mintï¿½nak megfelelï¿½ accept, a paramï¿½terben megkapott {@code Visitor}-on meghï¿½vja annak visit metï¿½dusï¿½t ï¿½nmagï¿½val paramï¿½terezve.
	 * 
	 * @param visiting visit metï¿½dusï¿½nak meghï¿½vï¿½sï¿½ra
	 */
	public boolean accept(Visitor visiting) {
		Tracer.Instance().Trace(TracerDirection.Enter, visiting);
		boolean result=visiting.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * Eldï¿½nti ï¿½s {@code Field}-ben visszaadja, hogy a {@code ArrayList<Field>} kï¿½zï¿½l a hangyï¿½sz hova lï¿½pjen.
	 * 
	 * @param fields a mezï¿½k listï¿½ja, amelyek kï¿½zï¿½l kivï¿½lasztja a kï¿½vetkezï¿½ mezï¿½t
	 * @return Field a kï¿½vetkezï¿½ mezï¿½, amelyre a hangya lï¿½p
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
						//y-t lecseréltem x-re, mert különben nem adott vissz eredményt
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
	 * Nï¿½veli a megevett hangyï¿½k szï¿½mï¿½t, ha mï¿½g ehet ({@code eatenAnts} < 3) 
	 * ï¿½s megï¿½li a mezï¿½n szereplï¿½ hangyï¿½t
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
	 * Grafikus vï¿½ltozathoz kirajzolï¿½sï¿½hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Beï¿½llï¿½tja a {@code Field} paramï¿½tert a sajï¿½t mezï¿½jï¿½re.
	 * 
	 * @param field a mezï¿½, amelyre beï¿½llï¿½tja a sajï¿½t mezï¿½jï¿½t
	 */
	public void setField(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		currentField = field;
		this.NotifyView();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megkï¿½ri az aktuï¿½lis mezï¿½t mondja meg ki a 
	 * szomszï¿½dja. Az eredmï¿½nyen meghï¿½vja a DecideDirection fï¿½ggvï¿½nyt, majd tï¿½rli a hangyï¿½sz
	 * magï¿½t a aktuï¿½lis mezï¿½bï¿½l ï¿½s hozzï¿½adja magï¿½t a mï¿½sik mezï¿½re. 
	 * Ha a mezï¿½n hangya van, akkor megeszi.
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

			// ConcurentModificationException megszüntetése
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
	 * {@code Antlion} lï¿½togatï¿½sa.
	 * 
	 * @param antlion visitï¿½lï¿½ objektum
	 */
	public boolean visit(Antlion antlion) {
		Tracer.Instance().Trace(TracerDirection.Enter, antlion);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Ant} lï¿½togatï¿½sa.
	 * 
	 * @param ant visitï¿½lï¿½ objektum
	 * @return 
	 */
	public boolean visit(Ant ant) {
		Tracer.Instance().Trace(TracerDirection.Enter, ant);
		eat(ant);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Block} lï¿½togatï¿½sa.
	 * 
	 * @param akadaly visitï¿½lï¿½ objektum
	 * @return 
	 */
	public boolean visit(Block akadaly) {
		Tracer.Instance().Trace(TracerDirection.Enter, akadaly);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code FoodStore} lï¿½togatï¿½sa.
	 * 
	 * @param foodstore visitï¿½lï¿½ objektum
	 */
	public boolean visit(FoodStore foodstore) {
		Tracer.Instance().Trace(TracerDirection.Enter, foodstore);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Anteater} lï¿½togatï¿½sa esetï¿½n a hangya meghal.
	 * 
	 * @param anteater visitï¿½lï¿½ objektum
	 */
	public boolean visit(Anteater anteater) {
		Tracer.Instance().Trace(TracerDirection.Enter, anteater);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return true;
	}

	/**
	 * {@code Stone} lï¿½togatï¿½sa.
	 * 
	 * @param stone visitï¿½lï¿½ objektum
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
