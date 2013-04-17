package hu.szintaxis.prototype;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import hu.szintaxis.prototype.commands.CommandBase;
import hu.szintaxis.prototype.commands.CommandDictionary;

public class Prototype {

	private BufferedReader instream;
	private CommandDictionary dictionary;

	public static void main(String[] args) {
		(new Prototype()).run();
	}

	private void run() {
		instream = new BufferedReader(new InputStreamReader(System.in));
		dictionary = CommandDictionary.Instance();

		System.out.println("For a list of commands write \"ListCommands\"");
		
		while (true) {
			try {
				System.out.print(">");
				String inputLine = instream.readLine();
				parseCommand(inputLine);
			} catch (Exception e) {
				System.out.println("ERROR: " + e.getLocalizedMessage());
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
}
