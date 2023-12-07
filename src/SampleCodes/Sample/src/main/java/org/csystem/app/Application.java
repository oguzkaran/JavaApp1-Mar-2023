/*----------------------------------------------------------------------------------------------------------------------
    Collectors.toList metotları ile elde edilen List<T> arayüzüne ilişkin collection'da değişiklik yapılıp yapılamayacağı
    garanti değildir. Ancak Stream.toList ve Collectors.toUnmodifiableList metotlarından elde edilen collection'da
    değişiklik yapılamaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = factory.PRODUCTS;

            var names = products.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

            names.forEach(Console::writeLine);

            names.add("Bartu");

            names.forEach(Console::writeLine);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid stock amount");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}
