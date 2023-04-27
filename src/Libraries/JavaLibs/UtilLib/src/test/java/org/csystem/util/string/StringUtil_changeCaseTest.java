package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtil_changeCaseTest {
    private final StringStringResultInfo m_stringStringResultInfo;

    @Parameterized.Parameters
    public static Collection<StringStringResultInfo> provideData()
    {
        return Arrays.asList(new StringStringResultInfo("AnKaRa", "aNkArA"),
                new StringStringResultInfo("ankara", "ANKARA"),
                new StringStringResultInfo("1234", "1234"),
                new StringStringResultInfo("", ""));
    }

    public StringUtil_changeCaseTest(StringStringResultInfo stringStringResultInfo)
    {
        m_stringStringResultInfo = stringStringResultInfo;
    }

    @Test
    public void givenString_thenReturnStringChangedCases()
    {
        assertEquals(m_stringStringResultInfo.expected, StringUtil.changeCase(m_stringStringResultInfo.text));
    }
}
