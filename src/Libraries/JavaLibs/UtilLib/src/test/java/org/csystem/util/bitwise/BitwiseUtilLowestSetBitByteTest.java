package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilLowestSetBitByteTest {
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
        return Arrays.asList(new DataInfo((byte)10, 1),
                new DataInfo((byte)11, 0),
                new DataInfo(Byte.MAX_VALUE, 0),
                new DataInfo(Byte.MIN_VALUE, 7),
                new DataInfo((byte)0, -1),
                new DataInfo((byte)1, 0),
                new DataInfo((byte)-1, 0));
    }

    public BitwiseUtilLowestSetBitByteTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsByte_thenReturnLowestSetBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.lowestSetBitIndex(m_dataInfo.value));
    }
}
