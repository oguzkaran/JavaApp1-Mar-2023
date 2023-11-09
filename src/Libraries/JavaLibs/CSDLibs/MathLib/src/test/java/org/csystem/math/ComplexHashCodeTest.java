package org.csystem.math;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class ComplexHashCodeTest {
    private final HashSet<Complex> m_complexes = new HashSet<>();
    private final Complex m_zero1 = new Complex(0, 0);
    private final Complex m_zero2 = new Complex(0, 0);
    private final Complex m_unit1 = new Complex(1, 1);
    private final Complex m_unit2 = new Complex(1, 1);
    private final Complex m_c1 = new Complex(-2.1, -3.5);
    private final Complex m_c2 = new Complex(-2.1, -3.5);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_complexes.add(m_zero1);
        Assert.assertTrue(m_complexes.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_complexes.add(m_unit1);
        Assert.assertFalse(m_complexes.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_complexes.add(m_c1);
        Assert.assertFalse(m_complexes.add(m_c2));
    }

}

