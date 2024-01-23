package com.boraserce.parser.source;

import com.emrekantarci.parser.source.StringSource;

import java.util.Scanner;

public class StandardInputSource extends StringSource {
    public StandardInputSource()
    {
        super(new Scanner(System.in).nextLine());
    }

    public int nextChar()
    {
        return super.nextChar();
    }
}
