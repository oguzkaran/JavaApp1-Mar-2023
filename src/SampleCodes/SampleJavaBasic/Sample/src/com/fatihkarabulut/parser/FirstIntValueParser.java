package com.fatihkarabulut.parser;

import org.csystem.parser.character.ICharacterSourceParser;
import org.csystem.parser.character.source.ICharacterSource;
import org.csystem.util.console.Console;

public class FirstIntValueParser implements ICharacterSourceParser {
    private int m_value;

    public int getValue()
    {
        return m_value;
    }

    public void parse(ICharacterSource source)
    {
        StringBuilder sb = new StringBuilder();
        int ch;

        try {
            while ((ch = source.nextChar()) != -1) {
                if (!Character.isDigit(ch))
                    break;

                sb.append((char)ch);
            }

            m_value = Integer.parseInt(sb.toString());
        }
        catch (Exception ignore) {
            throw new NumberFormatException();
        }
    }
}
