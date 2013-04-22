package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * �telRakt�rat megval�s�t� oszt�ly.
 */
public class FoodStore implements Element {
	/**
	 * Az �telRakt�r ezen a mez�n van.
	 */
	private Field field; // a mezo amin rajta van kell ahoz hogy amikor kiurul
							// meg lehessen szuntetni.
	/**
	 * Az �telRakt�rban lev� �telmennyis�g.
	 */
	private int food;

	public FoodStore() {
//		Tracer.Instance().Trace(TracerDirection.Enter);
		this.food = 30;
//		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * L�trehoz egy �telrakt�rat a {@code field} mez�n.
	 * A mez�n �s annak 4 sugar� k�rnyezet�ben cs�kken� er�ss�g� �telszagot hoz l�tre.
	 * 
	 * @param field a mez�, amelyen az �telrakt�r l�trej�n
	 */
	public FoodStore(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.food = 30;
		
		// Az �telrakt�r mez�j�re 5-er�s�gg� �telszagot tesz.
		this.field.addSmell(new FoodSmell(5));
		
		ArrayList<Field> neighbours = this.field.getNeighbours();
		// A mez� szomsz�djaira 4-er�s�gg� �teszagot tesz.
		for (Field fields : neighbours) {
			fields.addSmell(new FoodSmell(4));
			
			// Sz-Sz-jaira 3-as er�ss�g, ha m�g nincs rajtuk �telszag.
			for (Field field2 : fields.getNeighbours()) {
				if (field2.getSmells().contains(FoodSmell.class) == false) {
					field2.addSmell(new FoodSmell(3));
				}
				
				// Sz-Sz-Sz-jaira 2-es er�ss�g, ha m�g nincs rajtuk �telszag.
				for (Field field3 : field2.getNeighbours()) {
					if (field3.getSmells().contains(FoodSmell.class) == false) {
						field3.addSmell(new FoodSmell(2));
					}
					
					// Sz-Sz-Sz-Sz-jaira 1-as er�ss�g, ha m�g nincs rajtuk �telszag.
					for (Field field4 : field3.getNeighbours()) {
						if (field4.getSmells().contains(FoodSmell.class) == false) {
							field4.addSmell(new FoodSmell(1));
						}
					}
				}
			}
		}
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FoodStore []";
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
	 * @param visitor
	 *            a {@code visitor}-on megh�vja a class a saj�t mag�hoz tartoz� f�ggv�nyt
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		boolean result=visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * A hangya, aki megl�togatta ezt a �telrakt�rat megeszik bel�le valamennyit.
	 */
	public void eat() {
		Tracer.Instance().Trace(TracerDirection.Enter);

		food--; // nem tudom mennyit eszik meg a hangya itt 1et vettem le
		if (food <= 0) {
			this.kill();
		}

		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * {@code int} t�pusban megadja az �telrakt�rban lev� �tel mennyis�g�t.
	 * 
	 * @return az �telrakt�rban el�rhet� �telmennyis�g
	 */
	public int getFoodLeft() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, food);
		return food;
	}

	/**
	 * A foodstore elt�vol�tja saj�t mag�t a mez�j�r�l.
	 * A mez�r�r�l �s a szomsz�djair�l elt�nteti az �telszag objektumokat.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		field.removeElement(this);
		
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}
