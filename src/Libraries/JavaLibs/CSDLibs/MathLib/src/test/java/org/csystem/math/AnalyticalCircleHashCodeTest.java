package org.csystem.math;

import org.csystem.math.geometry.AnalyticalCircle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnalyticalCircleHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<AnalyticalCircle> m_hs = new HashSet<>(Arrays.asList(new AnalyticalCircle(),
                                                                                    new AnalyticalCircle(1, 1),
                                                                                    new AnalyticalCircle(2, -3.5, -2.2)));

    private static class DataInfo {
        AnalyticalCircle actual;
        Boolean expected;

        DataInfo(AnalyticalCircle actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new AnalyticalCircle(), false),
                    new DataInfo(new AnalyticalCircle(1, 1), false),
                    new DataInfo(new AnalyticalCircle(2, -3.5, -2.2), false));
    }

    public AnalyticalCircleHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}

