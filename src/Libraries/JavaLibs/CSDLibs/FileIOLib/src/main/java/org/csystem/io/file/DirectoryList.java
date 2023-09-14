/*----------------------------------------------------------------------
	FILE        : DirectoryList.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 14.09.2023

	Iterable DirectoryList class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;

public class DirectoryList implements Iterable<File> {

    public DirectoryList(String path) throws IOException
    {
        this(Path.of(path));
    }

    public DirectoryList(Path path) throws IOException
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterator<File> iterator()
    {
        return new Iterator<>() {
            @Override
            public boolean hasNext()
            {
                throw new UnsupportedOperationException("Not implemented yet");
            }

            @Override
            public File next()
            {
                throw new UnsupportedOperationException("Not implemented yet");
            }
        };
    }
}
