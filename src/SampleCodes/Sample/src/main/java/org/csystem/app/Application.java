/*----------------------------------------------------------------------------------------------------------------------
    Collection<T> arayüzü
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

class Application {
    public static void run(String[] args)
    {
        var random = new Random();
        var vector = new Vector<Integer>();
        var list = new ArrayList<>();

        while (true) {
            var val = random.nextInt(-20, 20);

            if (NumberUtil.isPrime(val))
                list.add(val);

            vector.add(val);

            if (val == 0)
                break;
        }

        vector.forEach(val -> Console.write("%d ", val));
        Console.writeLine();

        list.addAll(vector);

        list.forEach(val -> Console.write("%d ", val));
        Console.writeLine();

    }
}
