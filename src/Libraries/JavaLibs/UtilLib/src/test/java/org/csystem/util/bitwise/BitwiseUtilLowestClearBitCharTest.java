package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilLowestClearBitCharTest {
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
        return Arrays.asList(new DataInfo((char)10, 0),
                new DataInfo((char)11, 2),
                new DataInfo(Character.MAX_VALUE, -1),
                new DataInfo(Character.MIN_VALUE, 0),
                new DataInfo((char)0, 0),
                new DataInfo((char)1, 1),
                new DataInfo((char)-1, -1),
                new DataInfo('\u0000', 0),
                new DataInfo('翿', 15)); // \u7FFF
    }

    public BitwiseUtilLowestClearBitCharTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsChar_thenReturnLowestClearBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.lowestClearBitIndex(m_dataInfo.value));
    }
}
