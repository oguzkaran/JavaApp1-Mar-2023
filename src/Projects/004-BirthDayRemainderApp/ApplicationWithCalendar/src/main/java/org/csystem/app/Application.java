package org.csystem.app;

import com.karandev.util.console.Console;

import static com.karandev.util.console.commandline.CommandLineUtil.*;
class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments");

        try {
            int day = Integer.parseInt(args[0]);
            int month = Integer.parseInt(args[1]);
            int year = Integer.parseInt(args[2]);

            //TODO:
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
    }
}
