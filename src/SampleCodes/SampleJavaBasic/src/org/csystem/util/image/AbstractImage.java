package org.csystem.util.image;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class AbstractImage implements IIMage, Closeable {
    protected RandomAccessFile imageRaf;

    protected AbstractImage(String path) throws IOException
    {
        imageRaf = new RandomAccessFile(path, "r");
    }
    //...

    public void close() throws IOException
    {
        imageRaf.close();
    }
}
