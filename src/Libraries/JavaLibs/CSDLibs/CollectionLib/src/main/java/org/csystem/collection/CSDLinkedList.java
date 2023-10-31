/*----------------------------------------------------------------------
	FILE        : CSDLinkedList.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 31.10.2023

	CSDLinkedList class that represents doubly linked list

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.*;

public class CSDLinkedList<E> implements List<E>, Deque<E> {
    private Node<E> m_head, m_tail;
    private int m_size;

    private static class Node<E> {
        E data;
        Node<E> prev, next;

        Node(E data)
        {
            this.data = data;
        }
    }

    @Override
    public void addFirst(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public void addLast(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean offerFirst(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean offerLast(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E removeFirst()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E removeLast()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E pollFirst()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E pollLast()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E getFirst()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E getLast()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E peekFirst()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E peekLast()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean removeFirstOccurrence(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean removeLastOccurrence(Object o)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public boolean offer(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E remove()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E poll()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E element()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E peek()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public void push(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E pop()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public Iterator<E> descendingIterator()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
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
        throw new UnsupportedOperationException("Not implemented yet!...");
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
    public boolean add(E e)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
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
    public void clear()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E get(int index)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E set(int index, E element)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public void add(int index, E element)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    @Override
    public E remove(int index)
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
}
