package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class BitwiseUtilPowerOfTwoFalseTest {
    private final int m_value;


    @Parameterized.Parameters
    public static Collection<Integer> provideData()
    {
        return Arrays.asList(0, 15, 14, 7, 19, -12, -2048);
    }

    public BitwiseUtilPowerOfTwoFalseTest(int value)
    {
        m_value = value;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsInt_thenReturnFalse()
    {
        assertFalse(BitwiseUtil.isPowerOfTwo(m_value));
    }
}
