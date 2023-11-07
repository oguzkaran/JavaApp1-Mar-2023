/*----------------------------------------------------------------------
	FILE        : Value.java
	AUTHOR      : JavaApp1-Mar-2023-Group
	LAST UPDATE : 07.11.2023

	Immutable Value class that represents Tuple<T>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.tuple;

import java.util.Objects;

public final class Value<T> {
    private final T m_value;

    public static <T> Value<T> of(T val)
    {
        return new Value<>(val);
    }

    public Value()
    {
        m_value = null;
    }

    public Value(T value)
    {
        m_value = value;
    }

    public T getValue()
    {
        return m_value;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Value<?> p && Objects.equals(p.m_value, m_value);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(m_value);
    }

    @Override
    public String toString()
    {
        return m_value + "";
    }
}
