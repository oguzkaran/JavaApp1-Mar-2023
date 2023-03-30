/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.math.BigDecimal;

class Application {
    public static void run(String[] args)
    {
        var val = Console.readBigDecimal("Bir sayı giriniz:");
        var total = BigDecimal.ZERO;
        var incVal = new BigDecimal("0.01");

        for (var i = BigDecimal.ZERO; i.compareTo(val) < 0; i = i.add(incVal)) {
            Console.writeLine("%s", i);
            total = total.add(i);
        }

        Console.writeLine("Toplam:%s", total);
    }
}
