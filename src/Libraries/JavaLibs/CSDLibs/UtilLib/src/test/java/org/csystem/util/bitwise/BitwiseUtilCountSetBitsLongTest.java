package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountSetBitsLongTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        int expected;

        public DataInfo(long value, int expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10L, 2),
                new DataInfo(11L, 3),
                new DataInfo(Long.MAX_VALUE, 63),
                new DataInfo(Long.MIN_VALUE, 1),
                new DataInfo(0L, 0),
                new DataInfo(1L, 1),
                new DataInfo(-1L, 64));
    }

    public BitwiseUtilCountSetBitsLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsLong_thenReturnNumberOfSetBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countSetBits(m_dataInfo.value));
    }
}
