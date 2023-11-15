package org.csystem.tuple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ValueHashCodeTest {
    private final DataInfo m_dataInfo;
    private static final HashSet<Value<String>> m_hs = new HashSet<>(Arrays.asList(new Value<>("ankara"), new Value<>("istanbul")));
    private static class DataInfo {
        Value<String> actual;
        Boolean expected;

        DataInfo(Value<String> actual, Boolean expected)
        {
            this.actual = actual;
            this.expected = expected;
        }
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return List.of(new DataInfo(new Value<>("ankara"), false),
                new DataInfo(new Value<>("istanbul"), false));
    }

    public ValueHashCodeTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenHashSet_thenInvokeAddMethod()
    {
        assertEquals(m_dataInfo.expected, m_hs.add(m_dataInfo.actual));
    }
}



