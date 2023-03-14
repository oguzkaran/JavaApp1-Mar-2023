package org.csystem.app;

import com.karandev.util.console.Console;

public class App {
    public static void main(String[] args)
    {
        int val = Console.readInt("Input a number", "Invalid Number!...");

        Console.writeLine("%d * %d = %d", val, val, val * val);
    }
}
