/*----------------------------------------------------------------------
	FILE        : CSDArrayList.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 03.10.2023

	CSDArrayList class that represents dynamic array

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.*;

public class CSDArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] m_elements;
    private int m_index;

    private static void throwForIllegalArgument(String message)
    {
        throw new IllegalArgumentException(message);
    }

    private static void throwForIndexOutOfBounds(String message)
    {
        throw new IndexOutOfBoundsException(message);
    }

    private static void checkCapacity(int capacity)
    {
        if (capacity < 0)
            throwForIllegalArgument(String.format("Capacity can not be negative:%d", capacity));
    }

    private void checkIndex(int index)
    {
        if (index < 0 || index >= m_index)
            throwForIndexOutOfBounds(String.format("Index out of bounds:%d", index));
    }

    private void changeCapacity(int capacity)
    {
        m_elements = Arrays.copyOf(m_elements, capacity);
    }

    private void enlargeCapacityIfNecessary()
    {
        if (m_index == m_elements.length)
            changeCapacity(m_elements.length == 0 ? 1 : m_elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList()
    {
        m_elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        m_elements = (E[])new Object[initialCapacity];
    }

    @Override
    public boolean add(E e)
    {
        enlargeCapacityIfNecessary();
        m_elements[m_index++] = e;

        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public void add(int index, E e)
    {
        enlargeCapacityIfNecessary();
        for (int i = m_index++; i > index; --i)
            m_elements[i] = m_elements[i - 1];
        m_elements[index] = e;
    }

    public int capacity()
    {
        return m_elements.length;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elements[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity > m_elements.length)
            changeCapacity(Math.max(m_elements.length * 2, minCapacity));
    }

    @Override
    public E get(int index)
    {
        checkIndex(index);

        return m_elements[m_index];
    }

    @Override
    public int indexOf(Object o)
    {
        for (var i = 0; i < m_index; ++i)
            if (Objects.equals(o, m_elements[i]))
                return i;

        return -1;
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
        checkIndex(index);
        E old = m_elements[index];

        for (int i = index; i < m_index - 1; ++i)
            m_elements[i] = m_elements[i + 1];

        m_elements[--m_index] = null;

        return old;
    }

    @Override
    public E set(int index, E e)
    {
        checkIndex(index);
        E old = m_elements[index];

        m_elements[index] = e;

        return old;
    }

    @Override
    public int size()
    {
        return m_index;
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

    public void trimToSize()
    {
        if (m_elements.length != m_index)
            changeCapacity(m_index);
    }


    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<>() {
            int index;

            @Override
            public boolean hasNext()
            {
                return index < m_index;
            }

            @Override
            public E next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                return m_elements[index++];
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
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < m_index; ++i)
            sb.append(m_elements[i]).append(", ");

        return (m_index != 0 ? sb.substring(0, sb.length() - 2) : sb.toString()) + "]";
    }
}
