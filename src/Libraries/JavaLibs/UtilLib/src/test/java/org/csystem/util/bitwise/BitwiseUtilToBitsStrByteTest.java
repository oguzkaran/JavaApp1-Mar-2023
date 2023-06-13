package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilToBitsStrByteTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        byte value;
        String expected;

        public DataInfo(byte value, String expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((byte)10, "00001010"),
                new DataInfo((byte)11, "00001011"),
                new DataInfo(Byte.MAX_VALUE, "01111111"),
                new DataInfo(Byte.MIN_VALUE, "10000000"),
                new DataInfo((byte)0, "00000000"),
                new DataInfo((byte)1, "00000001"));
    }

    public BitwiseUtilToBitsStrByteTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsByte_thenReturnBitString()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.toBitsStr(m_dataInfo.value));
    }
}
