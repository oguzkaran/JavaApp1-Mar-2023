package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadBytesAsCharApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            int result;

            while ((result = fis.read()) != -1) {
                char val = (char)result;

                Console.write("%c", val);
            }

            Console.writeLine();
        }
        catch (FileNotFoundException ex) {
            Console.writeErrLine("Problem occurred while opening the file:%s", ex.getMessage());
        }
        catch (SecurityException ex) {
            Console.writeErrLine("Security occurred while opening the file:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("IO problem occurred while opening the file:%s", ex.getMessage());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
