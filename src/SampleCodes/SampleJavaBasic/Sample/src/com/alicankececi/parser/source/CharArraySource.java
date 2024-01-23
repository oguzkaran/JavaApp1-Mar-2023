package com.alicankececi.parser.source;

import org.csystem.parser.character.source.ICharacterSource;

import java.util.Arrays;

public class CharArraySource implements ICharacterSource {
    private final char [] m_chars;
    private int m_index;


    public CharArraySource(String s)
    {
        this(s.toCharArray());
    }
    public CharArraySource(char[] chars)
    {
        m_chars = Arrays.copyOf(chars, chars.length);
    }

    public int nextChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }
}
