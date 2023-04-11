/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: UtilLib içerisindeki NumberUtil sınıfına BigInteger parametreli işPrime metodunu ekleyiniz
    long sınırları içerisinde bulunan büyük axal sayılar ile test edebilirsiniz:
    6750161072220585911
    1603318868174368979
    6584583408148485263
    6245098347044246839
    6285871677077738093
    5697859706174583067
    710584055392819667
    4935060337471977161
    3728803592870153407
    4331452335614730577
    1386437196678024971
    1677990107453991593
    4765603950744460867
    4498306523077899307
    4434895834573449257
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
    }
}


class IsPrimeTest2 {
    public static void run()
    {
        var n = Console.readBigInteger("Bir sayı giriniz:");

        Console.writeLine(NumberUtil.isPrime(n) ? "Asal" : "Asal değil");
    }
}
