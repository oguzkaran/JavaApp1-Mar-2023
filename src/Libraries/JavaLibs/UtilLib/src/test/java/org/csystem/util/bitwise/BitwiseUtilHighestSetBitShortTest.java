package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilHighestSetBitShortTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        short value;
        int expected;

        public DataInfo(short value, int expected) {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((byte)10, 3),
                new DataInfo((short)11, 3),
                new DataInfo(Short.MAX_VALUE, 14),
                new DataInfo(Short.MIN_VALUE, 15),
                new DataInfo((short)0, -1),
                new DataInfo((short)1, 0),
                new DataInfo((short)-1, 15));
    }

    public BitwiseUtilHighestSetBitShortTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsShort_thenReturnHighestSetBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.highestSetBitIndex(m_dataInfo.value));
    }
}


