/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıdaki gibi çalışan programı yazınız.
        java -jar ConcatTextWithSeparator.jar <separator> <text-1> <text-2> ... <text-n>
    Birinci komut satırı argümanı ile aldığı ayraç ile diğer komut satırı argümanı ile aldığı yazılar birleştirilecektir.
    Örneğin
        java -jar ConcatTextWithSeparator.jar ; oguzkaran@csystem.org aslank@csystem.org aliserce@csystem.org
    şeklinde çalıştırıldığıda stdout çıktısı şu şekilde olacaktır:
        oguzkaran@csystem.org;aslank@csystem.org;aliserce@csystem.org
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import static com.karandev.util.console.commandline.CommandLineUtil.*;

class Application {
    public static void run(String [] args)
    {
        checkLengthGreaterOrEquals(args.length, 3, "usage: java -jar ConcatTextWithSeparator.jar <separator> <text-1> <text-2> ... <text-n>");
        var sb = new StringBuilder();

        for (int i = 1; i < args.length; ++i)
            sb.append(args[i]).append(args[0]);

        var str = sb.substring(0, sb.length() - args[0].length());

        Console.writeLine(str);
    }
}
