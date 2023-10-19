/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyimiz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.factory.random.RandomComplexFactory;

import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var factory = new RandomComplexFactory(new Random());
        var numbers = factory.createUntil(-10, 10);

        numbers.forEach(Console::writeLine);
        numbers.sort((z1, z2) -> Double.compare(z2.getNorm(), z1.getNorm()));

        Console.writeLine("After descending order:");
        numbers.forEach(Console::writeLine);
    }
}
