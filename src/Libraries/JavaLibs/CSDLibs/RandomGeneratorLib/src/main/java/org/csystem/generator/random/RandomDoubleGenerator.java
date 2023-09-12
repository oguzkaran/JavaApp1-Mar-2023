/*----------------------------------------------------------------------
	FILE        : RandomDoubleGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.09.2023

	Iterable RandomDoubleGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomDoubleGenerator implements Iterable<Double> {
    private final RandomGenerator m_randomGenerator;
    private final int m_count;
    private final double m_min;
    private final double m_bound;

    private RandomDoubleGenerator(RandomGenerator randomGenerator, int count, double min, double bound)
    {
        m_randomGenerator = randomGenerator;
        m_count = count;
        m_min = min;
        m_bound = bound;
    }

    public static RandomDoubleGenerator of(RandomGenerator randomGenerator, int count, double min, double bound)
    {
        return new RandomDoubleGenerator(randomGenerator, count, min, bound);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            int count;

            @Override
            public boolean hasNext()
            {
                return count + 1 <= m_count;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value!...");

                ++count;

                return m_randomGenerator.nextDouble(m_min, m_bound);
            }
        };
    }
}
