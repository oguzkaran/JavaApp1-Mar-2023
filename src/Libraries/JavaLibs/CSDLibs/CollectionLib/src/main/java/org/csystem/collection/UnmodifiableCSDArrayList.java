/*----------------------------------------------------------------------
	FILE        : UnmodifiableCSDArrayList.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 05.10.2023

	UnmodifiableCSDArrayList class that represents an unmodifiable
	array

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.*;

public class UnmodifiableCSDArrayList<E> implements List<E> {
    //...
    public UnmodifiableCSDArrayList(E...elements)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public UnmodifiableCSDArrayList(Collection<? extends E> collection)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean add(E e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public void add(int index, E e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public int indexOf(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public int lastIndexOf(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public ListIterator<E> listIterator()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E remove(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int index, E e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean isEmpty()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean contains(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<>() {
            @Override
            public boolean hasNext()
            {
                throw new UnsupportedOperationException("Not implemented yet!...");
            }

            @Override
            public E next()
            {
                throw new UnsupportedOperationException("Not implemented yet!...");
            }
        };
    }

    @Override
    public Object[] toArray()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }


    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }
}
