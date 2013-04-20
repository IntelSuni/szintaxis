package System;

import java.util.ArrayList;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * ÉtelRaktárat megvalósító osztály.
 */
public class FoodStore implements Element {
	/**
	 * Az ÉtelRaktár ezen a mezõn van.
	 */
	private Field field; // a mezo amin rajta van kell ahoz hogy amikor kiurul
							// meg lehessen szuntetni.
	/**
	 * Az ÉtelRaktárban levõ ételmennyiség.
	 */
	private int food;

	public FoodStore() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.food = 30;
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Létrehoz egy ételraktárat a {@code field} mezõn.
	 * A mezõn és annak 4 sugarú környezetében csökkenõ erõsségû ételszagot hoz létre.
	 * 
	 * @param field a mezõ, amelyen az ételraktár létrejön
	 */
	public FoodStore(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.food = 30;
		
		// Az ételraktár mezõjére 5-erõséggû ételszagot tesz.
		this.field.addSmell(new FoodSmell(5));
		
		ArrayList<Field> neighbours = this.field.getNeighbours();
		// A mezõ szomszédjaira 4-erõséggû éteszagot tesz.
		for (Field fields : neighbours) {
			fields.addSmell(new FoodSmell(4));
			
			// Sz-Sz-jaira 3-as erõsség, ha még nincs rajtuk ételszag.
			for (Field field2 : fields.getNeighbours()) {
				if (field2.getSmells().contains(FoodSmell.class) == false) {
					field2.addSmell(new FoodSmell(3));
				}
				
				// Sz-Sz-Sz-jaira 2-es erõsség, ha még nincs rajtuk ételszag.
				for (Field field3 : field2.getNeighbours()) {
					if (field3.getSmells().contains(FoodSmell.class) == false) {
						field3.addSmell(new FoodSmell(2));
					}
					
					// Sz-Sz-Sz-Sz-jaira 1-as erõsség, ha még nincs rajtuk ételszag.
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
	 * Visitor tervezési mintának megfelelõ accept, a paraméterben megkapott {@code Visitor}-on meghívja annak visit metódusát önmagával paraméterezve.
	 *
	 * @param visitor
	 *            a {@code visitor}-on meghívja a class a saját magához tartozó függvényt
	 */
	public void accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * A hangya, aki meglátogatta ezt a ételraktárat megeszik belõle valamennyit.
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
	 * {@code int} típusban megadja az ételraktárban levõ étel mennyiségét.
	 * 
	 * @return az ételraktárban elérhetõ ételmennyiség
	 */
	public int getFoodLeft() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave, food);
		return food;
	}

	/**
	 * A foodstore eltávolítja saját magát a mezõjérõl.
	 * A mezõrõrõl és a szomszédjairól eltünteti az ételszag objektumokat.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		field.removeElement(this);
		
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

}
