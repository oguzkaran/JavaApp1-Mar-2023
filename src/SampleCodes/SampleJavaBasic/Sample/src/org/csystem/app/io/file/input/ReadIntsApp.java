package org.csystem.app.io.file.input;

import org.csystem.util.console.Console;
import org.csystem.util.converter.BitConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadIntsApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 1, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            int result;
            byte [] data = new byte[Integer.BYTES];

            while ((result = fis.read(data)) > 0) {
                if (result != data.length)
                    throw new IOException("Invalid file format!...");

                int val = BitConverter.toInt(data);

                Console.write("%d ", val);
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
