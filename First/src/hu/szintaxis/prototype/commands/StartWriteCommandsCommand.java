package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;
import hu.szintaxis.prototype.PrototypeUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * A startWriteCommands parancs osztálya. Elkezdi kiírni a kimenetet egy fileba.
 * 
 * @author Dóczi Róbert
 * 
 */
public class StartWriteCommandsCommand extends CommandBase {

	@Override
	public void execute(String... args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Invalid arguments. \n"
					+ " Usage: startWriteCommands <File> \n"
					+ " Example: startWriteCommands C:/testout.txt");
		}
		
		File f = new java.io.File(args[0]);
		if (!f.exists()) {
			f.createNewFile();
		}

		PrototypeUtil.setOutputFile(f);
		PrintStream pw = new PrintStream(f);
		System.setOut(pw);
		Prototype.Instance().setPrompt("");
	}
}
