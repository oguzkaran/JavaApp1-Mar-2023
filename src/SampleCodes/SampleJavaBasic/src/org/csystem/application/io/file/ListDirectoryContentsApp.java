package org.csystem.application.io.file;

import java.io.File;

import static org.csystem.util.console.CommandLineUtil.checkIfNotEqualAndExit;
import static org.csystem.util.console.CommandLineUtil.getArguments;

public final class ListDirectoryContentsApp {
    private static void listFiles(File dir)
    {
        String postfix = "";

        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                postfix = " <DIR>";
            else if (file.isFile())
                postfix = String.format(" %d bytes", file.length());

            System.out.printf("%s%s%n", file.getName(), postfix);
        }
    }

    private ListDirectoryContentsApp()
    {}

    public static void run(String [] args)
    {
        args = getArguments(args, "Input directory path:");
        checkIfNotEqualAndExit(args, 1, "Wrong number of arguments");

        File dir = new File(args[0]);

        if (dir.exists()) {
            if (dir.isDirectory())
                listFiles(dir);
            else
                System.out.printf("'%s' not directory%n", dir.getAbsolutePath());
        }
        else
            System.out.printf("'%s' not exists%n", dir.getAbsolutePath());

    }
}
