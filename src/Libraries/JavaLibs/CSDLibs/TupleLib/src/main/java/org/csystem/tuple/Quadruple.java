/*----------------------------------------------------------------------
	FILE        : Quadruple.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 28.09.2023

	Immutable Value class that represents Tuple<T1, T2, T3, T3>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class Quadruple<T1, T2, T3, T4> {
    private final T1 m_first;
    private final T2 m_second;
    private final T3 m_third;
    private final T4 m_fourth;

    public static <T1, T2, T3, T4> Quadruple<T1, T2, T3, T4> of(T1 first, T2 second, T3 third, T4 fourth)
    {
        return new Quadruple<>(first, second, third, fourth);
    }

    public Quadruple()
    {
        this(null, null, null, null);
    }

    public Quadruple(T1 first, T2 second, T3 third, T4 fourth)
    {
        m_first = first;
        m_second = second;
        m_third = third;
        m_fourth = fourth;
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
    public T4 getFourth()
    {
        return m_fourth;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s, %s, %s)", m_first, m_second, m_third, m_fourth);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Quadruple<?, ?, ?, ?> q && Objects.equals(q.m_first, m_first)
                && Objects.equals(q.m_second, m_second) && Objects.equals(q.m_third, m_third)
                && Objects.equals(q.m_fourth, m_fourth);
    }
}
