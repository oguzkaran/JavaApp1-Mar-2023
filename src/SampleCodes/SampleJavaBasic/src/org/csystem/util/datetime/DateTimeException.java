/*----------------------------------------------------------------------
	FILE        : DateTimeException.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 05.12.2021

	Class that is used for exceptions of date and/or time

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

public class DateTimeException extends RuntimeException {
    public DateTimeException(String message)
    {
        super(message);
    }

    public String getMessage()
    {
        return String.format("DateTime Exception:%s", super.getMessage());
    }
}
