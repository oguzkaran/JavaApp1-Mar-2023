package org.csystem.datetime;

public class BirthDayInfo {
    private final int m_day, m_month, m_year;
    private final double m_age;
    private final BirthDayStatus m_birthDayStatus;

    public BirthDayInfo(int day, int month, int year, double age, BirthDayStatus birthDayStatus)
    {
        m_day = day;
        m_month = month;
        m_year = year;
        m_age = age;
        m_birthDayStatus = birthDayStatus;
    }

    public int getDay()
    {
        return m_day;
    }

    public int getMonth()
    {
        return m_month;
    }

    public int getYear()
    {
        return m_year;
    }

    public double getAge()
    {
        return m_age;
    }

    public BirthDayStatus getBirthDayStatus()
    {
        return m_birthDayStatus;
    }

    //...
}
