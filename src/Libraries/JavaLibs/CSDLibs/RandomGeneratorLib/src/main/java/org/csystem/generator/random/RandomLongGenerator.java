/*----------------------------------------------------------------------
	FILE        : RandomLongGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.09.2023

	Iterable RandomLongGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomLongGenerator implements Iterable<Long> {
    private final RandomGenerator m_randomGenerator;
    private final int m_count;
    private final long m_min;
    private final long m_bound;

    private RandomLongGenerator(RandomGenerator randomGenerator, int count, long min, long bound)
    {
        m_randomGenerator = randomGenerator;
        m_count = count;
        m_min = min;
        m_bound = bound;
    }

    public static RandomLongGenerator of(RandomGenerator randomGenerator, int count, long min, long bound)
    {
        return new RandomLongGenerator(randomGenerator, count, min, bound);
    }

    @Override
    public Iterator<Long> iterator()
    {
        return new Iterator<>() {
            int count;

            @Override
            public boolean hasNext()
            {
                return count + 1 <= m_count;
            }

            @Override
            public Long next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("Can not generate a value!...");

                ++count;

                return m_randomGenerator.nextLong(m_min, m_bound);
            }
        };
    }
}
