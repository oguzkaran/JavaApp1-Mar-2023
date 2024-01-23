package com.alicankececi.test.fraction;

import org.csystem.math.Fraction;
import com.alicankececi.test.fraction.factory.FractionFactory;
import org.csystem.util.console.Console;

public class FractionDecTest {
    private static void run()
    {
        FractionFactory factory = new FractionFactory();

        int count = Console.readInt("Bir sayı giriniz: ");

        while (count-- > 0) {
            try {
                Fraction f = factory.createRandomFraction(-10, 10);
                System.out.println("--------------------------------------------------------------");
                Console.writeLine("f = %s", f);
                f.dec();
                Console.writeLine("f - 1 = %s", f);
                System.out.println("--------------------------------------------------------------");
            }
            catch (NumberFormatException ignore)
            {
                Console.writeLine("Invalid Fraction Value");
            }
        }
    }
    public static void main(String[] args)
    {
        run();
    }
}


