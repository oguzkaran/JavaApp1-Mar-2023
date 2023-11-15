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
public class QuadrupleHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Quadruple<Double, String, Integer, String>> m_hs = new HashSet<>(Arrays.asList(
                                                        new Quadruple<>(0.0, "ankara", 0, "adana"),
                                                        new Quadruple<>(2.3, "istanbul", 35, "izmir")));
    private static class DataInfo {
        Quadruple<Double, String, Integer, String> actual;
        Boolean expected;

        DataInfo(Quadruple<Double, String, Integer, String> actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Quadruple<>(0.0, "ankara", 0, "adana"), false),
                new DataInfo(new Quadruple<>(2.3, "istanbul", 35, "izmir"), false));
    }

    public QuadrupleHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}



