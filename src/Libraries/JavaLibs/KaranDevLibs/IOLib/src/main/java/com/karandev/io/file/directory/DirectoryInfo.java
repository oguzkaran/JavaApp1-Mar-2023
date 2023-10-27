/*----------------------------------------------------------------------
	FILE        : FileUtil.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 20.06.2021

	DirectoryInfo class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.file.directory;

import com.karandev.io.file.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryInfo extends File {
    private long m_length;

    private boolean fileFilterCallback(File dir, String name)
    {
        return new File(dir, name).isFile();
    }

    private boolean directoryFilterCallback(File dir, String name)
    {
        return new File(dir, name).isDirectory();
    }

    private void calculateLength()
    {
        FileUtil.walkDir(this, file -> m_length += file.length());
    }

    private DirectoryInfo mapCallback(File file)
    {
        DirectoryInfo directoryInfo = null;

        try {
            directoryInfo = new DirectoryInfo(file.getAbsolutePath());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return directoryInfo;
    }

    public DirectoryInfo(String path) throws IOException
    {
        super(path);

        if (!isDirectory())
            throw new IOException("is not a directory");
    }

    public long length()
    {
        m_length = 0;
        this.calculateLength();

        return m_length;
    }

    public List<File> getFiles()
    {
        return Stream.of(Objects.requireNonNull(super.listFiles(this::fileFilterCallback))).collect(Collectors.toList());
    }

    public List<DirectoryInfo> getDirectories()
    {
        return Stream.of(Objects.requireNonNull(this.listFiles(this::directoryFilterCallback)))
                .map(this::mapCallback)
                .collect(Collectors.toList());
    }

    public void walk(Consumer<File> consumer)
    {
        FileUtil.walkDir(this, consumer);
    }

    //...
}
