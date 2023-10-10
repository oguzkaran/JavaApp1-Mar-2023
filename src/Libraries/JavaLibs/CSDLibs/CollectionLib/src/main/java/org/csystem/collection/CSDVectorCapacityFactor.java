/*----------------------------------------------------------------------
	FILE        : CSDVectorCapacityFactor.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 05.10.2023

	CSDVectorCapacityFactor adapter class that represents a dynamic array
	takes the capacityIncrement as factor

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.Collection;
import java.util.Vector;

public class CSDVectorCapacityFactor<E> extends Vector<E> {
    private final double m_capacityFactor;

    private void configCapacityIncrement()
    {
        int currentCapacity = capacity();

        capacityIncrement = (int)Math.floor(m_capacityFactor * currentCapacity) - currentCapacity;
    }

    public CSDVectorCapacityFactor()
    {
        this(10);
    }

    public CSDVectorCapacityFactor(int initialCapacity)
    {
        this(initialCapacity, 2);
    }

    public CSDVectorCapacityFactor(int initialCapacity, double capacityFactor)
    {
        super(initialCapacity);
        m_capacityFactor = capacityFactor;
    }

    public CSDVectorCapacityFactor(Collection<? extends E> collection, double capacityFactor)
    {
        super(collection);
        m_capacityFactor = capacityFactor;
    }

    @Override
    public synchronized void addElement(E e)
    {
        configCapacityIncrement();
        super.addElement(e);
    }

    @Override
    public synchronized boolean add(E e)
    {
        configCapacityIncrement();
        return super.add(e);
    }

    @Override
    public void add(int index, E element)
    {
        configCapacityIncrement();
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        configCapacityIncrement();
        return super.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection<? extends E> c)
    {
        configCapacityIncrement();
        return super.addAll(index, c);
    }
}
