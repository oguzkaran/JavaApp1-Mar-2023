package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilToBitsStrShortTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        short value;
        String expected;

        public DataInfo(short value, String expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((short)10, "0000000000001010"),
                new DataInfo((short)11, "0000000000001011"),
                new DataInfo(Short.MAX_VALUE, "0111111111111111"),
                new DataInfo(Short.MIN_VALUE, "1000000000000000"),
                new DataInfo((short)0, "0000000000000000"),
                new DataInfo((short)1, "0000000000000001"));
    }

    public BitwiseUtilToBitsStrShortTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsShort_thenReturnBitString()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.toBitsStr(m_dataInfo.value));
    }
}
