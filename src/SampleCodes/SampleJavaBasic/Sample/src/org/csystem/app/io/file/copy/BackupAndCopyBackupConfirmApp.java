package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.csystem.util.console.commandline.CommandLineArgsUtil.checkLengthEquals;

public class BackupAndCopyBackupConfirmApp {
    private static void checkIfDirectory(Path srcPath, Path destPath)
    {
        if (Files.isDirectory(srcPath) || Files.isDirectory(destPath)) {
            Console.writeErrLine("Source and/or destination can not be a directory!...");
            System.exit(0);
        }
    }

    private static void backupAndCopy(Path srcPath, Path destPath) throws IOException
    {
        checkIfDirectory(srcPath, destPath);
        BackupAndCopyBackupConfirm backupAndCopy = new BackupAndCopyBackupConfirm(srcPath, destPath, "-bak", "Backup file exist. Do you want to overwrite?");

        backupAndCopy.doCopy();
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 2, "Wrong number of arguments!...");

        try {
            backupAndCopy(Path.of(args[0]), Path.of(args[1]));
        }

        catch (NoSuchFileException ex) {
            Console.writeErrLine("'%s file not exist", ex.getFile());
        }
        catch (IOException ignore) {
            Console.writeErrLine("I/O problem occurs!...");
        }
        catch (SecurityException ignore) {
            Console.writeErrLine("Security problem occurs!...");
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
