/*----------------------------------------------------------------------------------------------------------------------
    Guava kütüphanesinin StopWatch sınıfı:
    https://github.com/google/guava (11th Apr 2023 22:49 Europe/Istanbul)
    Anahtar Notlar: Bu kütüphanedeki hemen hemen her sınıf Apache Lisansı'na göre kullanılabilmektedir. Bu lisansı
    inceleyiniz:
    https://www.apache.org/licenses/LICENSE-2.0 (11th Apr 2023 22:56 Europe/Istanbul)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

class Application {
    public static void run(String[] args)
    {
        IsPrimeTest.run();
    }
}

class IsPrimeTest {
    public static void run()
    {
        for (;;) {
            var val = Console.readLong("Bir sayı giriniz:");

            if (val <= 1)
                break;

            Console.writeLine("isPrime(BigInteger)");
            var start = System.nanoTime();
            boolean result = NumberUtil.isPrime(BigInteger.valueOf(val));
            var stop = System.nanoTime();
            var elapsed = stop - start;
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", TimeUnit.MILLISECONDS.convert(elapsed, TimeUnit.NANOSECONDS) / 1000.);

            Console.writeLine("isPrime(long)");
            start = System.nanoTime();
            result = NumberUtil.isPrime(val);
            stop = System.nanoTime();
            elapsed = stop - start;
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", TimeUnit.MILLISECONDS.convert(elapsed, TimeUnit.NANOSECONDS) / 1000.);
        }
    }
}

