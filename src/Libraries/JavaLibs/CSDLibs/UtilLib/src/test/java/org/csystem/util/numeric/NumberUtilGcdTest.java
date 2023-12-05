package org.csystem.util.numeric;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberUtilGcdTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int a, b, expected;

        public DataInfo(int a, int b, int expected)
        {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo(3, 4, 1),
                new DataInfo(-3, 4, 1),
                new DataInfo(-3, -4, 1),
                new DataInfo(2, 10, 2),
                new DataInfo(18, 24, 6),
                new DataInfo(-18, 24, 6)
        );
    }

    public NumberUtilGcdTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test()
    {
        assertEquals(m_dataInfo.expected, NumberUtil.gcd(m_dataInfo.a, m_dataInfo.b));
    }
}
