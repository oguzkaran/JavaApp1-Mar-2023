package org.csystem.util.recursion;

import com.karandev.util.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RecursionUtilWriteReverseTest {
    private final String m_str;

    public RecursionUtilWriteReverseTest(String str)
    {
        m_str = str;
    }

    @Parameterized.Parameters
    public static Collection<String> createResultInfo()
    {
        return Arrays.asList("ankara", "alipapila", "istanbul", "anastasmumsatsana", "csd");
    }

    @Test
    public void givenValue_thenWriteReverse()
    {
        RecursionUtil.writeReverse(m_str);
        Console.writeLine();
    }
}
