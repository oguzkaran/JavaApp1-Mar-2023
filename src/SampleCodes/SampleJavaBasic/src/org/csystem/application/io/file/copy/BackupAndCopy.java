package org.csystem.application.io.file.copy;

import java.io.IOException;
import java.nio.file.*;

public class BackupAndCopy {
    private final Path m_sourcePath;
    private final Path m_destinationPath;

    private String copy(String message) throws IOException
    {
        Files.copy(m_sourcePath, m_destinationPath);

        return message;
    }

    private String copy() throws IOException
    {
        try {
            return this.copy("Copied successfully");
        }
        catch (FileAlreadyExistsException ignore) {
            return this.backupAndCopy();
        }
    }

    private String backupAndCopy() throws IOException
    {
        Files.move(m_destinationPath, Path.of(m_destinationPath+ "-bak"), StandardCopyOption.REPLACE_EXISTING);
        return this.copy("Copied and backed up successfully...");
    }

    public BackupAndCopy(String sourcePath, String destinationPath)
    {
        this(Path.of(sourcePath), Path.of(destinationPath));
    }

    public BackupAndCopy(Path sourcePath, Path destinationPath)
    {
        m_sourcePath = sourcePath;
        m_destinationPath = destinationPath;
    }

    public String run() throws IOException
    {
        return this.copy();
    }
}
