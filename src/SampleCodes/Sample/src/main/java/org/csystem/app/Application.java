/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek BitwiseUtil sınıfının isClear metodu ile de yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.bitwise.BitwiseUtil;

class Application {
    public static void run(String [] args)
    {
        while (true) {
            var a = Console.readInt("Bir sayı giriniz:");

            Console.writeLine("-------------------------------------");
            BitwiseUtil.writeBits(a);
            Console.writeLine("a = %d", a);
            Console.writeLine(BitwiseUtil.isClear(a, 0) ? "Çift" : "Tek");
            Console.writeLine("-------------------------------------");

            if (a == 0)
                break;
        }
    }
}


