/*----------------------------------------------------------------------
	FILE        : CSDStack.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 12.10.2023

	CSDStack class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CSDStack<E>  {
    public final ArrayList<E> m_list = new ArrayList<>();

    public boolean empty()
    {
        return m_list.isEmpty();
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return m_list.get(m_list.size() - 1);
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        return m_list.remove(m_list.size() - 1);
    }

    public E push(E item)
    {
        m_list.add(item);

        return item;
    }

    public int search(Object obj)
    {
        var index = m_list.lastIndexOf(obj);

        return index == -1 ? index : m_list.size() - index;
    }
}
