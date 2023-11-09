package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class TripleHashCodeTest {
    private final HashSet<Triple<Double, String, Integer>> m_triples = new HashSet<>();
    private final Triple<Double, String, Integer> m_t1 = new Triple<>(0.0, "ankara", 0);
    private final Triple<Double, String, Integer> m_t2 = new Triple<>(0.0, "ankara", 0);
    private final Triple<Double, String, Integer> m_t3 = new Triple<>(2.3, "istanbul", 35);
    private final Triple<Double, String, Integer> m_t4 = new Triple<>(2.3, "istanbul", 35);


    @Test
    public void addValues_thenLookIfContains()
    {
        m_triples.add(m_t1);
        Assert.assertTrue(m_triples.contains(m_t2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_triples.add(m_t3);
        Assert.assertFalse(m_triples.add(m_t4));
    }

}

