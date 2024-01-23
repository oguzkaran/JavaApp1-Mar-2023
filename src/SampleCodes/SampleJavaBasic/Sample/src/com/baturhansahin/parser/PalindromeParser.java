package com.baturhansahin.parser;

import org.csystem.parser.character.source.CharacterParser;
import org.csystem.parser.character.source.ICharacterSource;
import org.csystem.util.string.StringUtil;

public class PalindromeParser extends CharacterParser {
    private String m_text;
    private boolean m_palindrome;
    private boolean m_parsed;

    public PalindromeParser(ICharacterSource source)
    {
        super(source);
    }

    public String getText()
    {
        return m_text;
    }

    public boolean isPalindrome()
    {
        return m_palindrome;
    }

    public boolean isParsed()
    {
        return m_parsed;
    }

    public void parse() throws Exception
    {
        StringBuilder sb = new StringBuilder();
        int ch;

        while ((ch = source.nextChar()) != -1)
            sb.append((char)ch);

        m_parsed = true;
        m_text = sb.toString();
        m_palindrome = StringUtil.isPalindrome(m_text);
    }
}
