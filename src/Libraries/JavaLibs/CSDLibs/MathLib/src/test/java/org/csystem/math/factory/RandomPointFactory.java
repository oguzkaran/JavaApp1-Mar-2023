package org.csystem.math.factory;

import org.csystem.math.geometry.MutablePoint;
import org.csystem.math.geometry.Point;

import java.util.random.RandomGenerator;

public class RandomPointFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomPointFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Point createPoint(int min, int bound)
    {
        return Point.createCartesian(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound));
    }

    public Point createPoint(double min, double bound)
    {
        return Point.createCartesian(m_randomGenerator.nextDouble(min, bound), m_randomGenerator.nextDouble(min, bound));
    }

    public MutablePoint createMutablePoint(int min, int bound)
    {
        return MutablePoint.createCartesian(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound));
    }

    public MutablePoint createMutablePoint(double min, double bound)
    {
        return MutablePoint.createCartesian(m_randomGenerator.nextDouble(min, bound), m_randomGenerator.nextDouble(min, bound));
    }
}
