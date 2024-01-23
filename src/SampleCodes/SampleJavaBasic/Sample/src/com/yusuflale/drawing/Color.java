package com.yusuflale.drawing;

import java.io.Serial;
import java.io.Serializable;

public class Color implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;

    private final byte m_alpha, m_red, m_green, m_blue;

    private Color(byte alpha, byte red, byte green, byte blue)
    {
        m_alpha = alpha;
        m_red = red;
        m_green = green;
        m_blue = blue;
    }

    public static final Color RED = fromRGB((byte)255, (byte)0, (byte)0);
    public static final Color GREEN = fromRGB((byte)0, (byte)255, (byte)0);
    public static final Color BLUE = fromRGB((byte)0, (byte)0, (byte)255);
    public static final Color WHITE = fromRGB((byte)255, (byte)255, (byte)255);
    public static final Color BLACK = fromRGB((byte)0, (byte)0, (byte)0);

    public static Color fromARGB(byte alpha, byte red, byte green, byte blue)
    {
        return new Color(alpha, red, green, blue);
    }

    public static Color fromRGB(byte red, byte green, byte blue)
    {
        return fromARGB((byte)0, red, green, blue);
    }

    public byte getAlpha()
    {
        return m_alpha;
    }

    public byte getRed()
    {
        return m_red;
    }

    public byte getGreen()
    {
        return m_green;
    }

    public byte getBlue()
    {
        return m_blue;
    }

    public String toString()
    {
        return String.format("(%d, %d, %d)", m_red, m_green, m_blue);
    }
}