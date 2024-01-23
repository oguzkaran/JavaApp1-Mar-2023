package com.yusuflale.drawing.shape;

import com.yusuflale.drawing.Color;
import org.csystem.math.geometry.Point;

public class Rectangle extends Shape {
    private final Point m_point;
    private final int m_width, m_height;

    public Rectangle(Point point, int width, int height)
    {
        m_point = point;
        m_width = width;
        m_height = height;
    }

    public Rectangle(Color foregroundColor, Color backgroundColor, Point point, int width, int height)
    {
        super(backgroundColor, foregroundColor);
        m_point = point;
        m_width = width;
        m_height = height;
    }

    public String toString()
    {
        return String.format("Rectangle -> Point:%s, Width:%d, Height:%d, Foreground Color:%s, Background Color:%s", m_point,
                m_width, m_height, foregroundColor, backgroundColor);
    }
}
