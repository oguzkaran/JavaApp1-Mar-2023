package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilSqueezeTest {
    private final DataInfo m_stringStringStringResultInfo;

    private static class DataInfo {
        String text1;
        String text2;
        String expected;

        DataInfo(String text1, String text2, String expected)
        {
            this.text1 = text1;
            this.text2 = text2;
            this.expected = expected;
        }
    }
    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo("ankara", "adana", "kr"),
                new DataInfo("adana", "ankara", "d"),
                new DataInfo("xyz", "abc", "xyz"),
                new DataInfo("", "", ""));
    }

    public StringUtilSqueezeTest(DataInfo stringStringStringResultInfo)
    {
        m_stringStringStringResultInfo = stringStringStringResultInfo;
    }

    @Test
    public void givenTwoString_thenReturnStringSqueezed()
    {
        assertEquals(m_stringStringStringResultInfo.expected, StringUtil.squeeze(m_stringStringStringResultInfo.text1, m_stringStringStringResultInfo.text2));
    }
}
