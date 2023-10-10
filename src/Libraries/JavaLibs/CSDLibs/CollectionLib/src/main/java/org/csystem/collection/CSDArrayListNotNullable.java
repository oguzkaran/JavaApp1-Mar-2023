/*----------------------------------------------------------------------
	FILE        : CSDArrayListNotNullable.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 05.10.2023

	CSDArrayListNotNullable adapter class that represents a dynamic array
	can not contain a null value

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CSDArrayListNotNullable<E> extends ArrayList<E> {
    public static <E> void checkNull(E e)
    {
        if (e == null)
            throw new IllegalArgumentException("null value not allowed for that list");
    }

    public static <E> void checkAnyNull(Collection <? extends E> collection)
    {
        for (var e : collection)
            checkNull(e);
    }

    public CSDArrayListNotNullable(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDArrayListNotNullable()
    {
    }

    public CSDArrayListNotNullable(Collection<? extends E> collection)
    {
        this(collection.size());
        addAll(collection);
    }

    @Override
    public E set(int index, E element)
    {
        checkNull(element);

        return super.set(index, element);
    }

    @Override
    public boolean add(E e)
    {
        checkNull(e);

        return super.add(e);
    }

    @Override
    public void add(int index, E element)
    {
        checkNull(element);

        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        checkAnyNull(c);

        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        checkAnyNull(c);

        return super.addAll(index, c);
    }
}
