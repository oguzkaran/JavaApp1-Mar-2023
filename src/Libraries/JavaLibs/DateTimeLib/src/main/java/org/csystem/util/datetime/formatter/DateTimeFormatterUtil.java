/*----------------------------------------------------------------------
	FILE        : DateTimeFormatterUtil.java
	AUTHOR      : JavaApp1-Mar-2023 Group
	LAST UPDATE : 01.06.2023

	DateTimeFormatterUtil utility class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime.formatter;

import java.time.format.DateTimeFormatter;

public final class DateTimeFormatterUtil {
    private DateTimeFormatterUtil()
    {
    }

    public static final DateTimeFormatter DATETIME_DOT_SEC_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATETIME_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    //...
}
