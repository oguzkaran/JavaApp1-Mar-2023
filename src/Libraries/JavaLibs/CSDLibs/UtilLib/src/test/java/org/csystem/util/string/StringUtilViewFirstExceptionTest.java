package org.csystem.util.string;

import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class StringUtilViewFirstExceptionTest {
    @Test
    public void givenString_thenReturnStringChangedCases()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> StringUtil.viewFirst("", '*'));
    }
}
