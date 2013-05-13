package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Ételraktárat megvalósító osztály.
 */
public class FoodStore implements Element {
	/**
	 * Az ételraktár ezen a mezõn van.
	 */
	private Field field; // a mezo amin rajta van kell ahoz hogy amikor kiurul
							// meg lehessen szuntetni.
	/**
	 * Az ételraktárban levõ ételmennyiség.
	 */
	private int food;
	/**
	 * Az ételraktárra felcsatolt megjelenítõ nézetek.
	 */
	private Vector<View> views;

	/**
	 * Létrehoz egy ételraktárat.
	 */
	public FoodStore() {
		// Tracer.Instance().Trace(TracerDirection.Enter);
		this.food = 30;
		this.views = new Vector<View>();
		// Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Létrehoz egy ételraktárat a {@code field} mezõn. A mezõn és
	 * annak 4 sugarú környezetében csökkenïõ erõsségû
	 * ételszagot hoz létre.
	 * 
	 * @param field
	 *            a mezõ, amelyen az ételraktár létrejön
	 */
	public FoodStore(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.food = 30;

		this.views = new Vector<View>();

		// Az ételraktár mezï¿½jï¿½re 5-erï¿½sï¿½ggï¿½ ï¿½telszagot tesz.
		this.field.addSmell(new FoodSmell(5));

		ArrayList<Field> neighbours = this.field.getNeighbours();
		// A mezï¿½ szomszï¿½djaira 4-erï¿½sï¿½ggï¿½ ï¿½teszagot tesz.
		for (Field fields : neighbours) {
			if (fields == null) {
				break;
			}
			fields.addSmell(new FoodSmell(4));

			// Sz-Sz-jaira 3-as erï¿½ssï¿½g, ha mï¿½g nincs rajtuk ï¿½telszag.
			for (Field field2 : fields.getNeighbours()) {
				if (field2 == null) {
					break;
				}
				if (field2.getSmells().contains(FoodSmell.class) == false) {
					field2.addSmell(new FoodSmell(3));
				}

				// Sz-Sz-Sz-jaira 2-es erï¿½ssï¿½g, ha mï¿½g nincs rajtuk
				// ï¿½telszag.
				for (Field field3 : field2.getNeighbours()) {
					if (field3 == null) {
						break;
					}
					if (field3.getSmells().contains(FoodSmell.class) == false) {
						field3.addSmell(new FoodSmell(2));
					}

					// Sz-Sz-Sz-Sz-jaira 1-as erï¿½ssï¿½g, ha mï¿½g nincs rajtuk
					// ï¿½telszag.
					for (Field field4 : field3.getNeighbours()) {
						if (field4 == null) {
							break;
						}
						if (field4.getSmells().contains(FoodSmell.class) == false) {
							field4.addSmell(new FoodSmell(1));
						}
					}
				}
			}
		}

		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Megadja az ételraktár aktuális mezõjét.
	 * @return az ételraktár ezen a mezõn van
	 */
	public Field getField() {
		return this.field;
	}

	/**
	 * Beállítja az ételraktár mezõjét.
	 * @param field az ételraktár új mezõje.
	 */
	public void setField(Field field) {
		this.field = field;
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

	/*
	 * (non-Javadoc)
	 * @see System.Element#accept(System.Visitor)
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		boolean result = visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}

	/**
	 * A hangya, aki meglátogatta ezt a ételraktárat megeszik belõle
	 * valamennyit.
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
	 * {@code int} típusban megadja az ételraktárban levõ étel
	 * mennyiségét.
	 * 
	 * @return az ételraktárban elérhetõ ételmennyiség
	 */
	public int getFoodLeft() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, food);
		return food;
	}

	/**
	 * A foodstore eltávolítja saját magát a mezõjérõl. A
	 * mezõrõl és a szomszédjairól eltünteti az ételszag
	 * objektumokat.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);

		field.removeElement(this);
		this.DetachAllViews();
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#onDraw()
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#Attach(System.View)
	 */
	@Override
	public void Attach(View view) {
		if (this.views.isEmpty()) {
			this.views = new Vector<View>();
			this.views.add(view);
		} else {
			this.views.add(view);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#Detach(System.View)
	 */
	@Override
	public void Detach(View view) {
		if (this.views.contains(view)) {
			this.views.remove(view);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see System.Element#NotifyView(java.awt.Graphics2D)
	 */
	@Override
	public void NotifyView(Graphics2D g) {
		for (View view : this.views) {
			view.draw(g);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see System.Element#DetachAllViews()
	 */
	@Override
	public void DetachAllViews() {
		this.views.clear();
		this.views = null;
	}
	
}
