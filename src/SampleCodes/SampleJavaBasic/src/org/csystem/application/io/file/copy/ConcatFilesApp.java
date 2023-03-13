package org.csystem.application.io.file.copy;

import java.io.IOException;

public class ConcatFilesApp {
    public static void run(String [] args)
    {
        try {
            ConcatFiles cf = new ConcatFiles(args);

            cf.run();
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
