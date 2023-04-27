package org.csystem.util.string;

import static org.junit.Assert.*;

import com.karandev.util.console.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class StringUtil_getLetterTest {
    private final StringStringWithIndexResultInfo m_stringStringWithIndexResultInfo;

    @Before
    public void setUp()
    {
        Console.writeLine("--------------------------------------------------------------------------------------------------");
        Console.writeLine("Test will start -> Text Index:%d, Text:%s, Expected:%s", m_stringStringWithIndexResultInfo.testIndex, m_stringStringWithIndexResultInfo.text, m_stringStringWithIndexResultInfo.expected);
    }

    @After
    public void tearDown()
    {
        Console.writeLine("Test ended -> Text Index:%d, Text:%s, Expected:%s", m_stringStringWithIndexResultInfo.testIndex, m_stringStringWithIndexResultInfo.text, m_stringStringWithIndexResultInfo.expected);
        Console.writeLine("--------------------------------------------------------------------------------------------------");
    }

    @Parameterized.Parameters
    public static Collection<StringStringWithIndexResultInfo> provideData()
    {
        return Arrays.asList(new StringStringWithIndexResultInfo(0, "ankara1234istanbul?      .)", "ankaraistanbul"),
                new StringStringWithIndexResultInfo(1, "ankara", "ankara"),
                new StringStringWithIndexResultInfo(2, "12345.?)", ""));
    }

    public StringUtil_getLetterTest(StringStringWithIndexResultInfo stringStringWithIndexResultInfo)
    {
        m_stringStringWithIndexResultInfo = stringStringWithIndexResultInfo;
    }

    @Test
    public void givenString_whenMixedCharacter_thenReturnStringJustLetters()
    {
        Console.writeLine("Test started -> Text Index:%d, Text:%s, Expected:%s", m_stringStringWithIndexResultInfo.testIndex, m_stringStringWithIndexResultInfo.text, m_stringStringWithIndexResultInfo.expected);
        assertEquals(m_stringStringWithIndexResultInfo.expected, StringUtil.getLetters(m_stringStringWithIndexResultInfo.text));
    }
}
