package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilIndicesOfSetBitsByteTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        byte value;
        int [] expected;

        public DataInfo(byte value, int[] expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo((byte)10, new int[] {1, 3}),
                new DataInfo((byte)11, new int [] {0, 1, 3}),
                new DataInfo(Byte.MAX_VALUE, new int [] {0, 1, 2, 3, 4, 5, 6}),
                new DataInfo(Byte.MIN_VALUE, new int[] {7}),
                new DataInfo((byte)0, new int[0]),
                new DataInfo((byte)1, new int[] {0}),
                new DataInfo((byte)-1, new int [] {0, 1, 2, 3, 4, 5, 6, 7}));
    }

    public BitwiseUtilIndicesOfSetBitsByteTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValue_whenValueIsByte_thenReturnNumberOfSetBits()
    {
        assertArrayEquals(m_dataInfo.expected, BitwiseUtil.indicesOfSetBits(m_dataInfo.value));
    }
}
