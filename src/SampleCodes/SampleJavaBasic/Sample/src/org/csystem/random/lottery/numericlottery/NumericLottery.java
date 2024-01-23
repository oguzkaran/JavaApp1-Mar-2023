package org.csystem.random.lottery.numericlottery;

import java.util.random.RandomGenerator;

public class NumericLottery {
    private final RandomGenerator m_randomGenerator;

    private static int [] getNumbers(boolean [] flags)
    {
        int [] numbers = new int[6];
        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                numbers[index++] = i;

        return numbers;
    }

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        for (int i = 0; i < 6; ++i) {
            int val;

            for (;;) {
                val = m_randomGenerator.nextInt(1, 50);
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    public NumericLottery(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int count)
    {
        int [][] numbers = new int[count][];

        for (int i = 0; i < count; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
