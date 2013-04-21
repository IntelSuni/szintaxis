package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Size2DSyntax;

/**
 * P�ly�t megval�s�t� oszt�ly.
 */
public class GameField {
	/**
	 * P�ly�n lev� hangy�szok sz�ma.
	 */
	private int anteaterNo;
	/**
	 * P�ly�n lev� hangyabolyok sz�ma.
	 */
	private int antHillNo;
	/**
	 * P�ly�n lev� akad�lyok sz�ma.
	 */
	private int blockNo;
	/**
	 * P�ly�n lev� �telrakt�rak sz�ma.
	 */
	private int foodStoreNo;
	/**
	 * P�ly�t t�rol� statikus objektum (singleton).
	 */
	private static GameField instance;
	/**
	 * P�lya m�retkoordin�t�i.
	 */
	private Point size;
	/**
	 * P�ly�n lev� kavicsok sz�ma.
	 */
	private int stoneNo;
	/**
	 * P�ly�n lev� friss�tend� objektumok.
	 */
	private ArrayList<Updatable> toUpdate;
	/**
	 * Mez�ket t�rol� lista.
	 */
	public List<Field> fields;
	/**
	 * P�ly�n lev� friss�tend� objektumok.
	 */
	public List<Updatable> updatables;
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

	// csak a tesztek miatt public, eredetileg private !
	public GameField() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		fields = new ArrayList<Field>();
		toUpdate = new ArrayList<Updatable>();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	public GameField(Point size) {
		this();
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameField []";
	}

	/**
	 * Hozz�ad egy {@code element}-et egy {@code field}-hez.
	 * @param element Hozz�adant� element.
	 * @param field Field, amihez hozz� szeretn�nk adni.
	 */
	public void addElementToField(Element element, Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, element, field);
		for (Field fields : this.fields) {
			if (fields.equals(field) == true) {
				fields.addElement(element);
			}
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Hozz�adja a {@code Field} mez�t a mez�ket t�rol� list�hoz.
	 * 
	 * @param f p�ly�n mez�list�hoz hozz�adand� mez�
	 */
	public void addField(Field f) {
		Tracer.Instance().Trace(TracerDirection.Enter, f);
		fields.add(f);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A {@code Points} �ltal meghat�rozott {@code Field}-et adja meg.
	 * 
	 * @param points koordin�t�k, amely meghat�rozza a {@code Field}-et
	 * @return {@code Point} �ltal meghat�rozott {@code Field}
	 */
	public Field getField(Point points) {
		Tracer.Instance().Trace(TracerDirection.Enter, points);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return null;
	}

	/**
	 * Inicializ�lja a j�t�kos mez�t:
	 * l�trehozza a p�ly�n tal�lhat� elemeket �s be�ll�tja �ket.
	 */
	public void Initialize() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		int n=3;
		int m=3;
		ArrayList<Field> fields = new ArrayList<Field>(n*m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Field tempField = new Field();
				tempField.setPoint(i, j);
				
				fields.add(tempField);
			}
		}
		
		System.out.println(fields.toString());
		
		int numOfFields = fields.size();
		for (int i = 0; i < numOfFields; i++) {
			Field tempField = fields.get(i);
			int x=tempField.getPoint().x;
			int y=tempField.getPoint().y;
			// Nem t�k�letes, t�bb szomsz�dot is hozz�ad !!!
			for (int j = 0; j < numOfFields ; j++) {
				Field tTempField = fields.get(j);
				
				if (tTempField.getPoint().x==x){
					if(tTempField.getPoint().y==y) continue;//ekkor onmaga
					if(tTempField.getPoint().y==y+1) tempField.addNeighbour(tTempField);//ekkor egyik szomszed
					if(tTempField.getPoint().y==y-1) tempField.addNeighbour(tTempField);//ekkor masik szomszed
					
				}
				if (tTempField.getPoint().y==y){
					if(tTempField.getPoint().x==x) continue;//ekkor onmaga
					if(tTempField.getPoint().x==x+1) tempField.addNeighbour(tTempField);//ekkor harmadik szomszed
					if(tTempField.getPoint().x==x-1) tempField.addNeighbour(tTempField);//ekkor negyedik szomszed
					
				}
				//meg hianyzik a +1,+1 es a -1,-1 modositoju szomszed
				if ((tTempField.getPoint().y==y-1)&&(tTempField.getPoint().x==x-1))tempField.addNeighbour(tTempField);//ekkor otodik szomszed
				if ((tTempField.getPoint().y==y+1)&&(tTempField.getPoint().x==x+1))tempField.addNeighbour(tTempField);//ekkor hatodik szomszed
			}/*
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
			
			System.out.println(fields.get(i).getNeighbours().toString());			
		}
		
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Mag�t a p�ly�t adja meg.
	 * 
	 * @return {@code GameField} oszt�lyp�ld�ny
	 */
	public static GameField instanceOf() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		if (instance == null)
			instance = new GameField();

		Tracer.Instance().Trace(TracerDirection.Leave, instance);
		return instance;
	}

	/**
	 * Beregisztr�lja a p�ly�ra a {@code Updatable} friss�tend� objektumot.
	 * 
	 * @param element friss�tend� objektum
	 */
	public void registerNewUpdatable(Updatable element) {
		Tracer.Instance().Trace(TracerDirection.Enter, element);
		this.toUpdate.add(element);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Friss�ti a p�lya friss�tend� objektumait.
	 */
	public void updateUpdatables() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		for (Updatable updatables : this.toUpdate) {
			updatables.update();
		}
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}