package org.csystem.util.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class StringUtilIsJavaIdentifierTrueTest {
    private final String m_str;


    @Parameterized.Parameters
    public static Collection<String> provideData()
    {
        return Arrays.asList("numberOfStudents", "a1234", "_1234", "$", "$123", "_$", "$_");
    }

    public StringUtilIsJavaIdentifierTrueTest(String str)
    {
        m_str = str;
    }

    @Test
    public void test()
    {
        assertTrue(StringUtil.isJavaIdentifier(m_str));
    }
}
