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
public class ComplexHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Complex> m_hs = new HashSet<>(Arrays.asList(new Complex(0, 0),
                                                                                    new Complex(1, 1),
                                                                                    new Complex(-2.1, -3.5)));

    private static class DataInfo {
        Complex actual;
        Boolean expected;

        DataInfo(Complex actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Complex(0, 0), false),
                    new DataInfo(new Complex(1, 1), false),
                    new DataInfo(new Complex(-2.1, -3.5), false));
    }

    public ComplexHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}

