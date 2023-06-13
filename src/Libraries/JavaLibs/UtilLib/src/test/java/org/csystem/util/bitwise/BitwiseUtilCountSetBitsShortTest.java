package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountSetBitsShortTest {
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
        return Arrays.asList(new DataInfo((short)10, 2),
                new DataInfo((short)11, 3),
                new DataInfo(Short.MAX_VALUE, 15),
                new DataInfo(Short.MIN_VALUE, 1),
                new DataInfo((short)0, 0),
                new DataInfo((short)1, 1),
                new DataInfo((short)-1, 16));
    }

    public BitwiseUtilCountSetBitsShortTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsByte_thenReturnNumberOfSetBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countSetBits(m_dataInfo.value));
    }
}
