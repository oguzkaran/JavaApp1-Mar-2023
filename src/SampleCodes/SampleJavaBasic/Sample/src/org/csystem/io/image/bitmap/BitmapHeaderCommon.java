package org.csystem.io.image.bitmap;

public class BitmapHeaderCommon {
    private byte [] m_identity = new byte[2];
    private int m_sizeOfFile;
    private byte [] m_reserved1 = new byte[2];
    private byte [] m_reserved2 = new byte[2];
    private long m_pixelsStartOffset;

    public byte[] getIdentity()
    {
        return m_identity;
    }

    public void setIdentity(byte[] identity)
    {
        m_identity = identity;
    }

    public int getSizeOfFile()
    {
        return m_sizeOfFile;
    }

    public void setSizeOfFile(int sizeOfFile)
    {
        m_sizeOfFile = sizeOfFile;
    }

    public byte[] getReserved1()
    {
        return m_reserved1;
    }

    public void setReserved1(byte[] reserved1)
    {
        m_reserved1 = reserved1;
    }

    public byte[] getReserved2()
    {
        return m_reserved2;
    }

    public void setReserved2(byte[] reserved2)
    {
        m_reserved2 = reserved2;
    }

    public long getPixelsStartOffset()
    {
        return m_pixelsStartOffset;
    }

    public void setPixelsStartOffset(long pixelsStartOffset)
    {
        m_pixelsStartOffset = pixelsStartOffset;
    }

    //...
}
