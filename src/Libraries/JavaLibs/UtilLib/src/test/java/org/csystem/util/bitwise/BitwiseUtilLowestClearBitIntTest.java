package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilLowestClearBitIntTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int value;
        int expected;

        public DataInfo(int value, int expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10, 0),
                new DataInfo(11, 2),
                new DataInfo(Integer.MAX_VALUE, 31),
                new DataInfo(Integer.MIN_VALUE, 0),
                new DataInfo(0, 0),
                new DataInfo(1, 1),
                new DataInfo(-1, -1));
    }

    public BitwiseUtilLowestClearBitIntTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsInt_thenReturnLowestClearBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.lowestClearBitIndex(m_dataInfo.value));
    }
}
