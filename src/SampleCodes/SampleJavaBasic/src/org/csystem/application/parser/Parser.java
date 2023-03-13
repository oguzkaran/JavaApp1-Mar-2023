package org.csystem.application.parser;

public abstract class Parser {
    protected ISource source;

    public Parser()
    {
    }

    public Parser(ISource source)
    {
        //...
        this.source = source;
    }

    public abstract int doParse();
}
