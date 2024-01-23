/*----------------------------------------------------------
	FILE			: CImage.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 02.12.2023

	CImage class for generaL image operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.io.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CImage {
    private final File m_path;
    private BufferedImage m_bufferedImage;

    public CImage(String path) throws IOException
    {
        this(new File(path));
    }

    public CImage(File path) throws IOException
    {
        if (!path.exists())
            throw new IOException("image not found");

        m_path = path;
        m_bufferedImage = ImageIO.read(m_path);
    }

    public int getWidth()
    {
        return m_bufferedImage.getWidth();
    }

    public int getHeight()
    {
        return m_bufferedImage.getHeight();
    }

    public BufferedImage getBufferedImage()
    {
        return m_bufferedImage;
    }

    public void grayScale()
    {
        int width = m_bufferedImage.getWidth();
        int height = m_bufferedImage.getHeight();

        for (int i = 0; i < width; ++i)
            for (int k = 0; k < height; ++k) {
                Color c = new Color(m_bufferedImage.getRGB(i, k));
                int avg = (int)Math.floor((c.getRed() + c.getGreen() + c.getBlue()) / 3.);

                m_bufferedImage.setRGB(i, k, new Color(avg, avg, avg).getRGB());
            }
    }

    public void binary(int threshold)
    {
        int width = m_bufferedImage.getWidth();
        int height = m_bufferedImage.getHeight();

        for (int i = 0; i < width; ++i)
            for (int k = 0; k < height; ++k) {
                Color c = new Color(m_bufferedImage.getRGB(i, k));

                int value = c.getRed() > threshold ? 255 : 0;

                m_bufferedImage.setRGB(i, k, new Color(value, value, value).getRGB());
            }
    }

    public void save(String output, CImageFormat format) throws IOException
    {
        save(new File(output), format);
    }

    public void save(File output, CImageFormat format) throws IOException
    {
        ImageIO.write(m_bufferedImage, format.toString().toLowerCase(), output);
    }

    public void reset() throws IOException
    {
        m_bufferedImage = ImageIO.read(m_path);
    }

    //...
}
