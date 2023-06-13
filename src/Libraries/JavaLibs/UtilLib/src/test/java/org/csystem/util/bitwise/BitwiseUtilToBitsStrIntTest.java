package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilToBitsStrIntTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int value;
        String expected;

        public DataInfo(int value, String expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10, "00000000000000000000000000001010"),
                new DataInfo(11, "00000000000000000000000000001011"),
                new DataInfo(Integer.MAX_VALUE, "01111111111111111111111111111111"),
                new DataInfo(Integer.MIN_VALUE, "10000000000000000000000000000000"),
                new DataInfo(0, "00000000000000000000000000000000"),
                new DataInfo(1, "00000000000000000000000000000001"));
    }

    public BitwiseUtilToBitsStrIntTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsInt_thenReturnBitString()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.toBitsStr(m_dataInfo.value));
    }
}
