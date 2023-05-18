package org.csystem.util.recursion;

import com.karandev.util.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilWriteReverseTest {
    private final String m_str;

    public UtilWriteReverseTest(String str)
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
        Util.writeReverse(m_str);
        Console.writeLine();
    }
}
