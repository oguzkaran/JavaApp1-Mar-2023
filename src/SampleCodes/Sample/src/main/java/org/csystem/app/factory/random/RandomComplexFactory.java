package org.csystem.app.factory.random;

import org.csystem.math.Complex;

import java.util.ArrayList;
import java.util.List;
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

    public List<Complex> createUntil(int min, int bound)
    {
        return createUntil(new Complex(), min, bound);
    }

    public List<Complex> createUntil(Complex until, int min, int bound)
    {
        var list = new ArrayList<Complex>();
        Complex z;

        while (!(z = create(min, bound)).equals(until))
            list.add(z);

        return list;
    }
}
