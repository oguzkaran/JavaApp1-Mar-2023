package org.csystem.application.parser;

public class ParseFactory {
    //...
    public Parser getParser(ParserType parserType, ISource source)
    {
        Parser parser = null;

        switch (parserType) {
            case DIGIT:
                parser = new DigitParser(source);
                break;

            case LETTER:
                parser = new LetterParser(source);
                break;
            case WHITESPACE:
                parser = new WhitespaceParser(source);
                break;
        }

        return parser;
    }
    //...
}
