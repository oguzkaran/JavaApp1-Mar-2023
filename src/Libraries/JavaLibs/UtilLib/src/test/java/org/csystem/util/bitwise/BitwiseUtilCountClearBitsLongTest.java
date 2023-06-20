package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountClearBitsLongTest {
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
        return Arrays.asList(new DataInfo(10L, 62),
                new DataInfo(11L, 61),
                new DataInfo(Long.MAX_VALUE, 1),
                new DataInfo(Long.MIN_VALUE, 63),
                new DataInfo(0L, 64),
                new DataInfo(1L, 63),
                new DataInfo(-1L, 0));
    }

    public BitwiseUtilCountClearBitsLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnNumberOfClearBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countClearBits(m_dataInfo.value));
    }
}
