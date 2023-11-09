package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilAreAllUniqueIgnoreCaseTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        String text;
        boolean expected;

        DataInfo(String text, boolean expected)
        {
            this.text = text;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(
                new DataInfo("abcXyz", true),
                new DataInfo("abcxyzC", false),
                new DataInfo("", true),
                new DataInfo("x", true),
                new DataInfo("zZ", false)
        );
    }

    public StringUtilAreAllUniqueIgnoreCaseTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_thenReturnAreAllUniqueIgnoreCasePredicate()
    {
        assertEquals(m_dataInfo.expected, StringUtil.areAllUniqueIgnoreCase(m_dataInfo.text));
    }
}

