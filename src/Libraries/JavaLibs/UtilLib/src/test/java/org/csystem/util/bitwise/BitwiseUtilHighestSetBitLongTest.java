package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilHighestSetBitLongTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        long expected;

        public DataInfo(long value, long expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10, 3),
                new DataInfo(11, 3),
                new DataInfo(Long.MAX_VALUE, 62),
                new DataInfo(Long.MIN_VALUE, 63),
                new DataInfo(0, -1),
                new DataInfo(1, 0),
                new DataInfo(-1, 63));
    }

    public BitwiseUtilHighestSetBitLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueLong_thenReturnHighestSetBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.highestSetBitIndex(m_dataInfo.value));
    }
}
