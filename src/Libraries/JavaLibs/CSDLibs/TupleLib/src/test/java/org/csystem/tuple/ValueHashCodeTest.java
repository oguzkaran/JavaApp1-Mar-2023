package org.csystem.tuple;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;

@Ignore
public class ValueHashCodeTest {
    private final HashSet<Value<String>> m_values = new HashSet<>();
    private final Value<String> m_v1 = new Value<>("ankara");
    private final Value<String> m_v2 = new Value<>("ankara");
    private final Value<String> m_v3 = new Value<>("istanbul");
    private final Value<String> m_v4 = new Value<>("istanbul");


    @Test
    public void addValues_thenLookIfContains()
    {
        m_values.add(m_v1);
        Assert.assertTrue(m_values.contains(m_v2));
    }

    @Test
    public void addSameValue1_thenReturnFalse()
    {
        m_values.add(m_v3);
        Assert.assertFalse(m_values.add(m_v4));
    }

}

