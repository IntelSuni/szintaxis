package hu.szintaxis.prototype.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Commandok tárolására és lekérdezésére használt singleton osztály.
 * 
 * @author Dóczi Róbert
 * 
 */
public class CommandDictionary {

	/**
	 * Singleton példány.
	 */
	private static CommandDictionary instance;

	/**
	 * Utasításokat tároló map.
	 */
	private Map<String, CommandBase> commands;

	/**
	 * Konstruktor, mely létrehozza a mapet, és feltölti az alap utasításokkal.
	 */
	private CommandDictionary() {
		commands = new HashMap();
		// Itt hozzá kéne adni az összes commandot!
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
	 * Ha nem létezik példánya az osztálynak akkor létrehozza, ha létezik akkor
	 * visszaadja.
	 * 
	 * @return Singleton példány.
	 */
	public static CommandDictionary Instance() {
		if (instance == null) {
			instance = new CommandDictionary();
		}

		return instance;
	}

	/**
	 * Visszaadja a tárolt utasítások listáját.
	 * 
	 * @return Utasítások halmaza.
	 */
	public Set<String> getCommandsList() {
		return commands.keySet();
	}

	/**
	 * Lekérdezi az adott parancshoz tartozó osztályt.
	 * 
	 * @param command
	 *            Lekérdezendõ parancs.
	 * @return Parancshoz tartozó osztály.
	 */
	public CommandBase getCommand(final String command) {
		return commands.get(command);
	}
}
