/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: UtilLib içerisindeki NumberUtil sınıfına int parametreli ve BigInteger referasnsına geri dönen
    factorialBig metodunu ekleyiniz ve aşağıdaki kod ile test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;
import java.util.Random;

class Application {
    public static void run(String[] args)
    {
        FactorialBigTest.run();
    }
}

class FactorialBigTest {
    public static void run()
    {
        var n = Console.readInt("Bir sayı giriniz:");

        for (var i = 0; i < n; ++i)
            Console.writeLine("%d! = %s", NumberUtil.factorialBig(n));
    }
}
