package org.csystem.util.string;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StringUtilIsJavaIdentifierFalseTest {
    private final String m_str;


    @Parameterized.Parameters
    public static Collection<String> provideData()
    {
        return Arrays.asList("_", "1abc", "number of", "number of students", "1", "a-123", " ");
    }

    public StringUtilIsJavaIdentifierFalseTest(String str)
    {
        m_str = str;
    }

    @Test
    public void test()
    {
        assertFalse(StringUtil.isJavaIdentifier(m_str));
    }
}
