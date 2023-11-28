/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte dizi içerisindeki asal sayıların toplamı bulunmuştur
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.NumberFactory;
import org.csystem.util.numeric.NumberUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1 , "Wrong number of arguments");

        try {
            var factory = NumberFactory.loadFromTextFile(Path.of(args[0]));
            var numbers = factory.getNumbers();

            var total = IntStream.of(numbers).filter(NumberUtil::isPrime).sum();

            Console.writeLine("Total:%d", total);
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
