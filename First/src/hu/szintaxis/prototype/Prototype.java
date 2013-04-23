package hu.szintaxis.prototype;

import hu.szintaxis.prototype.commands.CommandBase;
import hu.szintaxis.prototype.commands.CommandDictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import System.GameField;

/**
 * A prototípus kezelõfelületét adja.
 * 
 * @author Dóczi Róbert
 * 
 */
public class Prototype {

	/**
	 * A prototípus singleton példánya.
	 */
	private static Prototype instance;
	
	/**
	 * A command line promptja.
	 */
	private String prompt;

	/**
	 * Bemenet változója.
	 */
	private BufferedReader instream;

	/**
	 * Parancs könyvtár.
	 */
	private CommandDictionary dictionary;
	/**
	 * A játéktér amin szimulálunk.
	 */
	private GameField gameField;

	/**
	 * A prototípus belépési pontja.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Ha paramétersekkel hívtuk meg.
		if (args.length > 0) {
			Prototype.Instance().run(args);
		}
		// Paraméterek nélkül
		else{
			Prototype.Instance().run();
		}
	}
	
	// Paraméteres futtatásra 
	private void run(String[] args){
		dictionary = CommandDictionary.Instance();
		try {
			StringBuilder parameters = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				parameters.append(args[i].toString());
				parameters.append(" ");
			}
			parseCommand(parameters.toString());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
	}

	/**
	 * A prototípus magja.
	 */
	private void run() {
		instream = new BufferedReader(new InputStreamReader(System.in));
		dictionary = CommandDictionary.Instance();
		prompt = ">";

		System.out.println("For a list of commands write \"help\"");

		while (true) {
			try {
				System.out.print(prompt);
				String inputLine = instream.readLine();
				parseCommand(inputLine);
			} catch (Exception e) {
				System.out.println("ERROR: " + e.toString());
			}
		}
	}

	/**
	 * Értelmezi az adott parancsot.
	 * 
	 * @param input Az adott parancs.
	 * @throws Exception
	 */
	public void parseCommand(String input) throws Exception {
		if (input.isEmpty())
			throw new Exception("Invalid Command!");

		String[] splitInput = input.split(" ");

		CommandBase command = dictionary.getCommand(splitInput[0]);

		if (command == null) {
			throw new Exception("Command \"" + splitInput[0] + "\" not found!");
		}

		command.execute(Arrays.copyOfRange(splitInput, 1, splitInput.length));
	}

	/**
	 * Visszaadja a singleton instance-ot.
	 * 
	 * @return singleton instance
	 */
	public static Prototype Instance() {
		if (instance == null) {
			instance = new Prototype();
		}
		return instance;
	}

	/**
	 * Visszaadja az aktuális {@code gameField} példányt.
	 * 
	 * @return a {@code gameField} példány.
	 */
	public GameField getGameField() {
		return gameField;
	}

	/**
	 * Beállítja a gameField példányt egy újra.
	 * 
	 * @param gameField
	 *            az új gameField példány.
	 */
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	/**
	 * Beállítja a promptot.
	 * @param prompt A promptot reprezentáló karakter.
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
