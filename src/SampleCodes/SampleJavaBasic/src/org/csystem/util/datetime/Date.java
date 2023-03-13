/*----------------------------------------------------------------------
	FILE        : Date.java
	AUTHOR      : Java-May-2021 Group
	LAST UPDATE : 05.12.2021

	Date class for date operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Date {
    private static final String [] ms_monthsTR;
    private static final String [] ms_daysOfWeekTR;
    private static final String [] ms_monthsEN;
    private static final String [] ms_daysOfWeekEN;
    private static final Month[] ms_months;
    private static final DayOfWeek[] ms_dayOfWeeks;

    static {
        ms_monthsTR = new String[]{"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz",
                "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

        ms_daysOfWeekTR = new String[]{"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};

        ms_monthsEN = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        ms_daysOfWeekEN = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        ms_months = Month.values();
        ms_dayOfWeeks = DayOfWeek.values();
    }

    private static boolean isValidDate(int day, int month, int year)
    {
        if (day < 1 || day > 31 || month < 1 || month > 12)
            return false;

        return day <= ms_months[month - 1].getDays(year);
    }

    private static int getTotalDaysByMonth(int month, int year)
    {
        int totalDays = 0;

        for (int m = month - 1; m >= 1; --m)
            totalDays += ms_months[m - 1].days;

        return month > 2 && isLeapYear(year) ? totalDays + 1 : totalDays;
    }

    private static int getDayOfYear(int day, int month, int year)
    {
        return isValidDate(day, month, year) ? day + getTotalDaysByMonth(month, year) : -1;
    }

    private static int getDayOfWeek(int day, int month, int year)
    {
        int totalDays;

        if (year < 1900 || (totalDays = getDayOfYear(day, month, year)) == -1)
            return -1;

        for (int y = 1900; y < year; ++y)
            totalDays += isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static String getDaySuffix(int day)
    {
        String suffix = "th";

        switch (day) {
            case 1:
            case 21:
            case 31:
                suffix = "st";
                break;
            case 2:
            case 22:
                suffix = "nd";
                break;
            case 3:
            case 23:
                suffix = "rd";
        }

        return suffix;
    }

    private static void doWorkForException(String message)
    {
        throw new DateTimeException(message);
    }

    private static void checkForDate(int day, int month, int year, String errMessage)
    {
        if (!isValidDate(day, month, year))
            doWorkForException(errMessage);
    }

    private void checkForDay(int val, String errMessage)
    {
        checkForDate(val, m_month, m_year, errMessage);
    }

    private void checkForMonth(int val, String errMessage)
    {
        checkForDate(m_day, val, m_year, errMessage);
    }

    private void checkForYear(int val, String errMessage)
    {
        checkForDate(m_day, m_month, val, errMessage);
    }

    private void set(int day, int month, int year)
    {
        m_day = day;
        m_month = month;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static Date random()
    {
        return random(new Random());
    }

    public static Date random(Random r)
    {
        return random(r, new Date().m_year);
    }

    public static Date random(int year)
    {
        return random(new Random(), year);
    }

    public static Date random(Random r, int year)
    {
        return random(r, year, year);
    }

    public static Date random(int minYear, int maxYear)
    {
        return random(new Random(), minYear, maxYear);
    }

    public static Date random(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(ms_months[month - 1].getDays(year)) + 1;

        return new Date(day, month, year);
    }

    public Date() //Burada yazılanların şu an için bilinmesi gerekmez. Sadece default ctor'un anlamına odaklanınız
    {
        Calendar today = new GregorianCalendar();

        set(today.get(Calendar.DAY_OF_MONTH), today.get(Calendar.MONTH) + 1, today.get(Calendar.YEAR));
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public Date(int day, int month, int year)
    {
        checkForDate(day, month, year, String.format("Invalid date value or values -> day: %d, month: %d, year: %d",
                day, month, year));
        this.set(day, month, year);
    }

    public int getDay()
    {
        return m_day;
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        this.checkForDay(day, "Invalid day value:" + day);
        this.set(day, m_month, m_year);
    }

    public int getMonthValue()
    {
        return m_month;
    }

    public void setMonthValue(int month)
    {
        if (month == m_month)
            return;

        this.checkForMonth(month, "Invalid month value:" + month);
        this.set(m_day, month, m_year);
    }

    public Month getMonth()
    {
        return ms_months[m_month - 1];
    }

    public void setMonth(Month month)
    {
        this.setMonthValue(month.ordinal() + 1);
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        this.checkForYear(year, "Invalid year value:" + year);
        this.set(m_day, m_month, year);
    }

    public DayOfWeek getDayOfWeek()
    {
        return ms_dayOfWeeks[m_dayOfWeek];
    }

    public String getDayOfWeekTR()
    {
        return ms_daysOfWeekTR[m_dayOfWeek];
    }

    public String getDayOfWeekEN()
    {
        return ms_daysOfWeekEN[m_dayOfWeek];
    }

    public boolean isLeapYear()
    {
        return isLeapYear(m_year);
    }

    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public boolean isWeekday()
    {
        return !this.isWeekend();
    }

    public int getDaysOfMonth()
    {
        return ms_months[m_month - 1].days;
    }

    public String toString()
    {
        return this.toString('/');
    }

    public String toString(char delimiter)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delimiter, m_month, delimiter, m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%s %s", this.toShortDateStringTR(), this.getDayOfWeekTR());
    }

    public String toLongDateStringEN()
    {
        return String.format("%s %s", this.toShortDateStringEN(), this.getDayOfWeekEN());
    }

    public String toShortDateStringTR()
    {
        return String.format("%d %s %d", m_day, ms_monthsTR[m_month], m_year);
    }

    public String toShortDateStringEN()
    {
        return String.format("%d%s %s %d", m_day, getDaySuffix(m_day), ms_monthsEN[m_month], m_year);
    }
}
