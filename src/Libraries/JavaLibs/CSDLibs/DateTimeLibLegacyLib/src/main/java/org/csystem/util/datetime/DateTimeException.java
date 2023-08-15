package org.csystem.util.datetime;

@Deprecated(since = "Java 9: Use Java 8 DateTime API classes", forRemoval = true)
public class DateTimeException extends RuntimeException  {
    public DateTimeException()
    {}

    public DateTimeException(String msg)
    {
        super(msg);
    }
}
