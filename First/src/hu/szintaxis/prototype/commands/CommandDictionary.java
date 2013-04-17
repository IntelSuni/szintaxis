package hu.szintaxis.prototype.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Commandok t�rol�s�ra �s lek�rdez�s�re haszn�lt singleton oszt�ly.
 * 
 * @author D�czi R�bert
 * 
 */
public class CommandDictionary {

	/**
	 * Singleton p�ld�ny.
	 */
	private static CommandDictionary instance;

	/**
	 * Utas�t�sokat t�rol� map.
	 */
	private Map<String, CommandBase> commands;

	/**
	 * Konstruktor, mely l�trehozza a mapet, �s felt�lti az alap utas�t�sokkal.
	 */
	private CommandDictionary() {
		commands = new HashMap();
		// Itt hozz� k�ne adni az �sszes commandot!
		commands.put("draw", new DrawCommand());
		commands.put("help", new HelpCommand());
		commands.put("addElement", new AddElementCommand());
		commands.put("createGameField", new CreateGameFieldCommand());
		commands.put("exit", new ExitCommand());
		commands.put("loadCommands", new LoadCommandsCommand());
		commands.put("startWriteCommands", new StartWriteCommandsCommand());
		commands.put("stopWriteCommands", new StopWriteCommandsCommand());
		commands.put("time", new TimeCommand());
		commands.put("useExterminator", new UseExterminatorCommand());
		commands.put("useNeutralizer", new UseNeutralizerCommand());		
	}

	/**
	 * Ha nem l�tezik p�ld�nya az oszt�lynak akkor l�trehozza, ha l�tezik akkor
	 * visszaadja.
	 * 
	 * @return Singleton p�ld�ny.
	 */
	public static CommandDictionary Instance() {
		if (instance == null) {
			instance = new CommandDictionary();
		}

		return instance;
	}

	/**
	 * Visszaadja a t�rolt utas�t�sok list�j�t.
	 * 
	 * @return Utas�t�sok halmaza.
	 */
	public Set<String> getCommandsList() {
		return commands.keySet();
	}

	/**
	 * Lek�rdezi az adott parancshoz tartoz� oszt�lyt.
	 * 
	 * @param command
	 *            Lek�rdezend� parancs.
	 * @return Parancshoz tartoz� oszt�ly.
	 */
	public CommandBase getCommand(final String command) {
		return commands.get(command);
	}
}
