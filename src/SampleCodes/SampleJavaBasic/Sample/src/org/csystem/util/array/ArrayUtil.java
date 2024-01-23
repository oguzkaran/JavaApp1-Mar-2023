/*----------------------------------------------------------
	FILE			: ArrayUtil.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 10.09.2023

	Utility class for array operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.array;


import java.util.random.RandomGenerator;

public final class ArrayUtil {
    private ArrayUtil()
    {
    }

    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k] < a[k + 1])
                    swap(a, k, k + 1);
    }

    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }

            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if (max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }

            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    public static void addBy(int [][] a, int value)
    {
        for (int [] array : a)
            addBy(array, value);
    }

    public static void addBy(int [] a, int value)
    {
        for (int i = 0; i < a.length; ++i)
                a[i] += value;
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static int [] copyOf(int [] a, int newLength)
    {
        int [] result = new int[newLength];

        System.arraycopy(a, 0, result, 0, Math.min(newLength, a.length));

        return result;
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int count = val * n / maxVal;

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static void fillRandomArray(RandomGenerator randomGenerator, int [] a, int min, int bound)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = randomGenerator.nextInt(min, bound);
    }

    public static int [] getHistogramData(int [] a, int n)
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static int [] getRandomArray(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        int [] a = new int[count];

        fillRandomArray(randomGenerator, a, min, bound);

        return a;
    }

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.max(result, a[i]);

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.min(result, a[i]);

        return result;
    }

    public static void multiplyBy(int [][] a, int value)
    {
        for (int i = 0; i < a.length; ++i)
            for (int k = 0; k < a[i].length; ++k)
                a[i][k] *= value;
    }

    public static void print(int [] a)
    {
        print(1, a);
    }

    public static void print(int n, int [] a)
    {
        String fmt = String.format("%%0%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void print(int [][] a)
    {
        print(1, a);
    }

    public static void print(int n, int [][] a)
    {
        for (int [] array : a)
            print(n, array);
    }

    public static void print(byte [] data, int startIndex, int count)
    {
        for (int i = 0; i < count; ++i)
            System.out.printf("%d ", data[startIndex + i]);

        System.out.println();
    }

    public static void reverse(int [] a)
    {
        int left = 0;
        int right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void reverse(char [] a)
    {
        int left = 0;
        int right = a.length - 1;

        while (left < right)
            swap(a, left++, right--);
    }

    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void subtractBy(int [][] a, int value)
    {
        addBy(a, -value);
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static long sumLong(int [] a)
    {
        long total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];

        a[i] = a[k];
        a[k] = temp;
    }
}
