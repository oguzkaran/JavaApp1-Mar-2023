package org.csystem.datetime;

import org.csystem.util.datetime.DateTime;
import org.csystem.util.datetime.Month;

public class BirthDayRemainder {
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;
    private final DateTime m_birthDate;

    public BirthDayRemainder(int day, int month, int year)
    {
        //...
        m_birthDate = DateTime.of(day, month, year);
    }

    public BirthDayInfo getBirthDayInfo()
    {
        var today = DateTime.today();

        var birthDay = m_birthDate.withYear(today.getYear());
        var age = (today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / DIVIDER;
        var status = BirthDayStatus.TODAY;

        if (birthDay.isAfter(today))
            status = BirthDayStatus.BEFORE;
        else if (birthDay.isBefore(today))
            status = BirthDayStatus.AFTER;

        return new BirthDayInfo(m_birthDate.getDay(), m_birthDate.getMonthValue(), m_birthDate.getYear(), age, status);
    }

    public int getDay()
    {
        return m_birthDate.getDay();
    }

    public int getMonthValue()
    {
        return m_birthDate.getMonthValue();
    }

    public Month getMonth()
    {
        return m_birthDate.getMonth();
    }

    public int getYear()
    {
        return m_birthDate.getYear();
    }

    public double getAge()
    {
        return getBirthDayInfo().getAge();
    }

    public BirthDayStatus getBirthDayStatus()
    {
        return getBirthDayInfo().getBirthDayStatus();
    }

    //...
}
