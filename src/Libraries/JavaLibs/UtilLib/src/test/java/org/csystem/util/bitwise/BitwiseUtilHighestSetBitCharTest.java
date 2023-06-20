package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilHighestSetBitCharTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        char value;
        int expected;

        public DataInfo(char value, int expected) {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((char)10, 3),
                new DataInfo((char)11, 3),
                new DataInfo(Character.MAX_VALUE, 15),
                new DataInfo(Character.MIN_VALUE, -1),
                new DataInfo((char)0, -1),
                new DataInfo((char)1, 0));
    }

    public BitwiseUtilHighestSetBitCharTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsChar_thenReturnHighestSetBit()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.highestSetBitIndex(m_dataInfo.value));
    }
}


