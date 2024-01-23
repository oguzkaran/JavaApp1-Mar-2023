package org.csystem.app.io.file.copy;

import org.csystem.util.console.Console;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class BackupAndCopyBackupConfirm {
    private final Path m_srcPath;
    private final Path m_destPath;
    private final String m_suffix;

    private final String m_confirmPrompt;

    private char confirmOption()
    {
        while (true) {
            char option = Console.readChar(m_confirmPrompt);

            if (option == 'Y' || option == 'N' || option == 'y' || option == 'n')
                return option;
        }
    }

    private void doForBackupFileExists() throws NoSuchFileException, IOException
    {
        var option = confirmOption();

        if (option == 'Y' || option == 'y')
            backupAndCopy();
        else
            Files.copy(m_srcPath, m_destPath, StandardCopyOption.REPLACE_EXISTING);

    }
    private void copy() throws NoSuchFileException, IOException
    {
        try {
            Files.copy(m_srcPath, m_destPath);
        }
        catch (FileAlreadyExistsException ignore) {
            if (new File(m_destPath + m_suffix).exists())
                doForBackupFileExists();
            else
                backupAndCopy();

        }
    }

    private void backupAndCopy() throws IOException
    {
        Files.move(m_destPath, Path.of(m_destPath + m_suffix), StandardCopyOption.REPLACE_EXISTING);
        copy();
    }

    public BackupAndCopyBackupConfirm(Path srcPath, Path destPath, String suffix, String confirmPrompt)
    {
        m_srcPath = srcPath;
        m_destPath = destPath;
        m_suffix = suffix;
        m_confirmPrompt = confirmPrompt;
    }

    public void doCopy() throws IOException
    {
        copy();
    }
}
