package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilIndicesOfSetBitsLongTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        int [] expected;

        public DataInfo(long value, int[] expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10L, new int[] {1, 3}),
                new DataInfo(11L, new int [] {0, 1, 3}),
                new DataInfo(Long.MAX_VALUE, new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
                        38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
                        58, 59, 60, 61, 62}),
                new DataInfo(Long.MIN_VALUE, new int[] {63}),
                new DataInfo(0, new int[0]),
                new DataInfo(1L, new int[] {0}),
                new DataInfo(-1L, new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 ,33 ,34, 35, 36,
                        37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
                        58, 59, 60, 61, 62, 63}));
    }

    public BitwiseUtilIndicesOfSetBitsLongTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnNumberOfSetBits()
    {
        assertArrayEquals(m_dataInfo.expected, BitwiseUtil.indicesOfSetBits(m_dataInfo.value));
    }
}
