/*----------------------------------------------------------------------------------------------------------------------
    Optinal<T> sınıfının filter metodu. Bu metot koşul gerçeklenmezse veya boş optional için boş optional'a geri döner
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.app.factory.random.RandomPasswordFactory;
import org.csystem.util.concurrent.ThreadUtil;

import java.util.Random;

class Application {
    public static void run(String [] args)
    {
        var random = new Random();
        var factory = new RandomPasswordFactory(random);
        var min = -10;
        var bound = 30;

        while (true) {
            var minLen = random.nextInt(min, bound);
            var boundLen = random.nextInt(minLen + 1, bound);
            var strOpt = factory.createPassword(minLen, boundLen);

            Console.writeLine("---------------------------------");
            if (strOpt.isPresent()) {
                Console.writeLine(strOpt.get());
                strOpt.filter(p -> p.contains("D") || p.contains("d"))
                        .ifPresentOrElse(Console::writeLine, () -> Console.writeLine("Not contains!..."));
            }
            else
                Console.writeLine("Not generated");

            Console.writeLine("---------------------------------");
            ThreadUtil.sleep(2000);
        }
    }
}
