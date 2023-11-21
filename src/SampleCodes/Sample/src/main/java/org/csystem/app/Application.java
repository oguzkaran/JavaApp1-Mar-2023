/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;
import org.csystem.app.data.ProductNamePriceInfo;

import java.io.IOException;
import java.nio.file.Path;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = factory.PRODUCTS;

            products.stream()
                    .filter(p -> p.getStock() <= 0)
                    .filter(p -> p.getName().contains(args[1]))
                    .map(p -> new ProductNamePriceInfo(p.getName(), p.getPrice()))
                    .forEach(Console::writeLine);
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


