package org.csystem.io.file.directory;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;

@Ignore
public class DirectoryListTest {
    private void directoryListCallback(File file)
    {
        System.out.printf("%s %s%n", file.getName(), file.isDirectory() ? "<DIR>" : file.length());
    }

    @Test
    public void givenPath_whenCurrentDirectory_thenList() throws IOException
    {
        var dirList = new DirectoryList(".");

        dirList.forEach(this::directoryListCallback);
    }

    @Test
    public void givenPath_whenNotDirectory_thenThrowsNotDirectoryException()
    {
        Assert.assertThrows(NotDirectoryException.class, () -> new DirectoryList("pom.xml").forEach(this::directoryListCallback));
    }

    @Test
    public void givenPath_whenNotFound_thenThrowsIOException()
    {
        Assert.assertThrows(IOException.class, () -> new DirectoryList("./pom.xmll").forEach(this::directoryListCallback));
    }
}
