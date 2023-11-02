package org.csystem.app.factory.random;

import org.csystem.math.Fraction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.random.RandomGenerator;

public class RandomFractionFactory {
    private final RandomGenerator m_randomGenerator;

    public RandomFractionFactory(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    private int nullLastComparatorCallback(Fraction f1, Fraction f2)
    {
        /*
        if (f1 == null && f2 == null) //Bu örnek açısından gerek yok. Ancak birden fazla null eklenmesi durumu kontrol ediliyor
            return 0;
         */

        if (f1 == null)
            return 1;

        return f1.compareTo(f2);
    }

    private int nullFirstComparatorCallback(Fraction f1, Fraction f2)
    {
        if (f1 == null)
            return -1;

        return f1.compareTo(f2);
    }

    private TreeSet<Fraction> createTreeSetUntilInvalidWithNull(int min, int bound, Comparator<Fraction> comparator)
    {
        var fractions = new TreeSet<>(comparator);

        try {
            while (true)
                fractions.add(new Fraction(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound)));
        }
        catch (NumberFormatException ignore) {
            fractions.add(null);
        }

        return fractions;
    }

    public List<Fraction> createUntilInvalid(int min, int bound)
    {
        var fractions = new ArrayList<Fraction>();

        try {
            while (true)
                fractions.add(new Fraction(m_randomGenerator.nextInt(min, bound), m_randomGenerator.nextInt(min, bound)));
        }
        catch (NumberFormatException ignore) {

        }

        return fractions;
    }

    public TreeSet<Fraction> createTreeSetUntilInvalidNullLast(int min, int bound)
    {
        return createTreeSetUntilInvalidWithNull(min, bound, this::nullLastComparatorCallback);
    }

    public TreeSet<Fraction> createTreeSetUntilInvalidNullFirst(int min, int bound)
    {
        return createTreeSetUntilInvalidWithNull(min, bound, this::nullFirstComparatorCallback);
    }
}
