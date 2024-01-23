package com.onurozcan.parser.letter;

import org.csystem.parser.character.source.CharacterParser;
import org.csystem.parser.character.source.ICharacterSource;

public class LetterParser extends CharacterParser {
    private String m_letters;
    private String m_text;

    public LetterParser(ICharacterSource source)
    {
        super(source);
    }

    public String getLetters()
    {
        return m_letters;
    }

    public String getText()
    {
        return m_text;
    }

    public void parse() throws Exception
    {
        StringBuilder letters = new StringBuilder();
        StringBuilder text = new StringBuilder();
        int ch;

        while ((ch = source.nextChar()) != -1) {
            text.append((char)ch);
            if (Character.isLetter(ch))
                letters.append((char)ch);
        }

        m_text = text.toString();
        m_letters = letters.toString();
    }
}
