/*----------------------------------------------------------
	FILE			: MatrixUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 14.07.2023

	Utility class for matrix operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.matrix;

import org.csystem.util.array.ArrayUtil;

import java.util.random.RandomGenerator;


public final class MatrixUtil {
    private MatrixUtil()
    {
    }

    public static int [][] addMatrices(int [][] a, int [][] b)
    {
        int row = a.length;
        int col = a[0].length;
        int [][] result = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                result[i][j] = a[i][j] + b[i][j];

        return result;
    }

    public static void addMatrixWithValue(int [][] a, int value)
    {
        ArrayUtil.addBy(a, value);
    }

    public static void fillRandomMatrix(RandomGenerator randomGenerator, int [][] a, int min, int bound)
    {
        for (int[] array : a)
            ArrayUtil.fillRandomArray(randomGenerator, array, min, bound);
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int [][] getRandomMatrix(RandomGenerator randomGenerator, int m, int n, int min, int bound)
    {
        int [][] a = new int[m][n];

        fillRandomMatrix(randomGenerator, a, min, bound);

        return a;
    }

    public static int [][] getRandomSquareMatrix(RandomGenerator randomGenerator, int n, int min, int bound)
    {
        return getRandomMatrix(randomGenerator, n, n, min, bound);
    }

    public static boolean isMatrix(int [][] a)
    {
        for (int i = 1; i < a.length; ++i)
            if (a[0].length != a[i].length)
                return false;

        return true;
    }

    public static int [][] multiplyMatrices(int [][] a, int [][] b)
    {
        int row1 = a.length;
        int col2 = b[0].length;
        int row2 = b.length;
        int [][] result = new int[row1][col2];

        for (int i = 0; i < row1; ++i)
            for (int j = 0; j < col2; ++j)
                for (int k = 0; k < row2; ++k)
                    result[i][j] += a[i][k] * b[k][j];

        return result;
    }

    public static void multiplyMatrixWithValue(int [][] a, int value)
    {
        ArrayUtil.multiplyBy(a, value);
    }

    public static int [][] subtractMatrices(int [][] a, int [][] b)
    {
        int row = a.length;
        int col = a[0].length;
        int [][] result = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                result[i][j] = a[i][j] - b[i][j];

        return result;
    }

    public static void subtractMatrixWithValue(int [][] a, int value)
    {
        addMatrixWithValue(a, -value);
    }

    public static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int [] [] transposed(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
