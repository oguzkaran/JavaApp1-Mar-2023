/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte switch expression'ın default kısmında assert yapılmıştır. Çünkü algoritma gereği akışın default case'e
    gelmemesi gerekir. Bu durumda programcı algoritmasını doğru yazıp yazmadığını test etmek isteyebilir. ** ile belirtilen
    assert deyimlerinde metodun başında yapılan sınır değer kontrolünün doğru yapılıp yapılmadığını test etmek için kullanılmıştır.
    * ile belirtilen assert deyimi ile tüm basamaklara ilişkin case bölümlerinin yazılmadığı test edilmektedir.
    Buradaki assert deyimleri && yapılarak tek bir assert olarak da yazılabilir.Ancak bu durumda hangi nedenden dolayı
    problem olduğunun anlaşılması güçleşebilir. Bu tip durumlarda ayrı assert deyimleri yazılması tavsiye edilir.
    Şüphesiz örnek metot başka biçimlerde de yazılabilir. Hatta bu şekilde yapıldığında "JUnit" ile de test edilebilir.
    Ancak metot private ve bu şekilde yazılsaydı assert deyimi uygun olurdu.
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        for (int i = 0; i <= 10; ++i)
            Console.writeLine(Util.getDigitStrTR(i));

        Console.writeLine(Util.getDigitStrTR(10));
    }
}

class Util {
    private static final boolean DEBUG = false;

    public static String getDigitStrTR(int digit)
    {
        if (digit < 0 || digit > 9)
            return "";

        String str = "";

        switch (digit) {
            case 0 -> str = "sıfır";
            case 1 -> str = "bir";
            case 2 -> str = "iki";
            case 3 -> str = "üç";
            case 4 -> str = "dört";
            //case 5 -> str = "beş";
            case 6 -> str = "altı";
            case 7 -> str = "yedi";
            case 8 -> str = "sekiz";
            case 9 -> str = "dokuz";
            default -> {
                if (DEBUG) {
                    var msg = String.format("Digit:%d", digit);
                    //*
                    assert digit <= 9: "Cause: Control for bounds (digit > 9):" + msg; //**
                    assert digit >= 0: "Cause: Control for bounds (digit < 0):" + msg; //**
                }
            }
        }

        return str;
    }
}