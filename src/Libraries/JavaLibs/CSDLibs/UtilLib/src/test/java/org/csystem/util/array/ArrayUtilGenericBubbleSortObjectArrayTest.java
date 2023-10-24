package org.csystem.util.array;

import org.csystem.tuple.Pair;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ArrayUtilGenericBubbleSortObjectArrayTest {

    private final Object [] m_numbers = {0, -1, 2, -2, 1};


    private final Object [] m_cities = new Object[3];

    {
        m_cities[0] = Pair.of(1, "Adana");
        m_cities[1] = Pair.of(34, "Istanbul");
        m_cities[2] = Pair.of(6, "Ankara");
    }

    @Test
    public void givenIntegerArray_thenBubbleSortAscending()
    {
        ArrayUtil.bubbleSort(m_numbers, false);
        Assert.assertArrayEquals(new Object[]{-2, -1, 0, 1, 2}, m_numbers);
    }

    @Test
    public void givenIntegerArray_thenBubbleSortDescending()
    {
        ArrayUtil.bubbleSort(m_numbers, true);
        Assert.assertArrayEquals(new Object[]{2, 1, 0, -1, -2}, m_numbers);
    }

    @Test
    public void givenIntegerArray_thenBubbleSortAscending_NoDescOptionMethod()
    {
        ArrayUtil.bubbleSort(m_numbers);
        Assert.assertArrayEquals(new Object[]{-2, -1, 0, 1, 2}, m_numbers);
    }

    @Test
    public void givenPairArray_thenBubbleSort_throwsClassCastException()
    {
        Assert.assertThrows(ClassCastException.class, () -> ArrayUtil.bubbleSort(m_cities, false));
    }
}
