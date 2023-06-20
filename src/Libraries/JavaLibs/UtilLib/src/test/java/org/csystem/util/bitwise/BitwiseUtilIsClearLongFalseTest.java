package org.csystem.util.bitwise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

@RunWith(Parameterized.class)
public class BitwiseUtilIsClearLongFalseTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long value;
        int k;

        DataInfo(long value, int k)
        {
            this.value = value;
            this.k = k;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(0b00101110, 3),
                new DataInfo(0b00101010, 1),
                new DataInfo(0b10101110, 7));
    }

    public BitwiseUtilIsClearLongFalseTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenValueAndBitIndex_whenValueIsLong_thenReturnFalse()
    {
        assertFalse(BitwiseUtil.isClear(m_dataInfo.value, m_dataInfo.k));
    }
}
