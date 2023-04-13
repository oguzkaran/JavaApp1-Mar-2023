/*----------------------------------------------------------------------------------------------------------------------
    Test İşlemleri:
    Yazılımda test süreçleri ürün geliştirmenin önemli bir aşamasını oluşturmaktadır. Bazı yazaılımlarda, ürünün herşeyiyle
    doğru olması kritik öneme sahip olabilmektedir. Bazı yazılımlarda hata toleransları olabilir. Gerektiğinde düzeltilebilir.


----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.datetime.stopwatch.StopWatch;
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
        for (;;) {
            var val = Console.readLong("Bir sayı giriniz:");

            if (val <= 1)
                break;

            var stopWatch = new StopWatch();
            Console.writeLine("isPrime(BigInteger)");

            stopWatch.start();
            boolean result = NumberUtil.isPrime(BigInteger.valueOf(val));
            stopWatch.stop();
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", stopWatch.elapsedInMillis() / 1000.);

            Console.writeLine("isPrime(long)");
            stopWatch.start();
            result = NumberUtil.isPrime(val);
            stopWatch.stop();
            Console.writeLine(result ? "Asal" : "Asal değil");
            Console.writeLine("Elapsed in seconds:%.20f", stopWatch.elapsedInMillis() / 1000.);
        }
    }
}

