/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.util.stream.DoubleStream;

class Application {
    public static void run(String[] args)
    {
        DoubleStream.iterate(-2 * Math.PI, a -> a < 2 * Math.PI, a -> a + 0.01)
                .map(Math::sin)
                .forEach(Console::writeLine);
    }
}

