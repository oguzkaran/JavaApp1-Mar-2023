package org.csystem.io.image.bitmap;

public class DIBWindowsHeader extends BitmapHeaderCommon {
    private int m_sizeOfHeader;
    private int m_width;
    private int m_height;
    //...
    private int m_horizontalResolution;
    private int m_verticalResolution;

    public int getSizeOfHeader()
    {
        return m_sizeOfHeader;
    }

    public void setSizeOfHeader(int sizeOfHeader)
    {
        m_sizeOfHeader = sizeOfHeader;
    }

    public int getWidth()
    {
        return m_width;
    }

    public void setWidth(int width)
    {
        m_width = width;
    }

    public int getHeight()
    {
        return m_height;
    }

    public void setHeight(int height)
    {
        m_height = height;
    }

    public int getHorizontalResolution()
    {
        return m_horizontalResolution;
    }

    public void setHorizontalResolution(int horizontalResolution)
    {
        m_horizontalResolution = horizontalResolution;
    }

    public int getVerticalResolution()
    {
        return m_verticalResolution;
    }

    public void setVerticalResolution(int verticalResolution)
    {
        m_verticalResolution = verticalResolution;
    }
}