/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.math.Complex;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var treeSet = new TreeSet<>(Comparator.comparingDouble(Complex::getNorm).reversed());

        var zero = new Complex();

        while (true) {
            var z = new Complex(random.nextInt(-10, 11), random.nextInt(-10, 11));

            if (z.equals(zero))
                break;

            Console.writeLine("%s -> %s", z, treeSet.add(z) ? "Added" : "Duplicate");
        }

        treeSet.forEach(Console::writeLine);
        Console.writeLine();
    }
}
