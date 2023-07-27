package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountSetBitsByteTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        byte value;
        int expected;

        public DataInfo(byte value, int expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((byte)10, 2),
                new DataInfo((byte)11, 3),
                new DataInfo(Byte.MAX_VALUE, 7),
                new DataInfo(Byte.MIN_VALUE, 1),
                new DataInfo((byte)0, 0),
                new DataInfo((byte)1, 1),
                new DataInfo((byte)-1, 8));
    }

    public BitwiseUtilCountSetBitsByteTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsByte_thenReturnNumberOfSetBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countSetBits(m_dataInfo.value));
    }
}
