/*----------------------------------------------------------------------------------------------------------------------
    JavaSE'de başka bir collection sınıfından türetilmiş collection sınıflar da vardır. Bu tarz sınıflara adaptör
    sınıflar da denir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.Random;
import java.util.Vector;

class Application {
    public static void run(String[] args)
    {
        var vector = new Vector<Integer>(10, 10);
        var random = new Random();

        Console.writeLine("Capacity:%d", vector.capacity());

        while (true) {
            int val = random.nextInt(-99, 100);

            if (val == 0)
                break;

            vector.add(val);
        }

        Console.writeLine("Capacity:%d", vector.capacity());
        Console.writeLine("Size:%d", vector.size());
    }
}
