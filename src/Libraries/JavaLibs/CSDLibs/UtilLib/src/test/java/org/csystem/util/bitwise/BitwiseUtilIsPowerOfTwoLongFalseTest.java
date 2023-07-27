package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class BitwiseUtilIsPowerOfTwoLongFalseTest {
    private final long m_value;


    @Parameterized.Parameters
    public static Collection<Long> provideData()
    {
        return Arrays.asList(0L, 15L, 14L, 7L, 19L, -12L, -2048L);
    }

    public BitwiseUtilIsPowerOfTwoLongFalseTest(long value)
    {
        m_value = value;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnFalse()
    {
        assertFalse(BitwiseUtil.isPowerOfTwo(m_value));
    }
}
