/*----------------------------------------------------------------------
	FILE        : IntRange.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.09.2023

	Iterable IntRange class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    public static IntRange of(int min, int bound)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public static IntRange ofClosed(int min, int max)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public static IntRange of(int min, int bound, int step)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public static IntRange ofClosed(int min, int max, int step)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public static IntRange of(int min, int bound, IntUnaryOperator intUnaryOperator)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    public static IntRange ofClosed(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            @Override
            public boolean hasNext()
            {
                throw new UnsupportedOperationException("Not implemented yet!");
            }

            @Override
            public Integer next()
            {
                throw new UnsupportedOperationException("Not implemented yet!");
            }
        };
    }
}