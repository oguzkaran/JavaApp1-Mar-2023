package org.csystem.math.factory;

import org.csystem.math.Fraction;

import java.util.random.RandomGenerator;

public class RandomFractionFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomFractionFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public Fraction create(int min, int bound)
    {
        return new Fraction(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound));
    }
}
