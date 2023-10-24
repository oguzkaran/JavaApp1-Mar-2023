package org.csystem.util.array;

import org.csystem.tuple.Pair;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
@SuppressWarnings("ALL")
public class ArrayUtilGenericSwapTest {

    private final Integer [] m_numbers = {-3, 2, 0};
    private final Pair<Integer, String> [] m_cities = new Pair[]{Pair.of(1, "Adana"), Pair.of(34, "Istanbul"), Pair.of(6, "Ankara")};

    @Test
    public void givenIntegerArrayAndIndexes_thenSwap1()
    {
        ArrayUtil.swap(m_numbers, 0, 2);
        Assert.assertArrayEquals(new Integer[]{0, 2, -3}, m_numbers);
    }

    @Test
    public void givenIntegerArrayAndIndexes_thenSwap2()
    {
        ArrayUtil.swap(m_numbers, 0, 1);
        Assert.assertArrayEquals(new Integer[]{2, -3, 0}, m_numbers);
    }

    @Test
    public void givenIntegerArrayAndSameIndex_thenSwap()
    {
        ArrayUtil.swap(m_numbers, 0, 0);
        Assert.assertArrayEquals(new Integer[]{-3, 2, 0}, m_numbers);
    }

    @Test
    public void givenIntegerArrayAndWrongIndex_thenSwap()
    {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtil.swap(m_numbers, 0, 3));
    }

    @Test
    public void givenPairArrayAndIndexes_thenSwap1()
    {
        ArrayUtil.swap(m_cities, 0, 2);
        Assert.assertArrayEquals(new Pair[]{Pair.of(6, "Ankara"), Pair.of(34, "Istanbul"), Pair.of(1, "Adana")}, m_cities);
    }

    @Test
    public void givenPairArrayAndIndexes_thenSwap2()
    {
        ArrayUtil.swap(m_cities, 1, 2);
        Assert.assertArrayEquals(new Pair[]{Pair.of(1, "Adana"), Pair.of(6, "Ankara"), Pair.of(34, "Istanbul")}, m_cities);
    }

    @Test
    public void givenPairArrayAndSameIndexes_thenSwap()
    {
        ArrayUtil.swap(m_cities, 1, 1);
        Assert.assertArrayEquals(new Pair[]{Pair.of(1, "Adana"), Pair.of(34, "Istanbul"), Pair.of(6, "Ankara")}, m_cities);
    }

    @Test
    public void givenPairArrayAndWrongIndex_thenSwap()
    {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtil.swap(m_numbers, -1, 2));
    }
}
