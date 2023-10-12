/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.factory.random.RandomFractionFactory;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var factory = new RandomFractionFactory(new Random());
        var  fractions = factory.createUntilInvalid(-10, 10);

        fractions.forEach(Console::writeLine);

        try {
            var min = Collections.min(fractions);
            var max = Collections.max(fractions);

            Console.writeLine("Min:%s", min);
            Console.writeLine("Max:%s", max);
        }
        catch (NoSuchElementException ignore) {
            Console.Error.writeLine("No fraction generated!...");
        }
    }
}
