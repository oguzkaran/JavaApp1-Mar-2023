package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class QuadrupleHashCodeTest {
    private final HashSet<Quadruple<Double, String, Integer, String>> m_quadruples = new HashSet<>();
    private final Quadruple<Double, String, Integer, String> m_q1 = new Quadruple<>(0.0, "ankara", 0, "adana");
    private final Quadruple<Double, String, Integer, String> m_q2 = new Quadruple<>(0.0, "ankara", 0, "adana");
    private final Quadruple<Double, String, Integer, String> m_q3 = new Quadruple<>(2.3, "istanbul", 35, "izmir");
    private final Quadruple<Double, String, Integer, String> m_q4 = new Quadruple<>(2.3, "istanbul", 35, "izmir");


    @Test
    public void addValues_thenLookIfContains()
    {
        m_quadruples.add(m_q1);
        Assert.assertTrue(m_quadruples.contains(m_q2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_quadruples.add(m_q3);
        Assert.assertFalse(m_quadruples.add(m_q4));
    }

}

