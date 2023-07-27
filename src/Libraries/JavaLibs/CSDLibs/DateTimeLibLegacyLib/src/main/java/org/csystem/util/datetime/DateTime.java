package org.csystem.util.datetime;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public final class DateTime implements Serializable, Comparable<DateTime> {
    private static final long serialVersionUID = 1L;
    private static final int [] DAYS_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final Calendar m_calendar;

    private static boolean isValidDate(int day, int mon, int year)
    {
        if (day < 1 || day > 31 || mon < 1 || mon > 12)
            return false;

        int days = mon == 2 && isLeapYear(year) ? 29 : DAYS_OF_MONTHS[mon];

        return day <= days;
    }

    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private static boolean isValidForTime(int hour, int minute, int second, int millisecond)
    {
        return isValidForHour(hour) && isValidForMinute(minute)
                && isValidForSecond(second) && isValidForMillisecond(millisecond);
    }

    private static boolean isValidForHour(int hour)
    {
        return isValidForBounds(hour, 23);
    }

    private static boolean isValidForMinute(int minute)
    {
        return isValidForBounds(minute, 59);
    }

    private static boolean isValidForSecond(int second)
    {
        return isValidForBounds(second, 59);
    }
    private static boolean isValidForMillisecond(int second)
    {
        return isValidForBounds(second, 999);
    }

    private static boolean isValidForBounds(int val, int max)
    {
        return 0 <= val && val <= max;
    }

    private static void controlForDate(int day, int mon, int year, String msg)
    {
        if (!isValidDate(day, mon, year))
            doWorkForException(msg);
    }
    private static void controlForTime(int hour, int minute, int second, int millisecond, String msg)
    {
        if (!isValidForTime(hour, minute, second, millisecond))
            doWorkForException(msg);
    }

    public static void controlForHour(int hour)
    {
        if (!isValidForHour(hour))
            doWorkForException("Invalid Hour");
    }

    public static void controlForMinute(int minute)
    {
        if (!isValidForMinute(minute))
            doWorkForException("Invalid Minute");
    }

    public static void controlForSecond(int second)
    {
        if (!isValidForSecond(second))
            doWorkForException("Invalid Second");
    }

    public static void controlForMillisecond(int millisecond)
    {
        if (!isValidForMillisecond(millisecond))
            doWorkForException("Invalid Millisecond");
    }

    private static void control(int day, int mon, int year, int hour, int minute, int second, int millisecond, String msg)
    {
        controlForDate(day, mon, year, msg);
        controlForTime(hour, minute, second, millisecond, msg);
    }

    private static void doWorkForException(String msg)
    {
        throw new DateTimeException(msg);
    }

    private DateTime(Calendar calendar)
    {
        m_calendar = calendar;
    }

    private DateTime()
    {
        m_calendar = Calendar.getInstance();
    }

    private DateTime(int day, int mon, int year, int hour, int minute, int second, int milliseconds)
    {
        control(day, mon, year, hour, minute, second, milliseconds, "Invalid org.csystem.util.datetime.DateTime");
        m_calendar = new GregorianCalendar(year, mon - 1, day, hour, minute, second);
        m_calendar.set(MILLISECOND, milliseconds);
    }

    private DateTime plus(int field, int amount)
    {
        Calendar calendar = (Calendar)m_calendar.clone();

        calendar.add(field, amount);

        return new DateTime(calendar);
    }

    private DateTime with(int field, int value)
    {
        Calendar calendar = (Calendar)m_calendar.clone();

        calendar.set(field, value);

        return new DateTime(calendar);
    }

    public static DateTime of(long milliseconds)
    {
        DateTime dateTime = new DateTime();

        dateTime.m_calendar.setTimeInMillis(milliseconds);

        return dateTime;
    }

    public static DateTime of(int day, int mon, int year)
    {
        return of(day, mon, year, 0, 0);
    }

    public static DateTime of(int day, Month mon, int year)
    {
        return of(day, mon.ordinal() + 1, year);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute)
    {
        return of(day, mon, year, hour, minute, 0);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute, int second)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute, second);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute, int second)
    {
        return of(day, mon, year, hour, minute, second, 0);
    }

    public static DateTime of(int day, Month mon, int year, int hour, int minute, int second, int millisecond)
    {
        return of(day, mon.ordinal() + 1, year, hour, minute, second, millisecond);
    }

    public static DateTime of(int day, int mon, int year, int hour, int minute, int second, int millisecond)
    {
        return new DateTime(day, mon, year, hour, minute, second, millisecond);
    }

    public static DateTime now() {return new DateTime();}

    public static DateTime today()
    {
        DateTime now = now();

        now.m_calendar.set(HOUR_OF_DAY, 0);
        now.m_calendar.set(MINUTE, 0);
        now.m_calendar.set(SECOND, 0);
        now.m_calendar.set(MILLISECOND, 0);

        return now;
    }

    public int getDay() {return m_calendar.get(DAY_OF_MONTH);}

    public int getMonthValue() {return m_calendar.get(MONTH) + 1;}

    public Month getMonth() {return Month.values()[getMonthValue() - 1];}

    public int getYear() {return m_calendar.get(YEAR);}

    public DayOfWeek getDayOfWeek() {return DayOfWeek.values()[m_calendar.get(DAY_OF_WEEK) - 1];}

    public int getDayOfYear() {return m_calendar.get(DAY_OF_YEAR);}

    public int getHour() {return m_calendar.get(HOUR_OF_DAY);}

    public int getMinute() {return m_calendar.get(MINUTE);}

    public int getSecond() {return m_calendar.get(SECOND);}

    public int getMillisecond() {return m_calendar.get(MILLISECOND);}

    public long getTimeInMillis()
    {
        return m_calendar.getTimeInMillis();
    }

    public int getEndOfMonth() {return m_calendar.getActualMaximum(DAY_OF_MONTH);}

    public boolean isAfter(DateTime other) {return compareTo(other) > 0;}

    public boolean isBefore(DateTime other) {return compareTo(other) < 0;}

    public boolean isEqual(DateTime other) {return equals(other);}

    public boolean isLeapYear()
    {
        return isLeapYear(getYear());
    }

    public boolean isWeekday() {return !isWeekend();}

    public boolean isWeekend()
    {
        DayOfWeek dow = getDayOfWeek();

        return dow == DayOfWeek.SAT || dow == DayOfWeek.SUN;
    }

    public DateTime plusDays(int days)
    {
        return plus(DAY_OF_MONTH, days);
    }

    public DateTime plusMonths(int months)
    {
        return plus(MONTH, months);
    }

    public DateTime plusYears(int years)
    {
        return plus(YEAR, years);
    }

    public DateTime plusHours(int hours)
    {
        return plus(HOUR_OF_DAY, hours);
    }

    public DateTime plusMinutes(int minutes)
    {
        return plus(MINUTE, minutes);
    }

    public DateTime plusSeconds(int seconds)
    {
        return plus(SECOND, seconds);
    }

    public DateTime plusMilliseconds(int milliseconds)
    {
        return plus(MILLISECOND, milliseconds);
    }

    public DateTime minusDays(int days)
    {
        return plusDays(-days);
    }

    public DateTime minusMonths(int months)
    {
        return plusMonths(-months);
    }

    public DateTime minusYears(int years)
    {
        return plusYears(-years);
    }

    public DateTime minusHours(int hours)
    {
        return plusHours(-hours);
    }

    public DateTime minusMinutes(int minutes)
    {
        return plusMinutes(-minutes);
    }

    public DateTime minusSeconds(int seconds)
    {
        return plusSeconds(-seconds);
    }

    public DateTime minusMilliseconds(int milliseconds)
    {
        return plusMilliseconds(-milliseconds);
    }


    public DateTime withDay(int day)
    {
        controlForDate(day, getMonthValue(), getYear(), "Invalid Day");

        return with(DAY_OF_MONTH, day);
    }

    public DateTime withMonthValue(int month)
    {
        controlForDate(getDay(), month, getYear(), "Invalid org.csystem.util.datetime.Month");

        return with(MONTH, month - 1);
    }

    public DateTime withMonth(Month month)
    {
        return withMonthValue(month.ordinal() + 1);
    }

    public DateTime withYear(int year)
    {
        controlForDate(getDay(), getMonthValue(), year, "Invalid Year");

        return with(YEAR, year);
    }

    public DateTime withHour(int hour)
    {
        controlForHour(hour);

        return with(HOUR_OF_DAY, hour);
    }

    public DateTime withMinute(int minute)
    {
        controlForMinute(minute);

        return with(MINUTE, minute);
    }

    public DateTime withSecond(int second)
    {
        controlForSecond(second);

        return with(SECOND, second);
    }

    public DateTime withMillisecond(int millisecond)
    {
        controlForMillisecond(millisecond);

        return with(MILLISECOND, millisecond);
    }

    @Override
    public int compareTo(DateTime other)
    {
        return m_calendar.compareTo(other.m_calendar);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof DateTime))
            return false;

        return m_calendar.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return m_calendar.hashCode();
    }


    @Override
    public String toString()
    {
        return toString('/');
    }

    public String toString(char delim)
    {
        return String.format("%s %s", toDateString(delim), toTimeString());
    }

    public String toDateString()
    {
        return toDateString('/');
    }

    public String toDateString(char delim)
    {
        return String.format("%02d%c%02d%c%04d",
                getDay(), delim, getMonthValue(), delim, getYear());
    }

    public String toLongTimeString()
    {
        return String.format("%s.%d", toTimeString(), getMillisecond());
    }

    public String toTimeString()
    {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }
}
