package org.csystem.app.fraction.random;

import org.csystem.math.Fraction;

import java.util.ArrayList;
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

    public ArrayList createFractionList(int min, int bound)
    {
        ArrayList list = new ArrayList();

        try {
            while (true)
                list.add(create(min, bound));
        }
        catch (NumberFormatException ignore) {

        }

        return list;
    }
}
