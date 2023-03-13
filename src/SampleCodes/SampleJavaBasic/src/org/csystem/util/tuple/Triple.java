/*----------------------------------------------------------------------
	FILE        : Triple.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 21.01.2022

	Immutable Value class that represents Tuple<F, S, T>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.tuple;

public final class Triple<F, S, T> {
    private final F m_first;
    private final S m_second;
    private final T m_third;

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple()
    {
        m_first = null;
        m_second = null;
        m_third = null;
    }

    public Triple(F first, S second, T third)
    {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    public T getThird()
    {
        return m_third;
    }

    public String toString()
    {
        return String.format("(%s, %s, %s)", m_first, m_second, m_third);
    }

    //...
}
