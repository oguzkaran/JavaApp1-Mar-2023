package org.csystem.util.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilReverseTest {
    private final ResultInfo m_resultInfo;

    private static class ResultInfo {
        String str;
        String expected;

        public ResultInfo(String str, String expected)
        {
            this.str = str;
            this.expected = expected;
        }
    }

    public UtilReverseTest(ResultInfo resultInfo)
    {
        m_resultInfo = resultInfo;
    }

    @Parameterized.Parameters
    public static Collection<ResultInfo> createResultInfo()
    {
        return Arrays.asList(new ResultInfo("ankara", "arakna"),
                new ResultInfo("istanbul", "lubnatsi"),
                new ResultInfo("istabul", "lubatsi"),
                new ResultInfo("alipapila", "alipapila"),
                new ResultInfo("csd", "dsc"));
    }

    @Test
    public void givenValue_thenReturnsReversed()
    {
        assertEquals(m_resultInfo.str, Util.reverse(m_resultInfo.expected));
    }
}
