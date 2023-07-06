package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        try {

        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid argüments!...");
        }
    }
}
