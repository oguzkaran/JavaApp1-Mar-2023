/*----------------------------------------------------------------------
	FILE        : Time.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 05.12.2021

	Time class for time operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Time {
    private int m_hour;
    private int m_minute;
    private int m_second;
    private int m_millisecond;

    private static void doWorkForException(String message)
    {
        throw new DateTimeException(message);
    }

    private static boolean isValidForBound(int val, int bound)
    {
        return 0 <= val && val <= bound;
    }

    private static boolean isValidForHour(int val)
    {
        return isValidForBound(val, 23);
    }

    private static boolean isValidForMinute(int val)
    {
        return isValidForBound(val, 59);
    }

    private static boolean isValidForSecond(int val)
    {
        return isValidForBound(val, 59);
    }

    private static boolean isValidForMillisecond(int val)
    {
        return isValidForBound(val, 999);
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static void checkForHour(int val)
    {
        if (!isValidForHour(val))
            doWorkForException("Invalid hour value:" + val);
    }

    private static void checkForMinute(int val)
    {
        if (!isValidForMinute(val))
            doWorkForException("Invalid minute value:" + val);
    }

    private static void checkForSecond(int val)
    {
        if (!isValidForSecond(val))
            doWorkForException("Invalid second value:" + val);
    }

    private static void checkForMillisecond(int val)
    {
        if (!isValidForMillisecond(val))
            doWorkForException("Invalid millisecond value:" + val);
    }

    private static void checkForTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException(String.format("Invalid time value or values-> hour:%d, minute:%d, second:%d, millisecond:%d",
                    hour, minute, second, millisecond));
    }

    public static Time random()
    {
        return random(new Random());
    }

    public static Time random(Random r)
    {
        return new Time(r.nextInt(24), r.nextInt(60), r.nextInt(60), r.nextInt(1000));
    }

    public Time() //Burada yazılanların şu an için bilinmesi gerekmez. Sadece default ctor'un anlamına odaklanınız
    {
        Calendar now = new GregorianCalendar();

        m_hour = now.get(Calendar.HOUR_OF_DAY);
        m_minute = now.get(Calendar.MINUTE);
        m_second = now.get(Calendar.SECOND);
        m_millisecond = now.get(Calendar.MILLISECOND);
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        checkForTime(hour, minute, second, millisecond);
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int val)
    {
        if (val == m_hour)
            return;

        checkForHour(val);
        m_hour = val;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int val)
    {
        if (val == m_minute)
            return;

        checkForMinute(val);
        m_minute = val;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int val)
    {
        if (val == m_second)
            return;

        checkForSecond(val);
        m_second = val;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int val)
    {
        if (val == m_millisecond)
            return;

        checkForMillisecond(val);
        m_millisecond = val;
    }

    public String toString()
    {
        return String.format("%s:%02d", this.toShortTimeString(), m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }
}
