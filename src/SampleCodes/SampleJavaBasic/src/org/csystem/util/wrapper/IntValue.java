/*----------------------------------------------------------------------
	FILE        : IntValue.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 14.11.2021

	Immutable IntValue class for wrapping an int value by using cache
	for [-128, 127] closed interval

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.wrapper;

public final class IntValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;
    private static final IntValue[] ms_cache = new IntValue[CACHE_MAX - CACHE_MIN + 1];
    private final int m_value;

    private IntValue(int value)
    {
        m_value = value;
    }

    public static final IntValue ZERO = of(0);
    public static final IntValue ONE = of(1);
    public static final IntValue TEN = of(10);

    public static IntValue of(int value)
    {
        if (value < CACHE_MIN || CACHE_MAX < value)
            return new IntValue(value);

        int idx = value + 128;

        if (ms_cache[idx] == null)
            ms_cache[idx] = new IntValue(value);

        return ms_cache[idx];
    }

    public int getValue()
    {
        return m_value;
    }

    public int compareTo(IntValue other)
    {
        return m_value - other.m_value;
    }

    public IntValue add(int value)
    {
        return of(m_value + value);
    }

    public IntValue add(IntValue other)
    {
        return add(other.m_value);
    }

    public IntValue subtract(int value)
    {
        return add(-value);
    }

    public IntValue subtract(IntValue other)
    {
        return subtract(other.m_value);
    }

    public IntValue multiply(int value)
    {
        return of(m_value * value);
    }

    public IntValue multiply(IntValue other)
    {
        return multiply(other.m_value);
    }

    public IntValue divide(int value)
    {
        return of(m_value / value);
    }

    public IntValue divide(IntValue other)
    {
        return divide(other.m_value);
    }

    public IntValue [] divideWithRemainder(int value)
    {
        IntValue [] result = new IntValue[2];
        result[0] = divide(value);
        result[1] = of(m_value % value);

        return result;
    }

    public IntValue [] divideWithRemainder(IntValue other)
    {
        return divideWithRemainder(other.m_value);
    }

    public IntValue increment()
    {
        return add(1);
    }

    public IntValue decrement()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_value + "";
    }
}
