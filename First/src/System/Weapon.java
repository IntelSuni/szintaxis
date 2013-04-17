package System;

import java.awt.Point;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.Direction;

/**
 * Fegyvert megvalósító osztály, amelyen keresztül elérhetõk a fegyvertípusok.
 */
public class Weapon {
	/**
	 * Fegyverpéldány (Singleton)	
	 */
	private static Weapon Instance;
	/**
	 * Használható spray.
	 */
	public Spray m_Spray;
	/**
	 * Az exterminátor spray példánya.
	 */
	public Exterminator extSpray;
	/**
	 * A szagtalanító spray példánya.
	 */
	public Neutralizer neutSpray;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws Throwable {
		super.finalize();
	}

	private  Weapon() {
		Tracer.Instance().Trace(Direction.Enter);
		extSpray = new Exterminator();
		neutSpray = new Neutralizer();
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Fegyverpéldány elérésére.
	 * 
	 * @return fegyver létezõ példánya
	 */
	public static Weapon InstanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		
		if(Instance==null)Instance=new Weapon();
		Tracer.Instance().Trace(Direction.Leave);
		return  Instance;
	}

	/**
	 * Az elérhetõ fegyver használata a {@code Field} mezõn.
	 * 
	 * @param field fegyverhasználat ezen a mezõn
	 */
	public void Use(Field field) {
		Tracer.Instance().Trace(Direction.Enter,field);
		
		GameField.instanceOf().getField(new Point());
		Spray current = new Spray();
		current.use(field);
		
		Tracer.Instance().Trace(Direction.Leave);
	}
	
	/**
	 * Kiválasztja a hangyaölõ sprayt.
	 */
	public void SelectExterminator() {
		m_Spray = extSpray;
	}

	/**
	 * Kiválasztja a szagtalanító sprayt.
	 */
	public void SelectNeutralizer() {
		m_Spray = neutSpray;
	}
}