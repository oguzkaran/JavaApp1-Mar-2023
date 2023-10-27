/*----------------------------------------------------------------------
    FILE        : Stream.java
    AUTHOR      : Oguz Karan
    LAST UPDATE : 30.09.2020

    Unchecked exception class for io applications

    Copyleft (c) 1993 by C and System Programmers Association (CSD)
    All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io;

public class StreamException extends RuntimeException {
    public StreamException()
    {
    }

    public StreamException(String message)
    {
        this(message, null);
    }

    public StreamException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        Throwable cause = getCause();

        return String.format("{message : %s%s", super.getMessage(), cause != null ? ", causeMessage : " + cause.getMessage()  + "}": "}");
    }
}
