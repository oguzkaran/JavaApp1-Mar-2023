package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class IntPairHashCodeTest {
    private final HashSet<IntPair> m_intPairs = new HashSet<>();
    private final IntPair m_zero1 = new IntPair();
    private final IntPair m_zero2 = new IntPair(0, 0);
    private final IntPair m_unit1 = new IntPair(1, 1);
    private final IntPair m_unit2 = new IntPair(1, 1);
    private final IntPair m_ip1 = new IntPair(-2, -3);
    private final IntPair m_ip2 = new IntPair(-2, -3);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_intPairs.add(m_zero1);
        Assert.assertTrue(m_intPairs.contains(m_zero2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_intPairs.add(m_unit1);
        Assert.assertFalse(m_intPairs.add(m_unit2));
    }

    @Test
    public void addSameValue2_thenReturnFalse()
    {
        m_intPairs.add(m_ip1);
        Assert.assertFalse(m_intPairs.add(m_ip2));
    }

}

