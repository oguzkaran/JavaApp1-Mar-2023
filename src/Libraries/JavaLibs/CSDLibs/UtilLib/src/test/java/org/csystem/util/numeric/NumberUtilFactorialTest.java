package org.csystem.util.numeric;

import org.csystem.util.string.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberUtilFactorialTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int input;
        long expected;

        public DataInfo(int input, long expected)
        {
            this.input = input;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo(-1, 1),
                new DataInfo(-10, 1),
                new DataInfo(0, 1),
                new DataInfo(1, 1),
                new DataInfo(2, 2),
                new DataInfo(3, 6),
                new DataInfo(4, 24),
                new DataInfo(5, 120)
        );
    }

    public NumberUtilFactorialTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test()
    {
        assertEquals(m_dataInfo.expected, NumberUtil.factorial(m_dataInfo.input));
    }
}
