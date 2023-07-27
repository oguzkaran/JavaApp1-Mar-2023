package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilCountClearBitsCharTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        char value;
        int expected;

        public DataInfo(char value, int expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((char)10, 14),
                new DataInfo((char)11, 13),
                new DataInfo(Character.MAX_VALUE, 0),
                new DataInfo(Character.MIN_VALUE, 16),
                new DataInfo((char)0, 16),
                new DataInfo((char)1, 15),
                new DataInfo((char)-1, 0));
    }

    public BitwiseUtilCountClearBitsCharTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsChar_thenReturnNumberOfClearBits()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.countClearBits(m_dataInfo.value));
    }
}
