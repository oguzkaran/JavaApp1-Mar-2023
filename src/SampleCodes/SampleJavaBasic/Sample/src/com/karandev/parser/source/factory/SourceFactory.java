package com.karandev.parser.source.factory;

import com.alicankececi.parser.source.CharArraySource;
import com.boraserce.parser.source.StandardInputSource;
import com.emrekantarci.parser.source.StringSource;
import org.csystem.parser.character.source.ICharacterSource;
import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class SourceFactory {
    private final RandomGenerator m_randomGenerator = new Random();

    public ICharacterSource create()
    {
        return switch (m_randomGenerator.nextInt(4)) {
            case 0 -> new StringSource(StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15)));
            case 1 -> new StringSource(StringUtil.getRandomText(m_randomGenerator, m_randomGenerator.nextInt(5, 15), "1234567890abcdexyqQ:?/"));
            case 2 -> new CharArraySource(StringUtil.getRandomText(m_randomGenerator, m_randomGenerator.nextInt(5, 15), "1234567890abcdexyqQ:?/"));
            default -> new CharArraySource(StringUtil.getRandomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15)));
        };
    }
}
