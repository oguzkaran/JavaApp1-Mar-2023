package org.csystem.io.image;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class Image implements Closeable {
    protected RandomAccessFile imageRaf;

    protected Image(String path) throws IOException
    {
        this.imageRaf = new RandomAccessFile(path, "r");
    }

    public void close() throws IOException
    {
        imageRaf.close();
    }
}
