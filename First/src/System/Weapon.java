package System;

import java.awt.Point;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

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
		Tracer.Instance().Trace(TracerDirection.Enter);
		extSpray = new Exterminator();
		neutSpray = new Neutralizer();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Fegyverpéldány elérésére.
	 * 
	 * @return fegyver létezõ példánya
	 */
	public static Weapon InstanceOf() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if(Instance==null)Instance=new Weapon();
		Tracer.Instance().Trace(TracerDirection.Leave);
		return  Instance;
	}

	/**
	 * Az elérhetõ fegyver használata a {@code Field} mezõn.
	 * 
	 * @param field fegyverhasználat ezen a mezõn
	 */
	public void Use(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter,field);
		
		GameField.instanceOf().getField(new Point());
		Spray current = new Spray();
		try {
			Spray cureent = this.m_Spray.getClass().newInstance();
			cureent.use(field);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		current.use(field);
		
		System.out.println(" used successfully on " + field.getPoint().x + "," + field.getPoint().y + " and its neighbours.");
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Kiválasztja a hangyaölõ sprayt.
	 */
	public void SelectExterminator() {
		m_Spray = extSpray;
		System.out.print(m_Spray.getClass().getSimpleName());
	}

	/**
	 * Kiválasztja a szagtalanító sprayt.
	 */
	public void SelectNeutralizer() {
		m_Spray = neutSpray;
		System.out.print(m_Spray.getClass().getSimpleName());
	}
}