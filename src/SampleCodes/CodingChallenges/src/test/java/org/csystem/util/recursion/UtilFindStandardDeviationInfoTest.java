/*----------------------------------------------------------------------------------------------------------------------
    Question: Calculate standard deviation: The function calculates the mean and the standard deviation of the array
    not using recursion
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UtilFindStandardDeviationInfoTest {
    private final ResultInfo m_resultInfo;

    private static class ResultInfo {
        int [] a;
        StandardDeviationInfo expected;

        public ResultInfo(int[] a, StandardDeviationInfo expected)
        {
            this.a = a;
            this.expected = expected;
        }
    }

    public UtilFindStandardDeviationInfoTest(ResultInfo resultInfo)
    {
        m_resultInfo = resultInfo;
    }

    @Parameterized.Parameters
    public static Collection<ResultInfo> createResultInfo()
    {
        return Arrays.asList();
    }

    @Test
    public void givenIntArray_thenReturnsStandardDeviationInfo()
    {
        //...
    }
}
