package org.csystem.tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TripleHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Triple<Double, String, Integer>> m_hs = new HashSet<>(Arrays.asList(
                                                                    new Triple<>(0.0, "ankara", 0),
                                                                    new Triple<>(2.3, "istanbul", 35)));
    private static class DataInfo {
        Triple<Double, String, Integer> actual;
        Boolean expected;

        DataInfo(Triple<Double, String, Integer> actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Triple<>(0.0, "ankara", 0), false),
                new DataInfo(new Triple<>(2.3, "istanbul", 35), false));
    }

    public TripleHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}



