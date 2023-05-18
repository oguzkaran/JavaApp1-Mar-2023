package org.csystem.util.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UtilFactorialTest {
    private final ResultInfo m_resultInfo;

    private static class ResultInfo {
        int n;
        long expected;

        public ResultInfo(int n, long expected)
        {
            this.n = n;
            this.expected = expected;
        }
    }

    public UtilFactorialTest(ResultInfo resultInfo)
    {
        m_resultInfo = resultInfo;
    }

    @Parameterized.Parameters
    public static Collection<ResultInfo> createResultInfo()
    {
        return Arrays.asList(new ResultInfo(0, 1),
                new ResultInfo(1, 1),
                new ResultInfo(4, 24),
                new ResultInfo(5, 120),
                new ResultInfo(6, 720));
    }

    @Test
    public void givenValue_thenReturnsFactorial()
    {
        assertEquals(m_resultInfo.expected, Util.factorial(m_resultInfo.n));
    }
}
