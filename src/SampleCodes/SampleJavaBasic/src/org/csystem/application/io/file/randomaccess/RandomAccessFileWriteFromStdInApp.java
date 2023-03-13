package org.csystem.application.io.file.randomaccess;

import java.io.IOException;

import static org.csystem.util.console.CommandLineUtil.checkIfNotEqualAndExit;

public final class RandomAccessFileWriteFromStdInApp {
    private RandomAccessFileWriteFromStdInApp()
    {
    }

    public static void run(String [] args)
    {
        checkIfNotEqualAndExit(args, 1, "Wrong number of arguments");
        try (RandomAccessFileWriteFromStdIn rs = new RandomAccessFileWriteFromStdIn(args[0], "quit", "Input a text:")) {
            rs.run();
        }
        catch (IOException ex) {
            System.err.println("IO error occurs!...");
        }
    }
}
