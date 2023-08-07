/*----------------------------------------------------------------------------------------------------------------------
    OptinalInt sınıfının orElseThrow metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;
import org.csystem.util.string.StringUtil;

import java.util.OptionalInt;
import java.util.Random;

class Application {
    public static void run(String [] args)
    {
        var text = "abc1234567890";
        var random = new Random();

        while (true) {
            try {
                var str = StringUtil.getRandomText(random, random.nextInt(2, 5), text);

                Console.writeLine("---------------------------------");
                Console.writeLine("ValueStr:%s", str);
                var resultOpt = Util.toInt(str);
                resultOpt.ifPresentOrElse(val -> Console.writeLine("%d * %d = %d", val, val, val * val), () -> throw new IllegalArgumentException("Invalid value!..."));

                Console.writeLine("---------------------------------");
                ThreadUtil.sleep(1000);
            }
            catch (IllegalArgumentException ex) {
                Console.writeLine(ex.getMessage());
            }
        }
    }
}

class Util {
    public static OptionalInt toInt(String str)
    {
        OptionalInt result;

        try {
            result = OptionalInt.of(Integer.parseInt(str));
        }
        catch (NumberFormatException ignore) {
            result = OptionalInt.empty();
        }

        return result;
    }
}
