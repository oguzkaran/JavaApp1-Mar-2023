package org.csystem.math;

import org.csystem.math.geometry.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PointHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Point> m_hs = new HashSet<>(Arrays.asList(Point.createCartesian(0, 0),
                                Point.createCartesian(1, 1), Point.createCartesian(-2.1, -3.5)));
    private static class DataInfo {
        Point actual;
        Boolean expected;

        DataInfo(Point actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(Point.createCartesian(0, 0), false),
                    new DataInfo(Point.createCartesian(1, 1), false),
                    new DataInfo(Point.createCartesian(-2.1, -3.5), false));
    }

    public PointHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}

