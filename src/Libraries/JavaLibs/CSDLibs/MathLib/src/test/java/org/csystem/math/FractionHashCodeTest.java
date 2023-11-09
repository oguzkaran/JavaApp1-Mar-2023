package org.csystem.math;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class FractionHashCodeTest {
    private final HashSet<Fraction> m_fractions = new HashSet<>();
    private final Fraction m_zero1 = new Fraction(0, 1);
    private final Fraction m_zero2 = new Fraction(0, 2);
    private final Fraction m_unit1 = new Fraction(1, 1);
    private final Fraction m_unit2 = new Fraction(5, 5);
    private final Fraction m_f1 = new Fraction(-2, -3);
    private final Fraction m_f2 = new Fraction(-2, -3);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_fractions.add(m_zero1);
        Assert.assertTrue(m_fractions.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_fractions.add(m_unit1);
        Assert.assertFalse(m_fractions.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_fractions.add(m_f1);
        Assert.assertFalse(m_fractions.add(m_f2));
    }

}

