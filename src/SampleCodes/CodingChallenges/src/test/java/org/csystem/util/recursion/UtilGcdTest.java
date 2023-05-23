package org.csystem.util.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilGcdTest {
    private final ResultInfo m_resultInfo;

    private static class ResultInfo {
        int a;
        int b;
        int expected;

        public ResultInfo(int a, int b, int expected)
        {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    public UtilGcdTest(ResultInfo resultInfo)
    {
        m_resultInfo = resultInfo;
    }

    @Parameterized.Parameters
    public static Collection<ResultInfo> createResultInfo()
    {
        return Arrays.asList(new ResultInfo(3, 4, 1),
                new ResultInfo(30, 40, 10),
                new ResultInfo(6, 8, 2),
                new ResultInfo(4, 8, 4),
                new ResultInfo(24, 18, 6));
    }

    @Test
    public void givenValues_thenReturnsGcd()
    {
        assertEquals(m_resultInfo.expected, Util.gcd(m_resultInfo.a, m_resultInfo.b));
    }
}
