package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilToBitsStrLongTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        String expected;

        public DataInfo(long value, String expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList
                (new DataInfo(10L,"0000000000000000000000000000000000000000000000000000000000001010"),
                new DataInfo(11L,"0000000000000000000000000000000000000000000000000000000000001011"),
                new DataInfo(Long.MAX_VALUE,"0111111111111111111111111111111111111111111111111111111111111111"),
                new DataInfo(Long.MIN_VALUE,"1000000000000000000000000000000000000000000000000000000000000000"),
                new DataInfo(0L,"0000000000000000000000000000000000000000000000000000000000000000"),
                new DataInfo(1L,"0000000000000000000000000000000000000000000000000000000000000001"),
                new DataInfo(2L,"0000000000000000000000000000000000000000000000000000000000000010"));
    }

    public BitwiseUtilToBitsStrLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsLong_thenReturnBitString()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.toBitsStr(m_dataInfo.value));
    }
}
