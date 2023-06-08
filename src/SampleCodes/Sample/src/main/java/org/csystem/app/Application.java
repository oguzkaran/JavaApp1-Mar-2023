/*----------------------------------------------------------------------------------------------------------------------
    
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

class Application {
    public static void run(String [] args)
    {
        while (true) {
            var n = Console.readInt("Bir sayı giriniz:");

            if (n == 0)
                break;

            var str = Console.read("Bir yazı giriniz:");
            var encStr = CryptoUtil.encryptDecrypt(str, n);

            Console.writeLine(encStr);

            var decStr = CryptoUtil.encryptDecrypt(encStr, n);

            Console.writeLine(decStr);
        }
    }
}


class CryptoUtil {
    public static String encryptDecrypt(String s, int n)
    {
        var len = s.length();
        var sb = new StringBuilder(n);

        for (var i = 0; i < len; ++i)
            sb.append((char)(s.charAt(i) ^ n));

        return sb.toString();
    }
}

