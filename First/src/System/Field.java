package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Mezï¿½t megvalï¿½sï¿½tï¿½ osztï¿½ly
 */
public class Field implements Element {

	/**
	 * A mezï¿½ ezen a {@code GameField}-en van
	 */
	GameField gameField;
	/**
	 * A mezï¿½n levï¿½ {@code Element}-ek listï¿½ja.
	 */
	private ArrayList<Element> elements;
//	private boolean move_blocked;
	/**
	 * A mezï¿½n szomszï¿½d {@code Element}-jeinek listï¿½ja.
	 */
	private ArrayList<Field> neighbours;
	/**
	 * A mezï¿½n koordinï¿½tï¿½i.
	 */
	private Point points;
	/**
	 * A mezï¿½n levï¿½ {@code Smell}-ek listï¿½ja.
	 */
	private ArrayList<Smell> smells;

	public Field() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * A {@code GameField}-re lï¿½trehozza a mezï¿½t, inicializï¿½lja a szomszï¿½dokat, elemeket ï¿½s a szagokat.
	 * 
	 * @param gameField a {@code GameField}, amelyen a mezï¿½ van.
	 */
	public Field(GameField gameField) {
		Tracer.Instance().Trace(TracerDirection.Enter, gameField);
		this.gameField = gameField;

		neighbours = new ArrayList<Field>();
		elements = new ArrayList<Element>();
		smells = new ArrayList<Smell>();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [points=" + points + "]";
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
	 * @param visitor visit metï¿½dusï¿½nak meghï¿½vï¿½sï¿½ra
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * Az {@code Element} objektumot a mezï¿½ {@code Element}-eket tï¿½rolï¿½ listï¿½jï¿½hoz adja.
	 * 
	 * @param element az {@code Element}, amelyet a {@code Field}-hez ad
	 */
	public void addElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.elements.add(element);
		
		// Ha az új elem hangya, akkor a mezõn hagy egy hangyaszagot.
		if (element instanceof Ant) {
			this.addSmell(new AntSmell());
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozzï¿½ad egy szomszï¿½dot a szomszï¿½d listï¿½hoz.
	 * 
	 * @param neighbour
	 *            Hozzï¿½adandï¿½ szomszï¿½d.
	 */
	public void addNeighbour(Field neighbour) {
		Tracer.Instance().Trace(TracerDirection.Enter, neighbour);
//		if (this.neighbours.size() < 6) {
			this.neighbours.add(neighbour);
//		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozzï¿½ad egy szagot egy mezï¿½hï¿½z ï¿½s a mezï¿½ szomszï¿½djaihoz.
	 * 
	 * @param smell
	 *            Hozzï¿½adandï¿½ szag.
	 */
	public void addSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		
		smells.add(smell);
		
//		int intensityNeighbours=smell.getIntensity()-1;
//		ArrayList<Field> neighbours = this.getNeighbours();
//		ArrayList<Smell> szSmells=null;
//		for (Field n : neighbours){
//			szSmells=n.getSmells();
//			for(Smell s :szSmells){
//				//ha a szomszedos mezon volt mar ilyen szag
//				if(s.getClass()==smell.getClass()){
//					//es annak az erossege gyengebb mint az ujonnan adogatott
//					if(!(s.getIntensity()<intensityNeighbours)){
//						//aakkor letrehozunk egy uj szagot
//						if(smell instanceof ExterminatorSmell)
//							// StackOwerFlowError-t dob
//							n.addSmell(new ExterminatorSmell(intensityNeighbours));
//						else
//							n.addSmell(new FoodSmell(intensityNeighbours));
//					}
//				}
//			}
//		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * A mezõ szomszédjaihoz {@code Smell} szagot ad.
	 * 
	 * @param smell a hozzáadandó szag
	 */
	public void addSmellToNeighbours(Smell smell){
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		
		smell.decrementIntensity();
		ArrayList<Field> neighbours = this.getNeighbours();
		int nSize = neighbours.size();
		for (int i = 0; i < nSize; i++) {
			ArrayList<Smell> nSmells = neighbours.get(i).getSmells();
			int sSize = nSmells.size();
			for (int j = 0; j < sSize; j++) {
				Smell sSmell = nSmells.get(i);
				if (sSmell.getClass().equals(smell.getClass()) 
						&& sSmell.getIntensity() < smell.intensity) {
					sSmell = smell;
				}
			}
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code ArrayList<Element>} listï¿½ban megadja a mezï¿½n szereplï¿½ {@code Element} objektumokat.
	 * 
	 * @return a mezï¿½n levï¿½ elemek
	 */
	public ArrayList<Element> getElements() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, elements);
		return this.elements;
	}

	/**
	 * {@code ArrayList<Field>} listï¿½ban megadja a mezï¿½ szomszï¿½djait.
	 * 
	 * @return a mezï¿½n szomszï¿½djai
	 */
	public ArrayList<Field> getNeighbours() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, neighbours);
		return neighbours;
	}

	/**
	 * {@code Point}-ban megadja a mezï¿½n koordinï¿½tï¿½it.
	 * 
	 * @return a mezï¿½ koordinï¿½tï¿½i
	 */
	public Point getPoint() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, points);
		return points;
	}

	/**
	 * {@code ArrayList<Smell>} listï¿½ban megadja a mezï¿½n szereplï¿½ {@code Smell} szagokat.
	 * 
	 * @return a mezï¿½n levï¿½ szagok
	 */
	public ArrayList<Smell> getSmells() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, smells);
		return smells;
	}

	/**
	 * 
	 * @param h1 
	 */
	public boolean moveTo(Ant h1) {
		Tracer.Instance().Trace(TracerDirection.Enter, h1);
		for (Element e : this.elements) {
			e.accept(h1);
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
		return false;
	}

	/**
	 * Grafikus vï¿½ltozathoz kirajzolï¿½sï¿½hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Eltï¿½volï¿½tja az {@code Element} objektumot a mezï¿½rï¿½l.
	 * 
	 * @param element mezï¿½rï¿½l eltï¿½volï¿½tandï¿½ elem
	 */
	public void removeElement(Element element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		if (this.elements.contains(element)) {
			this.elements.remove(element);
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Eltï¿½volï¿½tja az {@code Smell} szagot a mezï¿½rï¿½l.
	 * 
	 * @param smell mezï¿½rï¿½l eltï¿½volï¿½tandï¿½ szag
	 */
	public void removeSmell(Smell smell) {
		Tracer.Instance().Trace(TracerDirection.Enter, smell);
		this.smells.remove(smell);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public void removeSmell() {
		Tracer.Instance().Trace(TracerDirection.Enter);

		for (int i = 0; i < this.smells.size(); i++) {
			Smell s = this.smells.get(i);
			if (s instanceof AntSmell || s instanceof FoodSmell) {
				this.smells.remove(s);
			}
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * 
	 * @param mov_blocked
	 */
	public void set_move_blocked(boolean mov_blocked) {
		Tracer.Instance().Trace(TracerDirection.Enter, mov_blocked);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Beï¿½llï¿½tja a mezï¿½ koordinï¿½tï¿½it
	 * 
	 * @param x
	 *            X koordinï¿½ta.
	 * @param y
	 *            Y koordinï¿½ta.
	 */
	public void setPoint(int x, int y) {
		Tracer.Instance().Trace(TracerDirection.Enter, x, y);
		points = new Point(x, y);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}
