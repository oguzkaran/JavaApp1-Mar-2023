/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.data.test.factory.ProductFactory;
import org.csystem.util.data.test.product.ProductInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.StreamSupport;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    private static void writeProducts(List<ProductInfo> products, String path) throws IOException
    {
        try (var bw = Files.newBufferedWriter(Path.of(path), StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            products.forEach(p -> writeProduct(p, bw));
        }
    }

    private static void writeProduct(ProductInfo productInfo, BufferedWriter bw)
    {
        try {
            bw.write(productInfo.toString() + "\r\n");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO error occurs:%s", ex.getMessage());
        }
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments");

        try {
            var factory = ProductFactory.loadFromTextFile(Path.of(args[0]));
            var products = factory.getProductsAsIterable();
            var a = StreamSupport.stream(products.spliterator(), false).filter(p -> p.getStock() > 0);

            Console.writeLine(a.getClass().getName());
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid grade value!...");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO problem occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getClass().getName());
        }
    }
}
