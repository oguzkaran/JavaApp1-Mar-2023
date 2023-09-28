/*----------------------------------------------------------------------
	FILE        : Triple.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 28.09.2023

	Immutable Value class that represents Tuple<F, S, T>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class Triple<T1, T2, T3> {
    private final T1 m_first;
    private final T2 m_second;
    private final T3 m_third;

    public static <T1, T2, T3> Triple<T1, T2, T3> of(T1 first, T2 second, T3 third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple()
    {
        this(null, null, null);
    }

    public Triple(T1 first, T2 second, T3 third)
    {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public T1 getFirst()
    {
        return m_first;
    }

    public T2 getSecond()
    {
        return m_second;
    }

    public T3 getThird()
    {
        return m_third;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s, %s)", m_first, m_second, m_third);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Triple<?, ?, ?> t && Objects.equals(t.m_first, m_first)
                && Objects.equals(t.m_second, m_second) && Objects.equals(t.m_third, m_third);
    }
}
