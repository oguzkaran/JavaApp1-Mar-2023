package org.csystem.util.console.test;

import org.csystem.util.console.Console;

public class ReadCharTest {
    public static void run()
    {
        char c = Console.readChar("Bir karakter giriniz:", "Tek bir karakter girmelisiniz!...");

        Console.writeLine("c = %c", c);
    }

    public static void main(String[] args)
    {
        run();
    }
}
