package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountSetBitsIntTest {
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
        return Arrays.asList(new DataInfo(10, 2),
                new DataInfo(11, 3),
                new DataInfo(Integer.MAX_VALUE, 31),
                new DataInfo(Integer.MIN_VALUE, 1),
                new DataInfo(0, 0),
                new DataInfo(1, 1),
                new DataInfo(-1, 32));
    }

    public BitwiseUtilCountSetBitsIntTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsInt_thenReturnNumberOfSetBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countSetBits(m_dataInfo.value));
    }
}
