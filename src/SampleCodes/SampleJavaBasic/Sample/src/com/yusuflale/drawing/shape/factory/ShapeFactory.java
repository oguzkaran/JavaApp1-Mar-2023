package com.yusuflale.drawing.shape.factory;

import com.yusuflale.drawing.Color;
import com.yusuflale.drawing.shape.Ellipse;
import com.yusuflale.drawing.shape.Line;
import com.yusuflale.drawing.shape.Rectangle;
import com.yusuflale.drawing.shape.Shape;
import org.csystem.math.geometry.Point;

import java.util.Random;
import java.util.random.RandomGenerator;

public class ShapeFactory {
    private final RandomGenerator m_randomGenerator = new Random();

    public Shape createShape()
    {
        Color fgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
        return switch (m_randomGenerator.nextInt(3)) {
            case 0 -> {
                Color bgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Point point = Point.ofCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));

                yield new Rectangle(fgColor, bgColor, point, m_randomGenerator.nextInt(100),  m_randomGenerator.nextInt(100));
            }
            case 1 -> {
                Color bgColor = Color.fromRGB((byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256), (byte)m_randomGenerator.nextInt(256));
                Point point = Point.ofCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));

                yield new Ellipse(fgColor, bgColor, point, m_randomGenerator.nextInt(100),  m_randomGenerator.nextInt(100));
            }
            default -> {
                Point point1 = Point.ofCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));
                Point point2 = Point.ofCartesian(m_randomGenerator.nextInt(-100, 100), m_randomGenerator.nextInt(-100, 100));
                yield new Line(fgColor, point1, point2);
            }
        };
    }
}
