/*----------------------------------------------------------------------
	FILE        : Pair.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 28.09.2023

	Immutable Pair class that represents Tuple<F, S>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class Pair<F, S> {
    private final F m_first;
    private final S m_second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair()
    {
        m_first = null;
        m_second = null;
    }

    public Pair(F first, S second)
    {
        m_first = first;
        m_second = second;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", m_first, m_second);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Pair<?, ?> p && Objects.equals(p.m_first, m_first) && Objects.equals(p.m_second, m_second);
    }
}
