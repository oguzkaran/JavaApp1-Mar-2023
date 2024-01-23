/*----------------------------------------------------------------
	FILE		: IntValue.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 27.05.2023

	IntValue class that wraps an int value and use cache
	for interval [-128, 127]

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.wrapper;

public class IntValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;
    private static final int CACHE_OFFSET = (CACHE_MAX - CACHE_MIN + 1) / 2;
    private static final IntValue [] CACHE = new IntValue[CACHE_MAX - CACHE_MIN + 1];
    private final int m_value;

    public static final IntValue ZERO = of(0);
    public static final IntValue ONE = of(1);
    public static final IntValue TWO = of(2);
    public static final IntValue TEN = of(10);

    private IntValue(int value)
    {
        m_value = value;
    }

    public static IntValue of(int value)
    {
        if (value < CACHE_MIN || CACHE_MAX < value)
            return new IntValue(value);

        if (CACHE[value + CACHE_OFFSET] == null)
            CACHE[value + CACHE_OFFSET] = new IntValue(value);

        return CACHE[value + CACHE_OFFSET];
    }

    public int intValue()
    {
        return m_value;
    }

    public int compareTo(IntValue other)
    {
        return m_value - other.m_value;
    }

    public IntValue add(IntValue value)
    {
        return add(value.m_value);
    }

    public IntValue add(int value)
    {
        return of(m_value + value);
    }

    public IntValue subtract(IntValue value)
    {
        return subtract(value.m_value);
    }

    public IntValue subtract(int value)
    {
        return add(-value);
    }

    public IntValue multiply(IntValue value)
    {
        return multiply(value.m_value);
    }

    public IntValue multiply(int value)
    {
        return of(m_value * value);
    }

    public IntValue divide(IntValue value)
    {
        return divide(value.m_value);
    }

    public IntValue divide(int value)
    {
        return of(m_value / value);
    }

    public IntValue [] divideAndRemainder(IntValue value)
    {
        return divideAndRemainder(value.m_value);
    }

    public IntValue [] divideAndRemainder(int value)
    {
        return new IntValue[] {divide(value), mod(value)};
    }

    public IntValue mod(IntValue value)
    {
        return mod(value.m_value);
    }

    public IntValue mod(int value)
    {
        return of(m_value % value);
    }
    public IntValue inc()
    {
        return add(1);
    }

    public IntValue dec()
    {
        return subtract(1);
    }

    public String toString()
    {
        return String.valueOf(m_value);
    }
}
