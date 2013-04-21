package System;

import java.awt.Point;

import hu.szintaxis.skeleton.Tracer;
import hu.szintaxis.skeleton.Tracer.TracerDirection;

/**
 * Fegyvert megval�s�t� oszt�ly, amelyen kereszt�l el�rhet�k a fegyvert�pusok.
 */
public class Weapon {
	/**
	 * Fegyverp�ld�ny (Singleton)	
	 */
	private static Weapon Instance;
	/**
	 * Haszn�lhat� spray.
	 */
	public Spray m_Spray;
	/**
	 * Az extermin�tor spray p�ld�nya.
	 */
	public Exterminator extSpray;
	/**
	 * A szagtalan�t� spray p�ld�nya.
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
		extSpray = new Exterminator();
		neutSpray = new Neutralizer();
	}

	/**
	 * Fegyverp�ld�ny el�r�s�re.
	 * 
	 * @return fegyver l�tez� p�ld�nya
	 */
	public static Weapon InstanceOf() {
		if(Instance==null)Instance=new Weapon();
		return  Instance;
	}

	/**
	 * Az el�rhet� fegyver haszn�lata a {@code Field} mez�n.
	 * 
	 * @param field fegyverhaszn�lat ezen a mez�n
	 */
	public void Use(Field field) {
		GameField.instanceOf().getField(new Point());
		Spray current = new Spray();
		current.use(field);
		}
	
	/**
	 * Kiv�lasztja a hangya�l� sprayt.
	 */
	public void SelectExterminator() {
		m_Spray = extSpray;
	}

	/**
	 * Kiv�lasztja a szagtalan�t� sprayt.
	 */
	public void SelectNeutralizer() {
		m_Spray = neutSpray;
	}
}