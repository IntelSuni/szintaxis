package System;

import java.awt.Point;

import hu.szintaxis.Tracer;
import hu.szintaxis.Tracer.Direction;

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
		Tracer.Instance().Trace(Direction.Leave);
	}

	/**
	 * Fegyverp�ld�ny el�r�s�re.
	 * 
	 * @return fegyver l�tez� p�ld�nya
	 */
	public static Weapon InstanceOf() {
		Tracer.Instance().Trace(Direction.Enter);
		
		if(Instance==null)Instance=new Weapon();
		Tracer.Instance().Trace(Direction.Leave);
		return  Instance;
	}

	/**
	 * Az el�rhet� fegyver haszn�lata a {@code Field} mez�n.
	 * 
	 * @param field fegyverhaszn�lat ezen a mez�n
	 */
	public void Use(Field field) {
		Tracer.Instance().Trace(Direction.Enter,field);
		
		GameField.instanceOf().getField(new Point());
		Spray current = new Spray();
		current.use(field);
		
		Tracer.Instance().Trace(Direction.Leave);
	}

}