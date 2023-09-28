package org.csystem.math.factory;

import org.csystem.math.geometry.AnalyticalCircle;
import org.csystem.math.geometry.Circle;

import java.util.random.RandomGenerator;

public class RandomCircleFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomCircleFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Circle createCircle(double min, double bound)
    {
       return new Circle(m_randomGenerator.nextDouble(min, bound));
    }

    public Circle createCircle(int min, int bound)
    {
        return new Circle(m_randomGenerator.nextInt(min, bound));
    }

    public AnalyticalCircle createAnalyticalCircle(double min, double bound)
    {
        return new AnalyticalCircle(m_randomGenerator.nextDouble(min, bound),
                                    m_randomGenerator.nextDouble(min, bound),
                                    m_randomGenerator.nextDouble(min, bound));
    }
    public AnalyticalCircle createAnalyticalCircle(int min, int bound)
    {
        return new AnalyticalCircle(m_randomGenerator.nextInt(min, bound),
                                    m_randomGenerator.nextInt(min, bound),
                                    m_randomGenerator.nextInt(min, bound));
    }
}
