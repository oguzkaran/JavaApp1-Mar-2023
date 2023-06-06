/*----------------------------------------------------------------------------------------------------------------------
    ~ operatörü tek operandlı (unary), önek (prefix) durumunda bir operatördür. Bu operatör operandına ilişkin
    ifadenin değeri olan tamsayının bitleri üzerinde 1'e tümeleme (one's complement) işlemi yaparak elde edilen değeri
    üretir. Yani operandı olan tamsayının 1 olan bitlerini sıfır, sıfır olan bitlerini de 1 yapar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.bitwise.BitwiseUtil;

class Application {
    public static void run(String [] args)
    {
        while (true) {
            var val = Console.readInt("Bir sayı giriniz:");
            var result = ~val;

            BitwiseUtil.writeBits(val);
            BitwiseUtil.writeBits(result);

            if (val == 0)
                break;
        }
    }
}
