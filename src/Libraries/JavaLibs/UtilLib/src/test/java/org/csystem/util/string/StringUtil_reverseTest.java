package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtil_reverseTest {
    private final StringStringResultInfo m_stringStringResultInfo;

    @Parameterized.Parameters
    public static Collection<StringStringResultInfo> provideData()
    {
        return Arrays.asList(new StringStringResultInfo("ankara", "arakna"),
                new StringStringResultInfo("alipapila", "alipapila"),
                new StringStringResultInfo("121", "121"),
                new StringStringResultInfo("", ""));
    }

    public StringUtil_reverseTest(StringStringResultInfo stringStringResultInfo)
    {
        m_stringStringResultInfo = stringStringResultInfo;
    }

    @Test
    public void givenString_thenReturnStringChangedCases()
    {
        assertEquals(m_stringStringResultInfo.expected, StringUtil.reverse(m_stringStringResultInfo.text));
    }
}
