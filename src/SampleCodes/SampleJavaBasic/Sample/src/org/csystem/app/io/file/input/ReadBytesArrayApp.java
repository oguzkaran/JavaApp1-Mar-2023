package org.csystem.app.io.file.input;

import org.csystem.util.array.ArrayUtil;
import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class ReadBytesArrayApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])) {
            byte [] bytes = new byte[Integer.parseInt(args[1])];
            int result;

            while ((result = fis.read(bytes)) > 0)
                ArrayUtil.print(bytes, 0, result);
        }
        catch (NumberFormatException ignore) {
            Console.writeErrLine("Invalid block size!...");
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
