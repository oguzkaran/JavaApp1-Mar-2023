package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilHighestSetBitByteTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        byte value;
        int expected;

        public DataInfo(byte value, int expected) {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((byte)10, 3),
                new DataInfo((byte)11, 3),
                new DataInfo(Byte.MAX_VALUE, 6),
                new DataInfo(Byte.MIN_VALUE, 7),
                new DataInfo((byte)0, -1),
                new DataInfo((byte)1, 0),
                new DataInfo((byte)-1, 7));
    }

    public BitwiseUtilHighestSetBitByteTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsByte_thenReturnHighestSetBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.highestSetBitIndex(m_dataInfo.value));
    }
}