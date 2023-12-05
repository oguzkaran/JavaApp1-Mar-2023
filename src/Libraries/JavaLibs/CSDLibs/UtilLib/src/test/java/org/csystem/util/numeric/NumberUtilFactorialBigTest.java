package org.csystem.util.numeric;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumberUtilFactorialBigTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int input;
        BigInteger expected;

        public DataInfo(int input, BigInteger expected)
        {
            this.input = input;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo(-1, BigInteger.ONE),
                new DataInfo(-10, BigInteger.ONE),
                new DataInfo(0, BigInteger.ONE),
                new DataInfo(1, BigInteger.ONE),
                new DataInfo(2, BigInteger.TWO),
                new DataInfo(3, BigInteger.valueOf(6)),
                new DataInfo(4, BigInteger.valueOf(24)),
                new DataInfo(5, BigInteger.valueOf(120))
        );
    }

    public NumberUtilFactorialBigTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test()
    {
        assertEquals(m_dataInfo.expected, NumberUtil.factorialBig(m_dataInfo.input));
    }
}
