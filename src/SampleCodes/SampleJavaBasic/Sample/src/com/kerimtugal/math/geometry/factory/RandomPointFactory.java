package com.kerimtugal.math.geometry.factory;

import org.csystem.math.geometry.Point;

import java.util.Random;

public class RandomPointFactory {
    private final Random m_random;

    public RandomPointFactory()
    {
        this(new Random());
    }

    public RandomPointFactory(Random random)
    {
        m_random = random;
    }

    public Point create(double min, double bound)
    {
        if (min >= bound)
            return null;

        return Point.ofCartesian(m_random.nextDouble(min, bound), m_random.nextDouble(min,  bound));
    }
}
