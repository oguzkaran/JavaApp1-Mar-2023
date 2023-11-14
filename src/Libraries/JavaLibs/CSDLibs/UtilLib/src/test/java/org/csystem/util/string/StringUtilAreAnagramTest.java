package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilAreAnagramTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        String s1;
        String s2;

        boolean expected;

        DataInfo(String s1, String s2, boolean expected)
        {
            this.s1 = s1;
            this.s2 = s2;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo("bart", "brat", true),
                new DataInfo("para", "arap", true),
                new DataInfo("bart", "btrat", false),
                new DataInfo("bart", "art", false)
        );
    }

    public StringUtilAreAnagramTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_thenReturnAreAnagramPredicate()
    {
        assertEquals(m_dataInfo.expected, StringUtil.areAnagram(m_dataInfo.s1, m_dataInfo.s2));
    }
}
