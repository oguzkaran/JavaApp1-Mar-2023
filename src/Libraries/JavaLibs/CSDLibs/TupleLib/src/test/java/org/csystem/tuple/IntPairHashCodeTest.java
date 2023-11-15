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
public class IntPairHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<IntPair> m_hs = new HashSet<>(Arrays.asList(new IntPair(0, 0), new IntPair(1, 1), new IntPair(-2, -3)));
    private static class DataInfo {
        IntPair actual;
        Boolean expected;

        DataInfo(IntPair actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new IntPair(0, 0), false),
                new DataInfo(new IntPair(1, 1), false),
                new DataInfo(new IntPair(-2, -3), false));
    }

    public IntPairHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}



