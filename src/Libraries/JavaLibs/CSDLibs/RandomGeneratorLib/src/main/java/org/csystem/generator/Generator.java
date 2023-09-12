/*----------------------------------------------------------------------
	FILE        : Generator.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.09.2023

	Iterable Generator class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.generator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Generator<T> implements Iterable<T> {
    private final Supplier<T> m_supplier;
    private final long m_count;

    private Generator(Supplier<T> supplier, long count)
    {
        m_supplier = supplier;
        m_count = count;
    }

    public static <T> Generator<T> of(Supplier<T> supplier, long count)
    {
        return new Generator<>(supplier, count);
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<>() {
            int count;
            @Override
            public boolean hasNext()
            {
                return count + 1 <= m_count;
            }

            @Override
            public T next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                ++count;
                return m_supplier.get();
            }
        };
    }
}
