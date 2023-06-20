package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilToBitsStrCharTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        char value;
        String expected;

        public DataInfo(char value, String expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((char)10, "0000000000001010"),
                new DataInfo((char)11, "0000000000001011"),
                new DataInfo(Character.MAX_VALUE, "1111111111111111"),
                new DataInfo(Character.MIN_VALUE, "0000000000000000"),
                new DataInfo((char)0, "0000000000000000"),
                new DataInfo((char)1, "0000000000000001"));
    }

    public BitwiseUtilToBitsStrCharTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsChar_thenReturnBitString()
    {
        assertEquals(m_dataInfo.expected, BitwiseUtil.toBitsStr(m_dataInfo.value));
    }
}
