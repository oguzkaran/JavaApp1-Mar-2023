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

public class AppendFoundFilesApp {
    private static void appendFiles(FileOutputStream fos, String path) throws IOException
    {
        try {
            Files.copy(Path.of(path), fos);
        }
        catch (NoSuchFileException ex) {
            Console.writeErrLine("'%s' file not exist", ex.getFile());
        }
    }

    public static void run(String [] args)
    {
        checkLengthGreater(args.length, 1, "Wrong number of arguments!...");

        File file = new File(args[args.length - 1]);

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            for (int i = 0; i < args.length - 1; ++i)
                appendFiles(fos, args[i]);
        }
        catch (UnsupportedOperationException ex) {
            Console.writeErrLine("UnSupported operation:%s", ex.getMessage());
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
