package org.csystem.app.factory.random;

import org.csystem.math.Fraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.random.RandomGenerator;

public class RandomFractionFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomFractionFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public List<Fraction> createUntilInvalid(int min, int bound)
    {
        var fractions = new ArrayList<Fraction>();

        try {
            while (true)
                fractions.add(new Fraction(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound)));
        }
        catch (NumberFormatException ignore) {

        }

        return fractions;
    }
}
