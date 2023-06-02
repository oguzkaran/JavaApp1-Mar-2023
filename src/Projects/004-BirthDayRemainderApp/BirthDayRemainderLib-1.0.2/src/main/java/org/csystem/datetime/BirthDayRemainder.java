package org.csystem.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class BirthDayRemainder {
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;
    private final LocalDate m_birthDate;

    public BirthDayRemainder(int day, int month, int year)
    {
        //...
        m_birthDate = LocalDate.of(year, month, day);
    }

    public BirthDayInfo getBirthDayInfo()
    {
        var today = LocalDate.now();
        var birthDay = m_birthDate.withYear(today.getYear());
        var age = ChronoUnit.DAYS.between(m_birthDate, today) / 365.;
        var status = BirthDayStatus.TODAY;

        if (birthDay.isAfter(today))
            status = BirthDayStatus.BEFORE;
        else if (birthDay.isBefore(today))
            status = BirthDayStatus.AFTER;

        return new BirthDayInfo(m_birthDate.getDayOfMonth(), m_birthDate.getMonthValue(), m_birthDate.getYear(), age, status);
    }

    public int getDay()
    {
        return m_birthDate.getDayOfMonth();
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
