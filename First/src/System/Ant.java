package System;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Hangyï¿½t megvalï¿½sï¿½tï¿½ osztï¿½ly.
 */
public class Ant implements Updatable, Visitor, Element {
	/**
	 * A hangya haladï¿½si irï¿½nya.
	 */
	private Direction direction;
	/**
	 * A hangya neve.
	 */
	private String name;
	/**
	 * A hangya jelenleg melyik pï¿½lyï¿½n levï¿½ mezï¿½ben van
	 * (tartï¿½zkodï¿½si helye).
	 */
	private Field field;
	/**
	 * A hangya ï¿½lete.
	 */
	private int HealtPoint;
	/**
	 * A hangya mï¿½rgezettsï¿½gi szinje.
	 */
	private int poisonLevel;
	/**
	 * A hangya eddig mely mezï¿½kben jï¿½rt, mielï¿½tt a jelenlegi mezï¿½be
	 * lï¿½pett volna.
	 */
	private ArrayList<Field> visitedFields;
	
	/**
	 * A felcsatolható nézeteket tárolja.
	 */
	private Vector<View> views;

	public Ant() {
		this.HealtPoint = 20;
		this.direction = Direction.east;
		this.views = new Vector<View>();
	}

	/**
	 * Lï¿½trehoz egy hangyï¿½t a {@code field} mezï¿½n.
	 * 
	 * @param field
	 *            a mezï¿½, amelyen a hangya lï¿½trejï¿½n
	 */
	public Ant(Field field) {
		this.field = field;
		this.HealtPoint = 20;
		this.direction = Direction.east;
		this.views = new Vector<View>();
		this.NotifyView();
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
	 * Visitor tervezï¿½si mintï¿½nak megfelelï¿½ accept, a paramï¿½terben
	 * megkapott {@code Visitor}-on meghï¿½vja annak visit metï¿½dusï¿½t
	 * ï¿½nmagï¿½val paramï¿½terezve.
	 * 
	 * @param visiting
	 *            visit metï¿½dusï¿½nak meghï¿½vï¿½sï¿½ra
	 */
	public boolean accept(Visitor visiting) {
		boolean result = visiting.visit(this);
		
		return result;
	}

	/**
	 * {@code level} ï¿½rtï¿½kkel nï¿½veli a hangya mï¿½rgezettsï¿½gi
	 * szintjï¿½t.
	 * 
	 * @param level
	 *            ennyivel nï¿½veli a mï¿½rgezettsï¿½gi szintet
	 */
	public void addPoisonLevel(int level) {
		Tracer.Instance().Trace(TracerDirection.Enter, level);
		this.poisonLevel += level;
//		System.out.println("\tAnt get poisoned.");
		Tracer.Instance().Trace(TracerDirection.Leave, this.poisonLevel);
	}

	/**
	 * 
	 * @param f
	 */
	public void blocked_direction(Field f) {
		this.visitedFields.add(f);
		
	}

	/**
	 * Eldï¿½nti ï¿½s {@code Field}-ben visszaadja, hogy a
	 * {@code ArrayList<Field>} kï¿½zï¿½l a hangya hova lï¿½pjen.
	 * 
	 * @param a
	 *            a mezï¿½k listï¿½ja, amelyek kï¿½zï¿½l kivï¿½lasztja a
	 *            kï¿½vetkezï¿½ mezï¿½t
	 * @return Field a kï¿½vetkezï¿½ mezï¿½, amelyre a hangya lï¿½p
	 */
	public Field decideDirection(ArrayList<Field> a) {
		Tracer.Instance().Trace(TracerDirection.Enter, a);

		ArrayList<Smell> smells = new ArrayList<Smell>();
		Field chosenField = null;
		int intensity = 0, smellIntensity = 0;
		int x = this.field.getPoint().x, y = this.field.getPoint().y;

		// A mezï¿½ szomszï¿½djain levï¿½ hangya- ï¿½s ï¿½telszagokat ï¿½sszegzi
		// ï¿½s azt vï¿½lasztja, amelyik ezek kï¿½zï¿½l a legnagyobb
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
	 * Csï¿½kkenti a hangya ï¿½letpontjï¿½t.
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
	 * A hangya meghal, eltï¿½volï¿½tja sajï¿½t magï¿½t a mezï¿½jï¿½bï¿½l.
	 */
	public void kill() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		this.field.removeElement(this);
		GameField.instanceOf().unregisterUpdatable(this);
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Grafikus vï¿½ltozathoz kirajzolï¿½sï¿½hoz.
	 */
	public void onDraw() {
		
		
	}

	/**
	 * Beï¿½llï¿½tja a {@code Field} paramï¿½tert a sajï¿½t mezï¿½jï¿½re.
	 * 
	 * @param field
	 *            a mezï¿½, amelyre beï¿½llï¿½tja a sajï¿½t mezï¿½jï¿½t
	 */
	public void setField(Field field) {
		this.field = field;
		this.NotifyView();
	}
	
	/**
	 * Visszaadja melyik mezõn van a hangya.
	 * @return A mezõ amelyen a hangya van.
	 */
	public Field getField(){
		return this.field;
	}

	/**
	 * Megkï¿½ri az aktuï¿½lis mezï¿½t mondja meg ki a szomszï¿½dja. Az
	 * eredmï¿½nyen meghï¿½vja a DecideDirection fï¿½ggvï¿½nyt, majd tï¿½rli a
	 * hangya magï¿½t a aktuï¿½lis mezï¿½bï¿½l ï¿½s hozzï¿½adja magï¿½t a
	 * mï¿½sik mezï¿½re.
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
		
		// mï¿½regszint alapjï¿½n az ï¿½letpontok frissï¿½tï¿½se
		ArrayList<Smell> smells = this.field.getSmells();
		for (Smell s : smells) {
			s.activate(this);
		}
		
		this.decreaseHealtPoint();
		Tracer.Instance().Trace(TracerDirection.Leave);
		
	}

	/**
	 * {@code Antlion} lï¿½togatï¿½sa esetï¿½n a hangya meghal.
	 * 
	 * @param antlion
	 *            visitï¿½lï¿½ objektum
	 */
	public boolean visit(Antlion antlion) {
		System.out.println("\tAnt killed by Antlion.");
		System.out.println("\tAntlion ate an Ant.");
		this.kill();
		return true;
	}

	/**
	 * {@code Ant} lï¿½togatï¿½sa.
	 * 
	 * @param ant
	 *            visitï¿½lï¿½ objektum
	 * @return
	 */
	public boolean visit(Ant ant) {
		return false;
	}

	/**
	 * {@code Block} lï¿½togatï¿½sa.
	 * 	 * @param akadaly
	 *            visitï¿½lï¿½ objektum
	 * @return
	 */
	public boolean visit(Block akadaly) {
		return false;
	}

	/**
	 * {@code FoodStore} lï¿½togatï¿½sa.
	 * 
	 * @param foodstore
	 *            a hangya a meglï¿½togatott {@code FoodStore}-ban eszik majd,
	 *            miutï¿½n evett meghal
	 */
	public boolean visit(FoodStore foodstore) {
		foodstore.eat();
		System.out.println("\tAnt ate food and died.");
		this.kill();
		return true;
	}

	/**
	 * {@code Anteater} lï¿½togatï¿½sa esetï¿½n a hangya meghal.
	 * 
	 * @param anteater
	 *            visitï¿½lï¿½ objektum
	 */
	public boolean visit(Anteater anteater) {
		anteater.eat(this);
		return true;
	}

	/**
	 * {@code Stone} lï¿½togatï¿½sa.
	 * 
	 * @param stone
	 *            visitï¿½lï¿½ objektum
	 */
	@Override
	public boolean visit(Stone stone) {
		return false;
	}

	@Override
	public boolean visit(AntHill antHill) {
		// TODO Auto-generated method stub
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