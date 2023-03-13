package org.csystem.application.parser;

public class LetterParser extends Parser {
    public LetterParser()
    {
    }

    public LetterParser(ISource source)
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

            while ((ch = source.nextChar()) != -1) {
                System.out.print((char)ch);
                if (Character.isLetter(ch))
                    ++count;
            }

            System.out.println();
            return count;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return -1;
    }
}
