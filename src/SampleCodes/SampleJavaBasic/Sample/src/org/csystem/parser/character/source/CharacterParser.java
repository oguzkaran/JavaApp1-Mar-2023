package org.csystem.parser.character.source;

import org.csystem.parser.IParser;

public abstract class CharacterParser implements IParser {
    protected ICharacterSource source;

    protected CharacterParser(ICharacterSource source)
    {
        this.source = source;
    }
}
