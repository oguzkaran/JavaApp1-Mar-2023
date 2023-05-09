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

class Application {
    public static void run(String[] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(1);
        }

        Console.writeLine("%s%s%s", args[1], args[0], args[2]);
    }
}
