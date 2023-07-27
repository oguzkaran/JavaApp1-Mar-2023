package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountClearBitsIntTest {
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
        return Arrays.asList(new DataInfo(10, 30),
                new DataInfo(11, 29),
                new DataInfo(Integer.MAX_VALUE, 1),
                new DataInfo(Integer.MIN_VALUE, 31),
                new DataInfo(0, 32),
                new DataInfo(1, 31),
                new DataInfo(-1, 0));
    }

    public BitwiseUtilCountClearBitsIntTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsInt_thenReturnNumberOfClearBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countClearBits(m_dataInfo.value));
    }
}
