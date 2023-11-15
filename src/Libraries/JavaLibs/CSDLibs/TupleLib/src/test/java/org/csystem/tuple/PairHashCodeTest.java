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
public class PairHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Pair<Double, String>> m_hs = new HashSet<>(Arrays.asList(new Pair<>(0.0, "ankara"), new Pair<>(2.3, "istanbul")));
    private static class DataInfo {
        Pair<Double, String> actual;
        Boolean expected;

        DataInfo(Pair<Double, String> actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Pair<>(0.0, "ankara"), false),
                new DataInfo(new Pair<>(2.3, "istanbul"), false));
    }

    public PairHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}



