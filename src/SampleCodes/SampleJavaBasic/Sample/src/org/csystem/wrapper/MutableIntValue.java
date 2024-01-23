/*----------------------------------------------------------------
	FILE		: MutableIntValue.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 26.06.2023

	MutableIntValue class that wraps an int value

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.wrapper;

public class MutableIntValue {
    private int m_value;

    private MutableIntValue(int value)
    {
        m_value = value;
    }
    public static MutableIntValue of(int value)
    {
        return new MutableIntValue(value);
    }

    public static MutableIntValue of()
    {
        return of(0);
    }

    public int getValue()
    {
        return m_value;
    }

    public MutableIntValue add(int value)
    {
        m_value += value;

        return this;
    }

    public MutableIntValue add(MutableIntValue other)
    {
        return add(other.m_value);
    }

    public MutableIntValue subtract(int value)
    {
        return add(-value);
    }

    public MutableIntValue subtract(MutableIntValue other)
    {
        return subtract(other.m_value);
    }

    public MutableIntValue multiply(int value)
    {
        m_value *= value;

        return this;
    }

    public MutableIntValue multiply(MutableIntValue other)
    {
        return multiply(other.m_value);
    }

    public MutableIntValue divide(int value)
    {
        m_value /= value;

        return this;
    }

    public MutableIntValue divide(MutableIntValue other)
    {
        return divide(other.m_value);
    }

    public MutableIntValue mod(int value)
    {
        m_value %= value;

        return this;
    }

    public MutableIntValue mod(MutableIntValue other)
    {
        return mod(other.m_value);
    }
    //...
}
