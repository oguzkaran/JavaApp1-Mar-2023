package org.csystem.application.io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    private final Path m_sourcePath;
    private final Path m_destinationPath;

    private String copy() throws IOException
    {
        Files.copy(m_sourcePath, m_destinationPath, StandardCopyOption.REPLACE_EXISTING);

        return "Copied successfully";

    }

    public CopyFile(String sourcePath, String destinationPath)
    {
        m_sourcePath = Path.of(sourcePath);
        m_destinationPath = Path.of(destinationPath);
    }

    public String run() throws IOException
    {
        return this.copy();
    }
}
