/*----------------------------------------------------------------
	FILE		: LongValue.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 27.05.2023

	LongValue class that wraps a long value and use cache
	for interval [-128, 127]

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.wrapper;

public class LongValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;
    private static final int CACHE_OFFSET = (CACHE_MAX - CACHE_MIN + 1) / 2;
    private static final LongValue[] CACHE = new LongValue[CACHE_MAX - CACHE_MIN + 1];
    private final long m_value;

    public static final LongValue ZERO = of(0);
    public static final LongValue ONE = of(1);
    public static final LongValue TWO = of(2);
    public static final LongValue TEN = of(10);

    private LongValue(long value)
    {
        m_value = value;
    }

    public static LongValue of(long value)
    {
        if (value < CACHE_MIN || CACHE_MAX < value)
            return new LongValue(value);

        if (CACHE[(int)value + CACHE_OFFSET] == null)
            CACHE[(int)value + CACHE_OFFSET] = new LongValue(value);

        return CACHE[(int)value + CACHE_OFFSET];
    }

    public long longValue()
    {
        return m_value;
    }

    public int compareTo(LongValue other)
    {
        if (m_value < other.m_value)
            return -1;

        if (other.m_value < m_value)
            return 1;

        return 0;
    }

    public LongValue add(LongValue value)
    {
        return add(value.m_value);
    }

    public LongValue add(long value)
    {
        return of(m_value + value);
    }

    public LongValue subtract(LongValue value)
    {
        return subtract(value.m_value);
    }

    public LongValue subtract(long value)
    {
        return add(-value);
    }

    public LongValue multiply(LongValue value)
    {
        return multiply(value.m_value);
    }

    public LongValue multiply(long value)
    {
        return of(m_value * value);
    }

    public LongValue divide(LongValue value)
    {
        return divide(value.m_value);
    }

    public LongValue divide(long value)
    {
        return of(m_value / value);
    }

    public LongValue[] divideAndRemainder(LongValue value)
    {
        return divideAndRemainder(value.m_value);
    }

    public LongValue[] divideAndRemainder(long value)
    {
        return new LongValue[] {divide(value), mod(value)};
    }

    public LongValue mod(LongValue value)
    {
        return mod(value.m_value);
    }

    public LongValue mod(long value)
    {
        return of(m_value % value);
    }
    public LongValue inc()
    {
        return add(1);
    }

    public LongValue dec()
    {
        return subtract(1);
    }

    public String toString()
    {
        return String.valueOf(m_value);
    }
}
