package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilAreAllUniqueTest {
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
                new DataInfo("abcxyz", true),
                new DataInfo("abcxyzC", true),
                new DataInfo("abcxyzc", false),
                new DataInfo("", true),
                new DataInfo("x", true),
                new DataInfo("zz", false)
        );
    }

    public StringUtilAreAllUniqueTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_thenReturnAreAllUniquePredicate()
    {
        assertEquals(m_dataInfo.expected, StringUtil.areAllUnique(m_dataInfo.text));
    }
}
