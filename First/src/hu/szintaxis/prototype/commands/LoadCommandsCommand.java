package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * A loadCommands parancs osztálya. Betölti a parancsokat egy fileból és
 * lefuttatja õket.
 * 
 * @author Dóczi Róbert
 * 
 */
public class LoadCommandsCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: loadCommands <File> \n"
					+ " Example: loadCommands C:/test1.txt");
		}

		File f = new java.io.File(args[0]);
		if (!f.exists()) {
			throw new Exception("File not found!");
		}
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String currentLine;
		
		while ((currentLine = br.readLine()) != null) {
			System.out.println(currentLine);
			Prototype.Instance().parseCommand(currentLine);
		}
	}
}
