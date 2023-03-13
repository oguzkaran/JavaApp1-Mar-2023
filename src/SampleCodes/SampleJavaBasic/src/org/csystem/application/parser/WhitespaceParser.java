package org.csystem.application.parser;

public class WhitespaceParser extends Parser {
    public WhitespaceParser()
    {
    }

    public WhitespaceParser(ISource source)
    {
        super(source);
        //...
    }

    public ISource getSource()
    {
        return source;
    }

    public void setSource(ISource source)
    {
        //...
        this.source = source;
    }

    public int doParse()
    {
        try {
            source.reset();
            int count = 0;

            int ch;

            while ((ch = source.nextChar()) != -1)
                if (Character.isWhitespace(ch))
                    ++count;

            return count;
        }
        catch (Exception ignore) {

        }

        return -1;
    }
}
