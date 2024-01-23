package org.csystem.app.fraction;

import org.csystem.app.fraction.random.RandomFractionFactory;
import org.csystem.math.Fraction;
import org.csystem.util.console.Console;

import java.util.ArrayList;
import java.util.Random;

public class DemoApp {
    private static void findFractionIndex(ArrayList fractions)
    {
        try {
            while (true) {
                int a = Console.readInt("Input numerator:");
                int b = Console.readInt("Input denominator:");

                Fraction f = new Fraction(a, b);
                int index = fractions.indexOf(f);

                if (index != -1)
                    Console.writeLine("%s found at %d", f, index);
                else
                    Console.writeLine("%s not found", f);
            }

        }
        catch (NumberFormatException ignore) {
            Console.writeLine("Invalid fraction values!...");
        }
    }
    private static void printFractions(ArrayList fractions)
    {
        Console.writeLine("Created fractions:");
        for (Object o : fractions)
            Console.writeLine(o);
    }

    public static void run()
    {
        RandomFractionFactory factory = new RandomFractionFactory(new Random());
        ArrayList fractions = factory.createFractionList(-10, 10);

        printFractions(fractions);
        findFractionIndex(fractions);
    }

    public static void main(String[] args)
    {
        run();
    }
}
