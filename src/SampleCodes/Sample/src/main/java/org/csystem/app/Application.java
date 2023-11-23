/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte hiç bir ürün stokta olmama koşuluna uymuyorsa uygun mesaj verilmiştir. aks durumda stokta
    olmayan ürünler listelenmiştir. Yukarıdaki işlem ile aynı değil mi?
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;

import java.io.IOException;
import java.nio.file.Path;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = factory.PRODUCTS;

            if (products.stream().noneMatch(p -> p.getStock() <= 0))
                Console.writeLine("All product are in stock");
            else {
                Console.writeLine("Product not in stock:");
                products.stream().filter(p -> p.getStock() <= 0).forEach(Console::writeLine);
            }
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




