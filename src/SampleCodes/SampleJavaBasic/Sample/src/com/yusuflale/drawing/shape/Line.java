package com.yusuflale.drawing.shape;

import com.yusuflale.drawing.Color;
import org.csystem.math.geometry.Point;

public class Line extends Shape {
    private final Point m_point1, m_point2;

    public Line(Color color, Point point1, Point point2)
    {
        super(color, color);
        m_point1 = point1;
        m_point2 = point2;
    }

    public String toString()
    {
        return String.format("Line -> Point1:%s, Point2: %s, Color:%s, ", m_point1, m_point2, foregroundColor);
    }
}
