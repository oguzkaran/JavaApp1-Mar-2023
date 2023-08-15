package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilViewFirstTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        String text;
        String expected;

        DataInfo(String text, String expected)
        {
            this.text = text;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo("AnKaRa", "A*****"),
                new DataInfo("Arman", "A****"),
                new DataInfo("Bartu", "B****"),
                new DataInfo("a", "a"));
    }

    public StringUtilViewFirstTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_thenReturnStringChangedCases()
    {
        assertEquals(m_dataInfo.expected, StringUtil.viewFirst(m_dataInfo.text, '*'));
    }
}
