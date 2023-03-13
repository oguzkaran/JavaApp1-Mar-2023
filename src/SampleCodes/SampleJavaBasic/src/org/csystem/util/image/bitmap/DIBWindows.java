package org.csystem.util.image.bitmap;

import org.csystem.util.image.AbstractImage;
import org.csystem.util.image.IIMage;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DIBWindows extends AbstractImage implements IIMage, Closeable {
    private static final long WIDTH_OFFSET = 18;
    private static final long HEIGHT_OFFSET = 22;

    public DIBWindows(String path) throws IOException
    {
        super(path);
    }

    public int getHeight() throws IOException
    {
        imageRaf.seek(HEIGHT_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        imageRaf.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public int getWidth() throws IOException
    {
        imageRaf.seek(WIDTH_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        imageRaf.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    //...
}
