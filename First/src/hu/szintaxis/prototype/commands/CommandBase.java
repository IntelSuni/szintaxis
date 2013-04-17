package hu.szintaxis.prototype.commands;

/**
 * Strategy pattern alapján ez a szülõ strategy, azaz a fõ utasítás, amin
 * keresztül kezelve lesz a többi.
 * 
 * @author Dóczi Róbert
 * 
 */
public abstract class CommandBase {

	/**
	 * Végrehajtja az aktuális utasítást.
	 * 
	 * @param args
	 *            Az utasítás paraméterei.
	 * @throws Exception
	 *             Ha bármi hiba van Exceptiont dob.
	 */
	public abstract void execute(String... args) throws Exception;
}
