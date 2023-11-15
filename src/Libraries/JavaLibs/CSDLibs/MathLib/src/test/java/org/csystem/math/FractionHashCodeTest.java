package org.csystem.math;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FractionHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Fraction> m_hs = new HashSet<>(Arrays.asList(new Fraction(0, 1),
                                                                                    new Fraction(1, 1),
                                                                                    new Fraction(-2, -3)));

    private static class DataInfo {
        Fraction actual;
        Boolean expected;

        DataInfo(Fraction actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Fraction(0, 1), false),
                    new DataInfo(new Fraction(1, 1), false),
                    new DataInfo(new Fraction(-2, -3), false));
    }

    public FractionHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}

