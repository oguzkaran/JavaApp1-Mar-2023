package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadLinesViaFilesApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (BufferedReader br = Files.newBufferedReader(Path.of(args[0]), StandardCharsets.UTF_8)) {
            String str;

            while ((str = br.readLine()) != null)
                Console.writeLine(str);
        }
        catch (IOException ex) {
            Console.writeErrLine("IO problem occurred:%s", ex.getMessage());
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
