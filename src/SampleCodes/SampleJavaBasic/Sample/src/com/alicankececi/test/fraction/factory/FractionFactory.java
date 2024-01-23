package com.alicankececi.test.fraction.factory;

import org.csystem.math.Fraction;

import java.util.Random;
import java.util.random.RandomGenerator;

public class FractionFactory {
    private final RandomGenerator m_random = new Random();
    public Fraction createRandomFraction(int min, int bound)
    {
        return new Fraction(m_random.nextInt(min, bound), m_random.nextInt(min, bound));
    }
}
