package hu.szintaxis.prototype;

import hu.szintaxis.prototype.commands.CommandBase;
import hu.szintaxis.prototype.commands.CommandDictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import System.GameField;

/**
 * A protot�pus kezel�fel�let�t adja.
 * @author D�czi R�bert
 *
 */
public class Prototype {

	/**
	 * A protot�pus singleton p�ld�nya.
	 */
	private static Prototype instance;
	
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
	 * @param args
	 */
	public static void main(String[] args) {
		Prototype.Instance().run();
	}

	/**
	 * A protot�pus magja.
	 */
	private void run() {
		instream = new BufferedReader(new InputStreamReader(System.in));
		dictionary = CommandDictionary.Instance();

		System.out.println("For a list of commands write \"help\"");
		
		while (true) {
			try {
				System.out.print(">");
				String inputLine = instream.readLine();
				parseCommand(inputLine);
			} catch (Exception e) {
				System.out.println("ERROR: " + e.toString());
			}
		}
	}

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
	
	public static Prototype Instance() {
		if (instance == null) {
			instance = new Prototype();
		}
		return instance;
	}

	public GameField getGameField() {
		return gameField;
	}

	public void setGameField(GameField gameField) {
		this.gameField = gameField;
	}
}
