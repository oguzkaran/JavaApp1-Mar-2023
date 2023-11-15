package org.csystem.math;

import org.csystem.math.geometry.Circle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CircleHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Circle> m_hs = new HashSet<>(Arrays.asList(new Circle(), new Circle(1), new Circle(2.1)));
    private static class DataInfo {
        Circle actual;
        Boolean expected;

        DataInfo(Circle actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Circle(), false),
                    new DataInfo(new Circle(1), false),
                    new DataInfo(new Circle(2.1), false));
    }

    public CircleHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}

