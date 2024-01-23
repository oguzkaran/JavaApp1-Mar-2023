package org.csystem.app.io.file.join;

import org.csystem.util.console.Console;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class ConcatFilesApp {
    public static void run(String [] args)
    {
        checkLengthGreater(args.length, 1, "Wrong number of arguments!...");

        File file = new File(args[args.length - 1]);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (int i = 0; i < args.length - 1; ++i)
                Files.copy(Path.of(args[i]), fos);
        }
        catch (UnsupportedOperationException ex) {
            Console.writeErrLine("UnSupported operation:%s", ex.getMessage());
        }
        catch (NoSuchFileException ex) {
            Console.writeErrLine("'%s' file not exist", ex.getFile());
            file.delete();
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
