package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilClearBitLongTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        int k;
        long expected;

        DataInfo(long value, int k, long expected)
        {
            this.value = value;
            this.k = k;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(0b00101110, 2, 0b00101010),
                new DataInfo(0b00101010, 2, 0b00101010),
                new DataInfo(0b10101110, 7, 0b00101110));
    }

    public BitwiseUtilClearBitLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnClearBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.clearBit(m_dataInfo.value, m_dataInfo.k));
    }
}
