package System;

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

	/**
	 * L�trehozza a fegyver objektumot.
	 */
	private  Weapon() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		extSpray = new Exterminator();
		neutSpray = new Neutralizer();
		Tracer.Instance().Trace(TracerDirection.Leave);
	}

	/**
	 * Fegyverp�ld�ny el�r�s�re.
	 * 
	 * @return fegyver l�tez� p�ld�nya
	 */
	public static Weapon InstanceOf() {
		Tracer.Instance().Trace(TracerDirection.Enter);
		
		if(Instance==null)Instance=new Weapon();
		Tracer.Instance().Trace(TracerDirection.Leave);
		return  Instance;
	}

	/**
	 * Az el�rhet� fegyver haszn�lata a {@code Field} mez�n.
	 * 
	 * @param field fegyverhaszn�lat ezen a mez�n
	 */
	public void Use(Field field) {
		Tracer.Instance().Trace(TracerDirection.Enter,field);
		
		if (m_Spray == null) {
			SelectExterminator();
		}
		
		m_Spray.use(field);
		
		Tracer.Instance().Trace(TracerDirection.Leave);
	}
	
	/**
	 * Kiv�lasztja a hangya�l� sprayt.
	 */
	public void SelectExterminator() {
		m_Spray = extSpray;
//		System.out.print(m_Spray.getClass().getSimpleName());
	}

	/**
	 * Kiv�lasztja a szagtalan�t� sprayt.
	 */
	public void SelectNeutralizer() {
		m_Spray = neutSpray;
//		System.out.print(m_Spray.getClass().getSimpleName());
	}
}