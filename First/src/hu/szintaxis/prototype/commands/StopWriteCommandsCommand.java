package hu.szintaxis.prototype.commands;

import hu.szintaxis.prototype.Prototype;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * A stopWriteCommands parancs oszt�lya. A kimenet ki�r�s�t abbahagyja.
 * @author D�czi R�bert
 *
 */
public class StopWriteCommandsCommand extends CommandBase {

	private PrintStream originalOutputStream;
	
	{
		originalOutputStream = System.out;
	}
	
	@Override
	public void execute(String... args) throws Exception {
		System.setOut(originalOutputStream);
		Prototype.Instance().setPrompt(">");
	}
}
