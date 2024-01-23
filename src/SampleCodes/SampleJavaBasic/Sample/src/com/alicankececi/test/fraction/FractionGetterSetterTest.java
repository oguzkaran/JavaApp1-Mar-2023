package com.alicankececi.test.fraction;

import org.csystem.math.Fraction;
import com.alicankececi.test.fraction.factory.FractionFactory;
import org.csystem.util.console.Console;

public class FractionGetterSetterTest {
    private static void run()
    {
        FractionFactory factory = new FractionFactory();

        try {
            Fraction f = factory.createRandomFraction(-10, 10);
            System.out.println("--------------------------------------------------------------");
            Console.writeLine("f = %s", f);
            f.setNumerator(Console.readInt("Set Numerator : "));
            f.setDenominator(Console.readInt("Set Denominator : "));
            Console.writeLine("Numerator = %d\nDenominator = %d\nf = %s", f.getNumerator(), f.getDenominator(), f);
            System.out.println("--------------------------------------------------------------");
        }
        catch (NumberFormatException ignore)
        {
            Console.writeLine("Invalid Fraction Value");
        }
    }
    public static void main(String[] args)
    {
        run();
    }
}


