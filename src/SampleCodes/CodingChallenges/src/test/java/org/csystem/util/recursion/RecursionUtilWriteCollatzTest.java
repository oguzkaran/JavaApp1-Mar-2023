package org.csystem.util.recursion;

import com.karandev.util.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RecursionUtilWriteCollatzTest {
    private final Integer m_str;

    public RecursionUtilWriteCollatzTest(Integer value)
    {
        m_str = value;
    }

    @Parameterized.Parameters
    public static Collection<Integer> createResultInfo()
    {
        return Arrays.asList(72543, 100, 32, 16, 5, 2, 1, 29);
    }

    @Test
    public void givenValue_thenWriteCollatz()
    {
        RecursionUtil.writeCollatz(m_str);
        Console.writeLine();
    }
}
