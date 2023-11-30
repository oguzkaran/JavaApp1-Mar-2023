/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

import static com.karandev.io.util.console.commandline.CommandLineUtil.checkLengthEquals;

class Application {
    private static void writeFileCallback(BufferedWriter bw, String str)
    {
        try {
            bw.write(str + "\r\n");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred while writing:%s", ex.getMessage());
        }

    }
    private static void textGenerateStepCallback(BufferedWriter bw, RandomGenerator randomGenerator, int min, int max)
    {
        writeFileCallback(bw, StringUtil.getRandomTextEN(randomGenerator, randomGenerator.nextInt(min, max + 1)));
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 4, "Wrong number of arguments");

        try (var bw = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE)){
            var count = Integer.parseUnsignedInt(args[1]);
            var min = Integer.parseUnsignedInt(args[2]);
            var max = Integer.parseUnsignedInt(args[3]);
            var random = new Random();

            IntStream.range(0, count).forEach(i -> textGenerateStepCallback(bw, random, min, max));
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid count value!...");
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:%s", ex.getMessage());
        }
    }
}

