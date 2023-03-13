package org.csystem.application.io.file;

import java.io.File;

import static org.csystem.util.console.CommandLineUtil.checkIfNotEqualAndExit;

public final class FileDeleteApp {
    private static void listFiles(File dir)
    {
        for (File file : dir.listFiles())
            System.out.println(file.delete() ? "Success" : "Fail");
    }

    private FileDeleteApp()
    {}

    public static void run(String [] args)
    {
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
