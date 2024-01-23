package org.csystem.app.io.file.output;

import org.csystem.util.console.Console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class AppendRandomByteArrayApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileOutputStream fos = new FileOutputStream(args[0], true)) {
            Random random = new Random();

            while (true) {
                int count = Console.readInt("Input count:");

                if (count <= 0)
                    break;

                byte[] bytes = new byte[count];

                random.nextBytes(bytes);

                fos.write(bytes);
            }
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
