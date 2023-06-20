package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilLowestClearBitShortTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        short value;
        int expected;

        public DataInfo(short value, int expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((short)10, 0),
                new DataInfo((short)11, 2),
                new DataInfo(Short.MAX_VALUE, 15),
                new DataInfo(Short.MIN_VALUE, 0),
                new DataInfo((short)0, 0),
                new DataInfo((short)1, 1),
                new DataInfo((short)-1, -1));
    }

    public BitwiseUtilLowestClearBitShortTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsShort_thenReturnLowestClearBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.lowestClearBitIndex(m_dataInfo.value));
    }
}