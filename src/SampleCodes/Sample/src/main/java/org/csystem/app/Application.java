/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: UtilLib içerisindeki NumberUtil sınıfına BigInteger parametreli işPrime metodunu ekleyiniz
    Not: UtilLib'in 16.0.0 versiyonunda yazıldı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;

class Application {
    public static void run(String[] args)
    {
        IsPrimeTest.run();
    }
}

class IsPrimeTest {
    public static void run()
    {
        IsPrimeTest1.run();
        IsPrimeTest2.run();
    }
}


class IsPrimeTest1 {
    public static void run()
    {
        var n = Console.readBigInteger("Bir sayı giriniz:");

        for (var i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE))
            if (NumberUtil.isPrime(i))
                Console.write("%s ", i);

        Console.writeLine();
    }
}

class IsPrimeTest2 {
    public static void run()
    {
        var n = Console.readBigInteger("Bir sayı giriniz:");

        Console.writeLine(NumberUtil.isPrime(n) ? "Asal" : "Asal değil");
    }
}
