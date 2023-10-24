package org.csystem.util.array;

import org.csystem.tuple.Pair;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;

@Ignore
@SuppressWarnings("ALL")
public class ArrayUtilGenericBubbleSortTest {

    private final Integer [] m_numbers = {0, -1, 2, -2, 1};


    private final Pair<Integer, String> [] m_cities = new Pair[3];

    {
        m_cities[0] = Pair.of(1, "Adana");
        m_cities[1] = Pair.of(34, "Istanbul");
        m_cities[2] = Pair.of(6, "Ankara");
    }

    @Test
    public void givenIntegerArray_thenBubbleSortAscending()
    {
        ArrayUtil.bubbleSort(m_numbers, Integer::compareTo, false);
        Assert.assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2}, m_numbers);
    }

    @Test
    public void givenIntegerArray_thenBubbleSortDescending()
    {
        ArrayUtil.bubbleSort(m_numbers, Integer::compareTo, true);
        Assert.assertArrayEquals(new Integer[]{2, 1, 0, -1, -2}, m_numbers);
    }

    @Test
    public void givenIntegerArray_thenBubbleSortAscending_NoDescOptionMethod()
    {
        ArrayUtil.bubbleSort(m_numbers, Integer::compareTo);
        Assert.assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2}, m_numbers);
    }

    @Test
    public void givenPairArray_thenBubbleSortAscending_FirstElement()
    {
        ArrayUtil.bubbleSort(m_cities, Comparator.comparingInt(p -> (int) p.getFirst()), false);
        Assert.assertArrayEquals(new Pair[]{Pair.of(1, "Adana"), Pair.of(6, "Ankara"), Pair.of(34, "Istanbul")}, m_cities);
    }

    @Test
    public void givenPairArray_thenBubbleSortDescending_FirstElement()
    {
        ArrayUtil.bubbleSort(m_cities, Comparator.comparingInt(p -> (int) p.getFirst()), true);
        Assert.assertArrayEquals(new Pair[]{Pair.of(34, "Istanbul"), Pair.of(6, "Ankara"), Pair.of(1, "Adana")}, m_cities);
    }

    @Test
    public void givenPairArray_thenBubbleSortAscending_SecondElement()
    {
        ArrayUtil.bubbleSort(m_cities, Comparator.comparing(p -> (String) p.getSecond()), false);
        Assert.assertArrayEquals(new Pair[]{Pair.of(1, "Adana"), Pair.of(6, "Ankara"), Pair.of(34, "Istanbul")}, m_cities);
    }

    @Test
    public void givenPairArray_thenBubbleSortDescending_SecondElement()
    {
        ArrayUtil.bubbleSort(m_cities, Comparator.comparing(p -> (String) p.getSecond()), true);
        Assert.assertArrayEquals(new Pair[]{Pair.of(34, "Istanbul"), Pair.of(6, "Ankara"), Pair.of(1, "Adana")}, m_cities);
    }

    @Test
    public void givenPairArray_thenBubbleSortAscending_NoDescOptionMethod_SecondElement()
    {
        ArrayUtil.bubbleSort(m_cities, Comparator.comparing(p -> (String) p.getSecond()));
        Assert.assertArrayEquals(new Pair[]{Pair.of(1, "Adana"), Pair.of(6, "Ankara"), Pair.of(34, "Istanbul")}, m_cities);
    }

}
