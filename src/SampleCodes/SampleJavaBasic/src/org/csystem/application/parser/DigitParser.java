package org.csystem.application.parser;

public class DigitParser extends Parser {

    public DigitParser()
    {
    }

    public DigitParser(ISource source)
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
            int ch;
            int count = 0;

            while ((ch = source.nextChar()) != -1)
                if (Character.isDigit(ch))
                    ++count;

            return count;
        }
        catch (Exception ignore) {

        }

        return -1;
    }
}
