package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;
import org.csystem.util.io.IOUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class CopyFileViaBlockApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 3, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0]); FileOutputStream fos = new FileOutputStream(args[1])){
            IOUtil.copyAndClose(fis, fos, Integer.parseInt(args[2]));
            Console.writeLine("Copied successfully...");
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
