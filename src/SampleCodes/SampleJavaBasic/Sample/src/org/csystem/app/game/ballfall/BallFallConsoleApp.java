package org.csystem.app.game.ballfall;

import org.csystem.game.ballfall.BallFall;
import org.csystem.util.console.Console;

import java.util.InputMismatchException;

class BallFallConsoleApp {
	public static void run()
	{
		BallFall ballFall = new BallFall();
		
		for (;;) {
			try {
				int width = Console.readInt("Input width:");
				int height = Console.readInt("Input height:");

				if (width == 0)
					break;

				ballFall.play(width, height);
				Console.writeLine(ballFall.getShape());
			}
			catch (IllegalArgumentException | InputMismatchException ex) {
				String message = ex.getMessage();
				Console.writeLine("Invalid values!...%s", message != null ? "->" + message : "");
			}
		}
	}

	public static void main(String[] args)
	{
		run();
	}
}
