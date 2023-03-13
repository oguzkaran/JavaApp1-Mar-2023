package org.csystem.application.io.file.filecompare;

import org.csystem.util.console.CommandLineUtil;
import org.csystem.util.io.file.FileUtil;

import java.io.IOException;

public class FileCompareApp {
    public static void run(String [] args)
    {
        CommandLineUtil.checkIfNotEqualAndExit(args, 2, "Wrong number of arguments");
        try {
            System.out.println(FileUtil.areSame(args[0], args[1]) ? "Equal" : "Not equal");
        }
        catch (IOException ignore) {
            System.err.println("IO Error");
        }
    }
}
