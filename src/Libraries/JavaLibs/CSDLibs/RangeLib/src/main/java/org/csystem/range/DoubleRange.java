/*----------------------------------------------------------------------
	FILE        : DoubleRange.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 14.09.2023

	Iterable DoubleRange class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.range;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double> {
    private final double m_min, m_bound;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    private DoubleRange(double min, double bound, DoubleUnaryOperator doubleUnaryOperator)
    {
        m_min = min;
        m_bound = bound;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }

    public static DoubleRange of(double min, double bound, double step)
    {
        if (step < 0)
            throw new IllegalArgumentException("step must be positive");

        return of(min, bound, val -> val + step);
    }

    public static DoubleRange of(double min, double bound, DoubleUnaryOperator doubleUnaryOperator)
    {
        if (min >= bound)
            throw new IllegalArgumentException("min must be less than bound");

        return new DoubleRange(min, bound, doubleUnaryOperator);
    }

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>() {
            double value = m_min;

            @Override
            public boolean hasNext()
            {
                return value < m_bound;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element!...");

                double  result = value;

                value = m_doubleUnaryOperator.applyAsDouble(value);

                return result;
            }
        };
    }
}