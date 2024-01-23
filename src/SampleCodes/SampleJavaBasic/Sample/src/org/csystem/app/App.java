/*-----------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

class App {
	public static void main(String[] args)
	{
		while (true) {
			char c = Console.readChar("Input a character:", "invalid character!...");

			if (c == 'q')
				break;

			if (c != 'y' && c!= 'n')
				continue;

			Console.writeLine(c);
		}
	}
}
