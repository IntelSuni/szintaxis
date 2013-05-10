package System;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * HangyaBolyt megval�s�t� oszt�ly
 */
public class AntHill implements Updatable, Element {

	/**
	 * A HangyaBoly ezen a mez�n van.
	 */
	private Field field;
		
	private Vector<View> views;

	public AntHill() {
		super();
		this.views = new Vector<View>();
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AntHill []";
	}

	/**
	 * L�trehoz egy hangyabolyt a {@code field} mez�n.
	 * 
	 * @param field a mez�, amelyen a hangyaboly l�trej�n
	 */
	public AntHill(Field field) {
//		Tracer.Instance().Trace(TracerDirection.Enter, field);
		this.field = field;
		this.views = new Vector<View>();
//		System.out.println("Anteater successfully added at " + this.field.getPoint().x + "," + this.field.getPoint().y + ".");
//		Tracer.Instance().Trace(TracerDirection.Leave);
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
	 * @param visitor visit met�dus�nak megh�v�s�ra
	 */
	public boolean accept(Visitor visitor) {
		Tracer.Instance().Trace(TracerDirection.Enter, visitor);
		boolean result=visitor.visit(this);
		Tracer.Instance().Trace(TracerDirection.Leave);
		return result;
	}
	
	/**
	 * Grafikus v�ltozathoz kirajzol�s�hoz.
	 */
	public void onDraw() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * L�trehoz egy �j hangy�t �s hangszagot, elhelyezi egy hangyabolyhoz 
	 * k�zeli mez�n �s a j�t�kos p�ly�ra is beregisztr�lja.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		// 1-6 k�z�tti random sz�mot gener�l
//		int randomFieldNum = new Random().nextInt(6 - 1 + 1) + 1;
//		
//		// A mez� szomsz�djai alapj�n kiv�lasztja az �j hangya mez�j�t
//		ArrayList<Field> neighbours = this.field.getNeighbours();
//		if (neighbours.size() >= randomFieldNum) {
//			Field randomField = neighbours.get(randomFieldNum - 1);
//			
//			Ant ant = new Ant(randomField);
//			randomField.addElement(ant);
//			
//			AntSmell antSmell = new AntSmell();
//			randomField.addSmell(antSmell);
//			
//			this.field.gameField.registerNewUpdatable(ant);
//		}
		
		// Ha nem siker�l szomsz�dra elhelyezni, akkor a saj�t mez�j�re rakja
		Ant ant = new Ant(field);
		AntSmell antSmell = new AntSmell();

		field.addElement(ant);
		field.addSmell(antSmell);

		this.field.gameField.registerNewUpdatable(ant);

		Tracer.Instance().Trace(TracerDirection.Leave);
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
	public void NotifyView(Graphics2D g) {
		for (View view : this.views) {
			view.draw(g);
		}
	}
}
