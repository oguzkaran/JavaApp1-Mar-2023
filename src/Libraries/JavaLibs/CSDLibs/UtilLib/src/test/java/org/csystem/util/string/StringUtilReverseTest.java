package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilReverseTest {
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
        return Arrays.asList(new DataInfo("ankara", "arakna"),
                new DataInfo("alipapila", "alipapila"),
                new DataInfo("121", "121"),
                new DataInfo("", ""));
    }

    public StringUtilReverseTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_thenReturnReversed()
    {
        assertEquals(m_dataInfo.expected, StringUtil.reverse(m_dataInfo.text));
    }
}
