package org.csystem.app.numericlottery;

import org.csystem.range.IntRange;

import java.util.Random;
import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class NumericLottery {
    private final RandomGenerator m_random;

    public NumericLottery()
    {
        this(new Random());
    }

    public NumericLottery(RandomGenerator r)
    {
        m_random = r;
    }

    public int [] getNumbers()
    {
        var treeSet = new TreeSet<Integer>();

        while (treeSet.size() != 6)
            treeSet.add(m_random.nextInt(1, 50));

        int [] a = new int[6];

        IntRange.of(0, 6).forEach(i -> a[i] = treeSet.pollFirst());

        return a;
    }

    public int [][] getNumbers(int n)
    {
        var numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
