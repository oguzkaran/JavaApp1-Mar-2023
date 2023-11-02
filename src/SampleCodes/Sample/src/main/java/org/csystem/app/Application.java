/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği ve ilgili metotları inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.factory.random.RandomFractionFactory;

import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var factory = new RandomFractionFactory(new Random());
        var complexSet = factory.createTreeSetUntilInvalidNullLast(-10, 10);

        complexSet.forEach(Console::writeLine);
    }
}
