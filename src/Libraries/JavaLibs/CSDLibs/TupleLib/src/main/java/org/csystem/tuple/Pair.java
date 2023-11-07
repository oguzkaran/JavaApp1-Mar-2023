/*----------------------------------------------------------------------
	FILE        : Pair.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 07.11.2023

	Immutable Pair class that represents Tuple<F, S>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class Pair<T1, T2> {
    private final T1 m_first;
    private final T2 m_second;

    public static <T1, T2> Pair<T1, T2> of(T1 first, T2 second)
    {
        return new Pair<>(first, second);
    }

    public Pair()
    {
        this(null, null);
    }

    public Pair(T1 first, T2 second)
    {
        m_first = first;
        m_second = second;
    }

    public T1 getFirst()
    {
        return m_first;
    }

    public T2 getSecond()
    {
        return m_second;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Pair<?, ?> p && Objects.equals(p.m_first, m_first) && Objects.equals(p.m_second, m_second);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_first, m_second);
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", m_first, m_second);
    }

}
