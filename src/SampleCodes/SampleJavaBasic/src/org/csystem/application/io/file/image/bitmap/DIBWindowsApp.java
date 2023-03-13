package org.csystem.application.io.file.image.bitmap;

import org.csystem.util.console.CommandLineUtil;
import org.csystem.util.image.bitmap.DIBWindows;

import java.io.IOException;

public final class DIBWindowsApp {
    public static void run(String [] args)
    {
        CommandLineUtil.checkIfNotEqualAndExit(args, 1, "Wrong number of arguments");

        try (DIBWindows dw = new DIBWindows(args[0])) {
            System.out.printf("%d x %d%n", dw.getWidth(), dw.getHeight());
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("IO Error occurs");
        }
    }
}
