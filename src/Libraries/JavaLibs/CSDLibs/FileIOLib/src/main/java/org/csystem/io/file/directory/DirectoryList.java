/*----------------------------------------------------------------------
	FILE        : DirectoryList.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 19.09.2023

	Iterable DirectoryList class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.io.file.directory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DirectoryList implements Iterable<File> {
    private final File [] m_files;

    public DirectoryList(String path) throws IOException
    {
        this(Path.of(path));
    }

    public DirectoryList(Path path) throws IOException
    {
        if (Files.exists(path) && !Files.isDirectory(path))
            throw new NotDirectoryException(String.format("'%s' is not a directory!...", path));

        m_files = new File(path.toString()).listFiles();

        if (m_files == null)
            throw new IOException("IO problem occurs!...");
    }

    @Override
    public Iterator<File> iterator()
    {
        return new Iterator<>() {
            int index;

            @Override
            public boolean hasNext()
            {
                return index + 1 < m_files.length;
            }

            @Override
            public File next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("");

                return m_files[index++];
            }
        };
    }
}
