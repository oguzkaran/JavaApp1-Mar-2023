package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtil_squeezeTest {
    private final StringStringStringResultInfo m_stringStringStringResultInfo;

    @Parameterized.Parameters
    public static Collection<StringStringStringResultInfo> provideData()
    {
        return Arrays.asList(new StringStringStringResultInfo("ankara", "adana", "kr"),
                new StringStringStringResultInfo("adana", "ankara", "d"),
                new StringStringStringResultInfo("xyz", "abc", "xyz"),
                new StringStringStringResultInfo("", "", ""));
    }

    public StringUtil_squeezeTest(StringStringStringResultInfo stringStringStringResultInfo)
    {
        m_stringStringStringResultInfo = stringStringStringResultInfo;
    }

    @Test
    public void givenString_thenReturnStringChangedCases()
    {
        assertEquals(m_stringStringStringResultInfo.expected, StringUtil.squeeze(m_stringStringStringResultInfo.text1, m_stringStringStringResultInfo.text2));
    }
}
