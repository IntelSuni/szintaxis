package System;

import hu.szintaxis.graphics.AntView;
import hu.szintaxis.graphics.FieldView;
import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Pï¿½lyï¿½t megvalï¿½sï¿½tï¿½ osztï¿½ly.
 */
public class GameField {
	/**
	 * Pï¿½lyï¿½n levï¿½ hangyï¿½szok szï¿½ma.
	 */
	private int anteaterNo;
	/**
	 * Pï¿½lyï¿½n levï¿½ hangyabolyok szï¿½ma.
	 */
	private int antHillNo;
	/**
	 * Pï¿½lyï¿½n levï¿½ akadï¿½lyok szï¿½ma.
	 */
	private int blockNo;
	/**
	 * Pï¿½lyï¿½n levï¿½ ï¿½telraktï¿½rak szï¿½ma.
	 */
	private int foodStoreNo;
	/**
	 * Pï¿½lyï¿½t tï¿½rolï¿½ statikus objektum (singleton).
	 */
	private static GameField instance;
	/**
	 * Pï¿½lya mï¿½retkoordinï¿½tï¿½i.
	 */
	private Point size;
	/**
	 * Pï¿½lyï¿½n levï¿½ kavicsok szï¿½ma.
	 */
	private int stoneNo;
	/**
	 * Pï¿½lyï¿½n levï¿½ frissï¿½tendï¿½ objektumok.
	 */
	private ArrayList<Updatable> toUpdate;
	/**
	 * Mezï¿½ket tï¿½rolï¿½ lista.
	 */
	public List<Field> fields;
	/**
	 * 
	 */
	public Game game;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	/*
	 * Ez indítja el a teljes view updatet.
	 */
	public void draw(Graphics2D g) {
		for (Field field : fields) {
			// field.update();
			/*
			 * for (Element e : field.getElements()) {
				(View) e.notify();
			}
			*/
		}
	}

	// csak a tesztek miatt public, eredetileg private !
	public GameField() {
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
	}
	
	public GameField(Point size) {
		this();
		this.size = size;
		System.out.println("Successfully crated gameField of size " + size.x + "," + size.y + ".");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameField []";
	}

	/**
	 * Hozzï¿½ad egy {@code element}-et egy {@code field}-hez.
	 * @param element Hozzï¿½adantï¿½ element.
	 * @param field Field, amihez hozzï¿½ szeretnï¿½nk adni.
	 */
	public void addElementToField(Element element, Field field) {
		for (Field fields : this.fields) {
			if (fields.equals(field) == true) {
				fields.addElement(element);
				
			}
		}
		if (element instanceof Updatable) {

//			boolean antAddable = false, anteaterAddable = false;
//			for (Updatable u : this.toUpdate) {
//				if (u instanceof Anteater) {
//					antAddable = true;
//				}
//				else{
//					antAddable = false;
//				}
//				if (u instanceof Ant) {
//					anteaterAddable = true;
//				} else {
//					anteaterAddable = false;
//				}
//			}
			
//			if (antAddable == true && element instanceof Ant) {
//				Updatable updatable = (Updatable) element;
//				toUpdate.add(updatable);
//			}
//			if (anteaterAddable == true && element instanceof Anteater) {
//				Updatable updatable = (Updatable) element;
//				toUpdate.add(updatable);
//			}
			
			Updatable updatable = (Updatable) element;
			toUpdate.add(updatable);
		}
		
		System.out.println(element.getClass().getSimpleName() + " successfully added at " + field.getPoint().x + "," + field.getPoint().y + ".");
		
	}

	/**
	 * Hozzï¿½adja a {@code Field} mezï¿½t a mezï¿½ket tï¿½rolï¿½ listï¿½hoz.
	 * 
	 * @param f pï¿½lyï¿½n mezï¿½listï¿½hoz hozzï¿½adandï¿½ mezï¿½
	 */
	public void addField(Field f) {
		fields.add(f);
	}

	/**
	 * A {@code Points} ï¿½ltal meghatï¿½rozott {@code Field}-et adja meg.
	 * 
	 * @param points koordinï¿½tï¿½k, amely meghatï¿½rozza a {@code Field}-et
	 * @return {@code Point} ï¿½ltal meghatï¿½rozott {@code Field}
	 */
	public Field getField(Point points) {
		for (Field field : fields) {
			if (field.getPoint().equals(points)) {
				return field;
			}
		}
		return null;
	}

	/**
	 * Inicializï¿½lja a jï¿½tï¿½kos mezï¿½t:
	 * lï¿½trehozza a pï¿½lyï¿½n talï¿½lhatï¿½ elemeket ï¿½s beï¿½llï¿½tja ï¿½ket.
	 */
	public void Initialize() {
		int n=size.x;
		int m=size.y;
		fields = new ArrayList<Field>(n*m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Field tempField = new Field(this);
				tempField.setPoint(i, j);
				
				///View létrehozása a Field-nek, és hozzácsatolása
				FieldView tempFieldView = new FieldView();
				tempField.Attach(tempFieldView);
				tempFieldView.m_Field = tempField;
				///
				
				fields.add(tempField);
			}
		}
				
		for (Field field : fields) {
			Point pos = field.getPoint();
			
			if(pos.y % 2 == 0) {
				field.addNeighbour(getField(new Point(pos.x-1, pos.y-1)));
				field.addNeighbour(getField(new Point(pos.x, pos.y-1)));
				field.addNeighbour(getField(new Point(pos.x-1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x+1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x-1, pos.y+1)));
				field.addNeighbour(getField(new Point(pos.x, pos.y+1)));
			} else {
				field.addNeighbour(getField(new Point(pos.x, pos.y-1)));
				field.addNeighbour(getField(new Point(pos.x+1, pos.y-1)));
				field.addNeighbour(getField(new Point(pos.x-1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x+1, pos.y)));
				field.addNeighbour(getField(new Point(pos.x, pos.y+1)));
				field.addNeighbour(getField(new Point(pos.x+1, pos.y+1)));
			}
		}
		
//		int numOfFields = fields.size();
//		for (int i = 0; i < numOfFields; i++) {
//			Field tempField = fields.get(i);
//			int x=tempField.getPoint().x;
//			int y=tempField.getPoint().y;
//			
//			
//			
//			// Nem tï¿½kï¿½letes, tï¿½bb szomszï¿½dot is hozzï¿½ad !!!
//			for (int j = 0; j < numOfFields ; j++) {
//				Field tTempField = fields.get(j);
//				
//				if (tTempField.getPoint().x==x){
//					if(tTempField.getPoint().y==y) continue;//ekkor onmaga
//					if(tTempField.getPoint().y==y+1) tempField.addNeighbour(tTempField);//ekkor egyik szomszed
//					if(tTempField.getPoint().y==y-1) tempField.addNeighbour(tTempField);//ekkor masik szomszed
//					
//				}
//				if (tTempField.getPoint().y==y){
//					if(tTempField.getPoint().x==x) continue;//ekkor onmaga
//					if(tTempField.getPoint().x==x+1) tempField.addNeighbour(tTempField);//ekkor harmadik szomszed
//					if(tTempField.getPoint().x==x-1) tempField.addNeighbour(tTempField);//ekkor negyedik szomszed
//					
//				}
//				//meg hianyzik a +1,+1 es a -1,-1 modositoju szomszed
//				if ((tTempField.getPoint().y==y-1)&&(tTempField.getPoint().x==x-1))tempField.addNeighbour(tTempField);//ekkor otodik szomszed
//				if ((tTempField.getPoint().y==y+1)&&(tTempField.getPoint().x==x+1))tempField.addNeighbour(tTempField);//ekkor hatodik szomszed
//			}
		/*
				if ((((tTempField.getPoint().x - tempField.getPoint().x) == 0) &&
						(Math.abs((tTempField.getPoint().y - tempField.getPoint().y))) == 1) ||
						(((Math.abs((tTempField.getPoint().x - tempField.getPoint().x))) == 1) &&
						((tTempField.getPoint().y - tempField.getPoint().y) == 0)) ||
						(((Math.abs((tTempField.getPoint().x - tempField.getPoint().x))) == 1) &&
						(Math.abs((tTempField.getPoint().y - tempField.getPoint().y)) == 1)) 
//						 && (((tTempField.getPoint().x - tempField.getPoint().x) != -1) &&
//						((tTempField.getPoint().y - tempField.getPoint().y) != 1)) &&
//						(((tTempField.getPoint().x - tempField.getPoint().x) != 1) &&
//						((tTempField.getPoint().y - tempField.getPoint().y) != -1))
						) {
					tempField.addNeighbour(tTempField);
				}
			}*/
			
//			System.out.println(fields.get(i).getNeighbours().toString());			
//		}
	}

	/**
	 * Magï¿½t a pï¿½lyï¿½t adja meg.
	 * 
	 * @return {@code GameField} osztï¿½lypï¿½ldï¿½ny
	 */
	public static GameField instanceOf() {
		if (instance == null)
			instance = new GameField();
		return instance;
	}

	/**
	 * Beregisztrï¿½lja a pï¿½lyï¿½ra a {@code Updatable} frissï¿½tendï¿½ objektumot.
	 * 
	 * @param element frissï¿½tendï¿½ objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		this.toUpdate.add(element);
	}
	
	/**
	 * Eltávolítja az elementet a frissítendõ objektumok közül.
	 * 
	 * @param element
	 */
	public void unregisterUpdatable(Updatable element){
		Tracer.Instance().Trace(TracerDirection.Enter);
//		if (this.toUpdate.contains(element)) {
			this.toUpdate.remove(element);
			
			int fSize = this.fields.size();
			for (int i = 0; i < fSize; i++) {
				Field field = this.fields.get(i);
				ArrayList<Element> elements = field.getElements();
				int eSize = elements.size();
				for (int j = 0; j < eSize; j++) {
					if (elements.get(j).equals(element)) {
						elements.remove(element);
					}
				}
			}
//		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Frissï¿½ti a pï¿½lya frissï¿½tendï¿½ objektumait.
	 */
	public void updateUpdatables() {
		int tUS = this.toUpdate.size();
		for (int i = 0; i < tUS; i++) {
			Updatable updatable = this.toUpdate.get(i);
			updatable.update();			
		}
//		for (Updatable updatables : this.toUpdate) {
//			updatables.update();
//		}
	}

}