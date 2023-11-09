package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class PairHashCodeTest {
    private final HashSet<Pair<Double, String>> m_pairs = new HashSet<>();
    private final Pair<Double, String> m_p1 = new Pair<>(0.0, "ankara");
    private final Pair<Double, String> m_p2 = new Pair<>(0.0, "ankara");
    private final Pair<Double, String> m_p3 = new Pair<>(2.3, "istanbul");
    private final Pair<Double, String> m_p4 = new Pair<>(2.3, "istanbul");


    @Test
    public void addValues_thenLookIfContains()
    {
        m_pairs.add(m_p1);
        Assert.assertTrue(m_pairs.contains(m_p2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_pairs.add(m_p3);
        Assert.assertFalse(m_pairs.add(m_p4));
    }

}

