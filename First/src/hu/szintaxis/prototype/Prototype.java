package hu.szintaxis.prototype;

import hu.szintaxis.prototype.commands.CommandBase;
import hu.szintaxis.prototype.commands.CommandDictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import System.GameField;

/**
 * A protot�pus kezel�fel�let�t adja.
 * 
 * @author D�czi R�bert
 * 
 */
public class Prototype {

	/**
	 * A protot�pus singleton p�ld�nya.
	 */
	private static Prototype instance;
	
	/**
	 * A command line promptja.
	 */
	private String prompt;

	/**
	 * Bemenet v�ltoz�ja.
	 */
	private BufferedReader instream;

	/**
	 * Parancs k�nyvt�r.
	 */
	private CommandDictionary dictionary;
	/**
	 * A j�t�kt�r amin szimul�lunk.
	 */
	private GameField gameField;

	/**
	 * A protot�pus bel�p�si pontja.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Ha param�tersekkel h�vtuk meg.
		if (args.length > 0) {
			Prototype.Instance().run(args);
		}
		// Param�terek n�lk�l
		else{
			Prototype.Instance().run();
		}
	}
	
	// Param�teres futtat�sra 
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
	 * A protot�pus magja.
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
	 * �rtelmezi az adott parancsot.
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
	 * Visszaadja az aktu�lis {@code gameField} p�ld�nyt.
	 * 
	 * @return a {@code gameField} p�ld�ny.
	 */
	public GameField getGameField() {
		return gameField;
	}

	/**
	 * Be�ll�tja a gameField p�ld�nyt egy �jra.
	 * 
	 * @param gameField
	 *            az �j gameField p�ld�ny.
	 */
	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	/**
	 * Be�ll�tja a promptot.
	 * @param prompt A promptot reprezent�l� karakter.
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
}
