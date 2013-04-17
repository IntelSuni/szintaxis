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

		int i = 0;
		while (iterator.hasNext()) {
			String command = iterator.next();
			System.out.print(command);
			if (iterator.hasNext()) {
				System.out.print(", ");
				i++;
			} else {
				System.out.println();
			}
			// 5 elemenként új sor
			if (i % 5 == 0) {
				System.out.println();
			}
		}
	}
}
