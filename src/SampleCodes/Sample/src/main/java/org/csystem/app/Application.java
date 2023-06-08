/*----------------------------------------------------------------------------------------------------------------------
    Soru: Bir tamsayının belirli bir bitinin 1 yapılmasına ilişkin kodu yazınız.
    Bu işlemi yapabilmek için, sayının ilgili biti 1 olan ve diğer bitleri sofır olan bir sayı ile "OR" işlemine sokulması
    gerekir.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.bitwise.BitwiseUtil;

class Application {
    public static void run(String [] args)
    {
        while (true) {
            var a = Console.readInt("Birinci sayıyı giriniz:");
            var b = Console.readInt("Birinci sayıyı giriniz:");

            BitwiseUtil.writeBits(a);
            BitwiseUtil.writeBits(b);
            Console.writeLine("a = %d, b = %d", a, b);
            Console.writeLine("-------------------------------------");

            a ^= b;
            b ^= a;
            a ^= b;

            BitwiseUtil.writeBits(a);
            BitwiseUtil.writeBits(b);
            Console.writeLine("a = %d, b = %d", a, b);
            if (a == 0 && b == 0)
                break;
        }
    }
}


