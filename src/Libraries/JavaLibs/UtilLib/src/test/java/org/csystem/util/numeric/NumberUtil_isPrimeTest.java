package org.csystem.util.numeric;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtil_isPrimeTest {
    @Test
    public void givenLongValue_whenPrime_thenReturnTrue()
    {
        var input = 710584055392819667L;
        var expected = true;

        Assert.assertEquals(String.format("%d must be prime", input), expected, NumberUtil.isPrime(input));
    }

    @Test
    public void givenLongValue_whenNotPrime_thenReturnFalse()
    {
        var input = 2;
        var expected = false;

        Assert.assertEquals(expected, NumberUtil.isPrime(input));
    }
}
