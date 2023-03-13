package org.csystem.application.numericlottery;

import java.util.Random;

public class NumericLottery {
    private final Random m_random;

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        for (int i = 0; i < 6; ++i) {
            int val;

            for (;;) {
                val = m_random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    private static int [] getNumbers(boolean[] flags)
    {
        int [] numbers = new int[6];

        int idx = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                numbers[idx++] = i;

        return numbers;
    }

    public NumericLottery()
    {
        this(new Random());
    }

    public NumericLottery(Random r)
    {
        m_random = r;
    }

    public int [] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
