package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomLinesViaFilesTRApp {
    private static void doAppend(String path, int count) throws IOException
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            Random random = new Random();

            while (count-- > 0)
                bw.write(StringUtil.getRandomTextTR(random, random.nextInt(5, 11)) + "\r\n");
        }
        catch (IOException ex) {
            Console.writeErrLine("IO Problem occurred:%s", ex.getMessage());
        }
    }

    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try (BufferedWriter bw = Files.newBufferedWriter(Path.of(args[0]), StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
            doAppend(args[0], Integer.parseInt(args[1]));
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid count value!...");
        }
        catch (Throwable ex) {
            Console.writeErrLine("Problem occurred:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
