/*----------------------------------------------------------------------
	FILE        : IntPair.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 07.11.2023

	Immutable Pair class that represents Int tuple

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class IntPair {
    private final int m_first;
    private final int m_second;

    public static IntPair of(int first, int second)
    {
        return new IntPair(first, second);
    }

    public IntPair()
    {
        this(0, 0);
    }

    public IntPair(int first, int second)
    {
        m_first = first;
        m_second = second;
    }

    public int getFirst()
    {
        return m_first;
    }

    public int getSecond()
    {
        return m_second;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof IntPair p && Objects.equals(p.m_first, m_first) && Objects.equals(p.m_second, m_second);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(m_first, m_second);
    }

    @Override
    public String toString()
    {
        return String.format("(%d, %d)", m_first, m_second);
    }
}
