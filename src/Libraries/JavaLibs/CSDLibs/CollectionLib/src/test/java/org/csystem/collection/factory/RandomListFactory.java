package org.csystem.collection.factory;

import org.csystem.collection.CSDArrayListNotNullable;

import java.util.Random;

import static org.csystem.util.string.StringUtil.getRandomTextEN;

public class RandomListFactory {
    private final Random m_random;

    public RandomListFactory()
    {
        m_random = new Random();
    }

    public CSDArrayListNotNullable<Object> createIntegerList(int n, int min, int bound)
    {
        var list = new CSDArrayListNotNullable<>();

        for(int i = 0; i < n; i++)
            list.add(m_random.nextInt(min, bound));

        return list;
    }

    public CSDArrayListNotNullable<Object> createStringList(int n, int min, int bound)
    {
        var list = new CSDArrayListNotNullable<>();

        for(int i = 0; i < n; i++)
            list.add(getRandomTextEN(m_random, m_random.nextInt(min, bound)));

        return list;
    }
}
