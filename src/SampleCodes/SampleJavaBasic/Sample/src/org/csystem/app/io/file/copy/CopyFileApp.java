package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class CopyFileApp {
    public static void run(String [] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try (FileInputStream fis = new FileInputStream(args[0])){
            Files.copy(fis, Path.of(args[1]), StandardCopyOption.REPLACE_EXISTING);
            Console.writeLine("Copied successfully...");
        }
        catch (UnsupportedOperationException ex) {
            Console.writeErrLine("UnSupported operation:%s", ex.getMessage());
        }
        catch (NoSuchFileException ex) {
            Console.writeErrLine("'%s' file not exist", ex.getFile());
        }
        catch (SecurityException ex) {
            Console.writeErrLine("Security occurred while opening the file:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.writeErrLine("IO problem occurred while opening the file:%s", ex.getMessage());
        }
        catch (InvalidPathException ex) {
            Console.writeErrLine("'%s' is invalid path", ex.getInput());
        }
    }

    public static void main(String[] args)
    {
        run(args);
    }
}
