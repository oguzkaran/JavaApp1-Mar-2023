package org.csystem.io.image.bitmap;

import org.csystem.io.image.Image;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DIBWindows extends Image {
    private static final long PIXELS_START_OFFSET = 0x0A;
    private static final long WIDTH_OFFSET = 0x12;
    private static final long HEIGHT_OFFSET = 0x16;
    private static final long HORIZONTAL_RESOLUTION_OFFSET = 0x26;
    private static final long VERTICAL_RESOLUTION_OFFSET = 0x2A;

    private final DIBWindowsHeader m_dibWindowsHeader = new DIBWindowsHeader();
    private void readIdentity() throws IOException
    {
        if (imageRaf.read(m_dibWindowsHeader.getIdentity()) != 2)
            throw new IOException("Invalid format!...");
    }

    private void readSizeInBytes() throws IOException
    {
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setSizeOfFile(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readPixelsStartOffset() throws IOException
    {
        imageRaf.seek(PIXELS_START_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setPixelsStartOffset(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readWidth() throws IOException
    {
        imageRaf.seek(WIDTH_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setWidth(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readHeight() throws IOException
    {
        imageRaf.seek(HEIGHT_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setHeight(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readHorizontalResolution() throws IOException
    {
        imageRaf.seek(HORIZONTAL_RESOLUTION_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setHorizontalResolution(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readVerticalResolution() throws IOException
    {
        imageRaf.seek(VERTICAL_RESOLUTION_OFFSET);
        byte [] data = new byte[Integer.BYTES];

        if (imageRaf.read(data) != Integer.BYTES)
            throw new IOException("Invalid format!...");

        m_dibWindowsHeader.setVerticalResolution(ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(0));
    }

    private void readHeader() throws IOException
    {
        readIdentity();
        readSizeInBytes();
        readPixelsStartOffset();
        readWidth();
        readHeight();
        readHorizontalResolution();
        readVerticalResolution();
    }

    private void readImage() throws IOException
    {
        readHeader();
        //...
    }

    public DIBWindows(String path) throws IOException
    {
        super(path);
        readImage();
    }

    public DIBWindowsHeader getDIBWindowsHeader()
    {
        return m_dibWindowsHeader;
    }

    public int getWidth() throws IOException
    {
        return m_dibWindowsHeader.getWidth();
    }

    public int getHeight()
    {
        return m_dibWindowsHeader.getHeight();
    }

    public int getHorizontalResolution()
    {
        return m_dibWindowsHeader.getHorizontalResolution();
    }

    public int getVerticalResolution()
    {
        return m_dibWindowsHeader.getVerticalResolution();
    }

    public byte[] getIdentity()
    {
        return m_dibWindowsHeader.getIdentity();
    }

    public String getIdentityStr()
    {
        byte [] identity = m_dibWindowsHeader.getIdentity();
        return String.valueOf((char)identity[0]) + String.valueOf((char)identity[1]);
    }

    public int getSizeIntBytes()
    {
        return m_dibWindowsHeader.getSizeOfFile();
    }

    public byte[] getReserved1()
    {
        return m_dibWindowsHeader.getReserved1();
    }

    public byte[] getReserved2()
    {
        return m_dibWindowsHeader.getReserved2();
    }

    public long getPixelsStartOffset()
    {
        return m_dibWindowsHeader.getPixelsStartOffset();
    }

    //...
}
