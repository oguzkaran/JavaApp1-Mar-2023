package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class BitwiseUtilIndicesOfSetBitsIntTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int value;
        int [] expected;

        public DataInfo(int value, int[] expected)
        {
            this.value = value;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(10, new int[] {1, 3}),
                new DataInfo(11, new int [] {0, 1, 3}),
                new DataInfo(Integer.MAX_VALUE, new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}),
                new DataInfo(Integer.MIN_VALUE, new int[] {31}),
                new DataInfo(0, new int[0]),
                new DataInfo(1, new int[] {0}),
                new DataInfo(-1, new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}));
    }

    public BitwiseUtilIndicesOfSetBitsIntTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsInt_thenReturnNumberOfSetBits()
    {
        assertArrayEquals(m_dataInfo.expected, BitwiseUtil.indicesOfSetBits(m_dataInfo.value));
    }
}
