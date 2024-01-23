/*----------------------------------------------------------
	FILE			: RandomIntArrayGenerator.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 14.07.2023

	RandomIntArrayGenerator class that creates a randomly
	generated array once per object

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.util.generator.random;

import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomIntArrayGenerator {
    private final int [] m_numbers;

    public RandomIntArrayGenerator(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        m_numbers = ArrayUtil.getRandomArray(randomGenerator, count, min, bound);
    }

    public int count()
    {
        return m_numbers.length;
    }

    public int get(int i)
    {
        return m_numbers[i];
    }
}
