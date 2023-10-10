/*----------------------------------------------------------------------
	FILE        : CSDArrayListStack.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 10.10.2023

	CSDArrayListStack

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CSDArrayListStack<E> extends ArrayList<E> {
    public boolean empty()
    {
        return isEmpty();
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();

        return get(size() - 1);
    }

    public E pop()
    {
        if (empty())
            throw new EmptyStackException();

        return remove(size() - 1);
    }

    public E push(E item)
    {
        add(item);

        return item;
    }

    public int search(Object obj)
    {
        var index = lastIndexOf(obj);

        return index == -1 ? index : size() - index;
    }
}
