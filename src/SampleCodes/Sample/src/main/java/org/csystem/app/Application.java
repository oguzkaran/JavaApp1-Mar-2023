/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte, org-csystem-math kütüphanesinin 16.0.0+ versiyonlarında karmaşık sayı artık son eleman olarak
    bulunacaktır. Çünkü artık equals metodu override edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.factory.random.RandomComplexFactory;
import org.csystem.math.Complex;

import java.util.ArrayList;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        var numbers = new ArrayList<Complex>();
        var factory = new RandomComplexFactory(new Random());

        while (true) {
            var z = factory.create(-10, 10);

            numbers.add(z);

            if (z.getReal() == 0 && z.getImag() == 0)
                break;
        }

        var zero = new Complex();
        var index = numbers.indexOf(zero);

        numbers.forEach(Console::writeLine);

        Console.writeLine("%s", zero + (index != -1 ? " found at index:" + index : " not found"));
    }
}
