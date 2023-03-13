package org.csystem.application.io.file.copy;

import org.csystem.util.console.CommandLineUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class CopyFileApp {
    private static String [] checkCommandLineArgs(String [] args)
    {
        if (args.length != 2 && args.length != 0) {
            System.err.println("Usage: java org.csystem.application.io.file.copyfile.App <src> <dest> <block size>");
            System.exit(1);
        }

        return CommandLineUtil.getArguments(args, "Input source and destination file paths:");
    }

    public static void run(String [] args)
    {
        args = checkCommandLineArgs(args);

        try {
            CopyFile copyFile = new CopyFile(args[0], args[1]);

            System.out.println(copyFile.run());
        }
        catch (FileNotFoundException ignore) {
            System.err.println("File not found");
        }
        catch (IOException ignore) {
            System.err.println("Invalid arguments");
        }
    }
}
