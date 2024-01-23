package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.*;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthGreater;

public class CopyNotExistFilesApp {
    private static void copyFiles(Path dir, String [] args) throws IOException
    {
        for (int i = 1; i < args.length; ++i)
            try {
                Files.copy(Path.of(args[i]), Path.of(dir.toString(), args[i]));
            }
            catch (FileAlreadyExistsException ex) {
                Console.writeErrLine("'%s' file already exists", ex.getFile());
            }
            catch (NoSuchFileException ex) {
                Console.writeErrLine("'%s' file not exist", ex.getFile());
            }
            catch (InvalidPathException ex) {
                Console.writeErrLine("'%s' is invalid path", ex.getInput());
            }
    }

    public static void run(String [] args)
    {
        checkLengthGreater(args.length, 2, "Wrong number of arguments!...");

        try {
            Path dir = Path.of(args[0]);

            if (Files.exists(dir)) {
                if (!Files.isDirectory(dir)) {
                    Console.writeErrLine("'%s' must be a directory", dir);
                    return;
                }
            }
            else
                Files.createDirectories(dir);

            copyFiles(dir, args);
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
