package org.csystem.util.recursion;

import com.karandev.util.console.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilWriteNumberTest {
    private final InputInfo m_inputInfo;

    private static class InputInfo {
        int value;
        int radix;

        public InputInfo(int value, int radix)
        {
            this.value = value;
            this.radix = radix;
        }
    }

    public UtilWriteNumberTest(InputInfo inputInfo)
    {
        m_inputInfo = inputInfo;
    }

    @Parameterized.Parameters
    public static Collection<InputInfo> createResultInfo()
    {
        return Arrays.asList(new InputInfo(0, 10),
                new InputInfo(10, 10),
                new InputInfo(8128, 16),
                new InputInfo(10, 8),
                new InputInfo(16, 2),
                new InputInfo(-8, 2),
                new InputInfo(2_000_000_000, 2),
                new InputInfo(Integer.MAX_VALUE, 2)
                );
    }

    @Test
    public void givenValues_whenValueAndRadix_thenWriteNumber()
    {
        Util.writeNumber(m_inputInfo.value, m_inputInfo.radix);
        Console.writeLine();
    }
}
