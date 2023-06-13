package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BitwiseUtilPowerOfTwoTrueTest {
    private final int m_value;


    @Parameterized.Parameters
    public static Collection<Integer> provideData()
    {
        return Arrays.asList(2, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192);
    }

    public BitwiseUtilPowerOfTwoTrueTest(int value)
    {
        m_value = value;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsInt_thenReturnTrue()
    {
        assertTrue(BitwiseUtil.isPowerOfTwo(m_value));
    }
}
