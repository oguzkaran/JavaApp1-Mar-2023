/*----------------------------------------------------------------------
	FILE        : CSDBoundedStack.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.10.2023

	CSDStack class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.EmptyStackException;
import java.util.Objects;

public class CSDBoundedStack<E>  {
    private final E [] m_items;
    private int m_index;

    @SuppressWarnings("unchecked")
    public CSDBoundedStack(int size)
    {
        if (size <= 0)
            throw new IllegalArgumentException("size must be positive!...");

        m_items = (E []) new Object[size];
    }

    public boolean empty()
    {
        return m_index == 0;
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return m_items[m_index - 1];
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        var value = m_items[--m_index];

        m_items[m_index] = null;

        return value;
    }

    public E push(E item)
    {
        if (m_index == m_items.length)
            throw new FullStackException();

        return m_items[m_index++] = item;
    }

    public int search(Object obj)
    {
        for (var i = m_index - 1; i >= 0; --i)
            if (Objects.equals(obj, m_items[i]))
                return m_index - i;

        return -1;
    }
}
