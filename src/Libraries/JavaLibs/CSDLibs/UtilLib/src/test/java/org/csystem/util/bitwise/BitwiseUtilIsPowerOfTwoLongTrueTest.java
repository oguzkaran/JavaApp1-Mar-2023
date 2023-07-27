package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BitwiseUtilIsPowerOfTwoLongTrueTest {
    private final long m_value;


    @Parameterized.Parameters
    public static Collection<Long> provideData()
    {
        return Arrays.asList(2L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L, 4096L, 8192L);
    }

    public BitwiseUtilIsPowerOfTwoLongTrueTest(long value)
    {
        m_value = value;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnTrue()
    {
        assertTrue(BitwiseUtil.isPowerOfTwo(m_value));
    }
}
