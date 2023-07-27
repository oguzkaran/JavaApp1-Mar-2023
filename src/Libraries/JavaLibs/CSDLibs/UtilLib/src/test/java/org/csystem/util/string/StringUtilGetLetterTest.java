package org.csystem.util.string;

import com.karandev.util.console.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilGetLetterTest {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        int testIndex;
        String text;
        String expected;

        DataInfo(int testIndex, String text, String expected)
        {
            this.testIndex = testIndex;
            this.text = text;
            this.expected = expected;
        }
    }

    @Before
    public void setUp()
    {
        Console.writeLine("--------------------------------------------------------------------------------------------------");
        Console.writeLine("Test will start -> Text Index:%d, Text:%s, Expected:%s", m_dataInfo.testIndex, m_dataInfo.text, m_dataInfo.expected);
    }

    @After
    public void tearDown()
    {
        Console.writeLine("Test ended -> Text Index:%d, Text:%s, Expected:%s", m_dataInfo.testIndex, m_dataInfo.text, m_dataInfo.expected);
        Console.writeLine("--------------------------------------------------------------------------------------------------");
    }

    @Parameterized.Parameters
    public static Collection<DataInfo> provideData()
    {
        return Arrays.asList(new DataInfo(0, "ankara1234istanbul?      .)", "ankaraistanbul"),
                new DataInfo(1, "ankara", "ankara"),
                new DataInfo(2, "12345.?)", ""));
    }

    public StringUtilGetLetterTest(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void givenString_whenMixedCharacter_thenReturnStringJustLetters()
    {
        Console.writeLine("Test started -> Text Index:%d, Text:%s, Expected:%s", m_dataInfo.testIndex, m_dataInfo.text, m_dataInfo.expected);
        assertEquals(m_dataInfo.expected, StringUtil.getLetters(m_dataInfo.text));
    }
}
