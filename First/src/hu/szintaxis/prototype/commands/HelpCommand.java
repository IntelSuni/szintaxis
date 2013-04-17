package hu.szintaxis.prototype.commands;

import java.util.Iterator;
import java.util.Set;

/**
 * A help parancs osztálya. Kilistázza az utasításokat.
 * 
 * @author Dóczi Róbert
 * 
 */
public class HelpCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		Set<String> commands = CommandDictionary.Instance().getCommandsList();

		Iterator<String> iterator = commands.iterator();

		while (iterator.hasNext()) {
			String command = iterator.next();
			System.out.print(command);
			if (iterator.hasNext()) {
				System.out.print(", ");
			} else {
				System.out.println();
			}
		}
	}
}
