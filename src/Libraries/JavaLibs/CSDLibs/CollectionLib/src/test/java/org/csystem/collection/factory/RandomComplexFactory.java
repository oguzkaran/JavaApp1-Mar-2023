package org.csystem.collection.factory;

import org.csystem.math.Complex;

import java.util.random.RandomGenerator;

public class RandomComplexFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomComplexFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Complex create(int min, int bound)
    {
        return new Complex(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound));
    }

    public Complex create(double min, double bound)
    {
        return new Complex(m_randomGenerator.nextDouble(min, bound), m_randomGenerator.nextDouble(min, bound));
    }
}
