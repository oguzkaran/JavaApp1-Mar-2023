package org.csystem.application.io.file.copy;

import org.csystem.util.console.CommandLineUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConcatFiles {
    private File m_destinationFile;
    private Path[] m_sourcePaths;
    private boolean m_success = true;

    private void parseCommandLineArgs(String [] args)
    {
        CommandLineUtil.checkIfLessAndExit(args, 2, "Command line arguments: file1 file2 ... fileN dest");

        m_sourcePaths = new Path[args.length - 1];

        for (int i = 0; i < args.length - 1; ++i) {
            Path path = Path.of(args[i]);
            if (!Files.exists(path)) {
                System.err.printf("%s file not found%n", path);
                m_success = false;
                continue;
            }
            m_sourcePaths[i] = path;
        }
        m_destinationFile = new File(args[args.length - 1]);
    }

    private void concat() throws IOException
    {
        boolean flag = false;

        try (FileOutputStream fos = new FileOutputStream(m_destinationFile)) {
            for (Path path : m_sourcePaths) {
                Files.copy(path, fos);
            }
        }
    }

    public ConcatFiles(String [] args)
    {
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException
    {
        if (m_success)
            this.concat();
    }
}
