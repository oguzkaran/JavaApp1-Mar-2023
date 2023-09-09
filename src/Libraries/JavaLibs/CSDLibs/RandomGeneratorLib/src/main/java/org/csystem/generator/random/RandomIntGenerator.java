/*----------------------------------------------------------------------
	FILE        : RandomIntGenerator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 09.09.2023

	Iterable RandomIntGenerator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator.random;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

public class RandomIntGenerator implements Iterable<Integer> {
    private final RandomGenerator m_randomGenerator;
    private final int m_count;
    private final int m_min;

    private final int m_bound;

    private RandomIntGenerator(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        m_randomGenerator = randomGenerator;
        m_count = count;
        m_min = min;
        m_bound = bound;
    }

    public static RandomIntGenerator of(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return new RandomIntGenerator(randomGenerator, count, min, bound);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            @Override
            public boolean hasNext()
            {
               throw new UnsupportedOperationException("");
            }

            @Override
            public Integer next()
            {
                throw new UnsupportedOperationException("");
            }
        };
    }
}
