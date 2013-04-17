package hu.szintaxis.prototype.commands;

/**
 * Strategy pattern alapj�n ez a sz�l� strategy, azaz a f� utas�t�s, amin
 * kereszt�l kezelve lesz a t�bbi.
 * 
 * @author D�czi R�bert
 * 
 */
public abstract class CommandBase {

	/**
	 * V�grehajtja az aktu�lis utas�t�st.
	 * 
	 * @param args
	 *            Az utas�t�s param�terei.
	 * @throws Exception
	 *             Ha b�rmi hiba van Exceptiont dob.
	 */
	public abstract void execute(String... args) throws Exception;
}
