/*----------------------------------------------------------------------
	FILE        : Matrix.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 07.11.2023

	Generic Matrix class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.math;

import java.util.function.BinaryOperator;

public class Matrix<T> {
    public Matrix(int row, int column)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Matrix(T [][] data)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Matrix(Matrix<T> matrix)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public int getRow()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public int getColumn()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }


    public T get(int i, int k)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public void set(int i, int k, T val)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public boolean isSquareMatrix()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Matrix<T> apply(Matrix<T> other, BinaryOperator<T> binaryOperator)
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public void transpose()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public Matrix<T> transposed()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    public T [][] toArray()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }
}
