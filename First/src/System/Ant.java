package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Hangyát megvalósító osztály.
 */
public class Ant implements Updatable, Visitor, Element {
	/**
	 * A hangya haladási iránya.
	 */
	private Direction direction;
	/**
	 * A hangya neve.
	 */
	private String name;
	/**
	 * A hangya jelenleg melyik pályán levõ mezõben van
	 * (tartózkodási helye).
	 */
	private Field field;
	/**
	 * A hangya élete.
	 */
	private int HealtPoint;
	/**
	 * A hangya mérgezettségi szinje.
	 */
	private int poisonLevel;
	/**
	 * A hangya eddig mely mezõkben járt, mielõtt a jelenlegi mezõbe
	 * lépett volna.
	 */
	private ArrayList<Field> visitedFields;
	
	/**
	 * A felcsatolható nézeteket tárolja.
	 */
	private Vector<View> views;

	/**
	 * Létrehoz egy hangyát.
	 * System.Ant#setField(Field) használata javasolt.
	 */
	public Ant() {
		this.HealtPoint = 20;
		this.direction = Direction.east;
		this.views = new Vector<View>();
	}

	/**
	 * Létrehoz egy hangyát a {@code field} mezõn.
	 * 
	 * @param field
	 *            a mezõ, amelyen a hangya létrejön
	 */
	public Ant(Field field) {
		this.field = field;
		this.HealtPoint = 20;
		this.direction = Direction.east;
		this.views = new Vector<View>();
//		System.out.println("Ant successfully added at " + this.field.getPoint().x + "," + this.field.getPoint().y + ".");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ant [name=" + name + "]";
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
	 * Visitor tervezési mintáûnak megfelelõ accept, a paraméterben
	 * megkapott {@code Visitor}-on meghívja annak visit metódusát
	 * önmagával paraméterezve.
	 * 
	 * @param visiting
	 *            visit metódusának meghívására
	 */
	public boolean accept(Visitor visiting) {
		boolean result = visiting.visit(this);
		
		return result;
	}

	/**
	 * {@code level} értékkel növeli a hangya mérgezettségi
	 * szintjét.
	 * 
	 * @param level
	 *            ennyivel növeli a mérgezettségi szintet
	 */
	public void addPoisonLevel(int level) {
		Tracer.Instance().Trace(TracerDirection.Enter, level);
		this.poisonLevel += level;
		//System.out.println("\tAnt get poisoned.");
		Tracer.Instance().Trace(TracerDirection.Leave, this.poisonLevel);
	}

	/*
	 * (non-Javadoc)
	 * @param f
	 */
	public void blocked_direction(Field f) {
		this.visitedFields.add(f);
		
	}

	/**
	 * Eldönti és {@code Field}-ben visszaadja, hogy a
	 * {@code ArrayList<Field>} közül a hangya hova lépjen.
	 * 
	 * @param a
	 *            a mezõk listája, amelyek közül kiválasztja a
	 *            következõ mezõt
	 * @return Field a következõ mezõ, amelyre a hangya lép
	 */
	public Field decideDirection(ArrayList<Field> a) {
		Tracer.Instance().Trace(TracerDirection.Enter, a);

		ArrayList<Smell> smells = new ArrayList<Smell>();
		Field chosenField = null;
		int intensity = 0, smellIntensity = 0;
		int x = this.field.getPoint().x, y = this.field.getPoint().y;

		// A mezõ szomszï¿½djain levï¿½ hangya- és ï¿½telszagokat ésszegzi
		// és azt vï¿½lasztja, amelyik ezek kï¿½zï¿½l a legnagyobb
		// (A legutolsï¿½t vï¿½lasztja.)
		for (Field field : a) {
			if (field != null) {
				smells.addAll(field.getSmells());

				for (Smell smell : smells) {
					String smellClassName = smell.getClass().getName();
					if (smellClassName.contains("AntSmell")
							|| smellClassName.contains("FoodSmell")) {
						smellIntensity += smell.getIntensity();
					}
				}

				if (smellIntensity >= intensity) {
					intensity = smellIntensity;
					chosenField = field;
				}
				smells.clear();
				smellIntensity = 0;
			}
		}

		Tracer.Instance().Trace(TracerDirection.Leave, field);

		return chosenField;
	}

	/**
	 * Csökkenti a hangya életpontját.
	 */
	public void decreaseHealtPoint() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		// Mï¿½rgezettsï¿½g esetï¿½n csï¿½kken a HP.
		if (this.poisonLevel > 0) {
			this.HealtPoint -= this.poisonLevel;
		}
		// Ha nincs HP, a hangya meghal.
		if (this.HealtPoint <= 0) {
			System.out.println("\tAnt's HealthPoint is 0 and died.");
			this.kill();
			// System.gc();
		}
		Tracer.Instance().Trace(TracerDirection.Leave, this.HealtPoint);
		
	}

	/**
	 * A hangya meghal, eltávolítja saját magát a mezõjébõl.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.field.removeElement(this);
		GameField.instanceOf().unregisterUpdatable(this);
		this.DetachAllViews();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * @deprecated
	 * Grafikus változathoz kirajzolásához.
	 */
	public void onDraw() {
		
	}

	/**
	 * Beállítja a {@code Field} paramétert a saját mezõjére.
	 * 
	 * @param field
	 *            a mezõ, amelyre beállítja a saját mezõjét
	 */
	public void setField(Field field) {
		this.field = field;
	}
	
	/**
	 * Visszaadja melyik mezõn van a hangya.
	 * @return a mezõ amelyen a hangya van.
	 */
	public Field getField(){
		return this.field;
	}

	/**
	 * Megkéri az aktuális mezõt mondja meg ki a szomszédja. Az
	 * eredményen meghívja a DecideDirection függvényt, majd törli a
	 * hangya magát a aktuális mezõrõl és hozzáadja magát a
	 * másik mezõre.
	 */
	public void update() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		// a kovetkezo mezo eldontese
		Field next_field = null;
		ArrayList<Field> neighbours = field.getNeighbours();
		do {		
		if (next_field != null) {
			neighbours.remove(next_field);
		}
		next_field = decideDirection(neighbours);
		} while (direction.negate() == Direction.getDirection(neighbours.indexOf(next_field)));
		
		direction = Direction.getDirection(neighbours.indexOf(next_field));
		
		System.out.println("\tAnt moved from " + this.field.getPoint().x + "," + this.field.getPoint().y + ".");
		
		// atmozgas a kovetkezo mezore
		field.removeElement(this);
		next_field.addElement(this);
		this.setField(next_field);

		System.out.println("\tAnt moved to " + this.field.getPoint().x + "," + this.field.getPoint().y + ".");
		
		// visitor minta alkalmazasa
		ArrayList<Element> aktualis_mezoe = this.field.getElements();
		for (Element s : aktualis_mezoe) {
			s.toString();
			s.accept(this);
		}
		
		// mï¿½regszint alapjï¿½n az ï¿½letpontok frissï¿½tése
		ArrayList<Smell> smells = this.field.getSmells();
		for (int i = 0; i < smells.size(); i++) {
			if (i >= smells.size()) {
				break;
			}
			smells.get(i).activate(this);
		}
				
		this.decreaseHealtPoint();
		Tracer.Instance().Trace(TracerDirection.Leave);
		
	}

	/**
	 * {@code Antlion} látogatása esetén a hangya meghal.
	 * 
	 * @param antlion
	 *            visitáló objektum
	 */
	public boolean visit(Antlion antlion) {
		System.out.println("\tAnt killed by Antlion.");
		System.out.println("\tAntlion ate an Ant.");
		this.kill();
		return true;
	}

	/**
	 * {@code Ant} látogatésa.
	 * 
	 * @param ant
	 *            visitáló objektum
	 * @return
	 */
	public boolean visit(Ant ant) {
		return false;
	}

	/**
	 * {@code Block} látogatása.
	 * 	 * @param akadaly
	 *            visitáló objektum
	 * @return
	 */
	public boolean visit(Block akadaly) {
		return false;
	}

	/**
	 * {@code FoodStore} látogatása.
	 * 
	 * @param foodstore
	 *            a hangya a meglátogatott {@code FoodStore}-ban eszik majd,
	 *            miután evett meghal
	 */
	public boolean visit(FoodStore foodstore) {
		foodstore.eat();
		System.out.println("\tAnt ate food and died.");
		this.kill();
		return true;
	}

	/**
	 * {@code Anteater} látogatása esetén a hangya meghal.
	 * 
	 * @param anteater
	 *            visitáló objektum
	 */
	public boolean visit(Anteater anteater) {
		anteater.eat(this);
		return true;
	}

	/**
	 * {@code Stone} látogatása.
	 * 
	 * @param stone
	 *            visitáló objektum
	 */
	@Override
	public boolean visit(Stone stone) {
		return false;
	}

	/**
	 * <code>AntHill</code> látogatása.
	 * 
	 * @param antHill visitáló objektum
	 */
	@Override
	public boolean visit(AntHill antHill) {
		// TODO Auto-generated method stub
		return true;
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
		}
		else{
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