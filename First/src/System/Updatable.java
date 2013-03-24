package System;

/**
 * Az interf�sz friss�t�si szolg�ltat�st ny�jt a megval�s�tand� oszt�lyoknak. 
 * Ezt az interf�szt implement�l� oszt�lyokat a {@code GameField} beregisztr�lja friss�tend� objektumonk�nt.
 */
public interface Updatable {

	/**
	 * A {@code GameField} h�vja meg ezt az interf�szt megval�s�t� oszt�lyok met�dus�t, ha friss�teni kell �s a f�ggv�ny az objektumra specifikus friss�t�si folyamatot elv�gzi.
	 */
	public void update();

}