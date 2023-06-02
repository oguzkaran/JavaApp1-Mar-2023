package org.csystem.datetime;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

public class BirthDayRemainder {
    private static final double DIVIDER = 1000. * 60 * 60 * 24 * 365;
    private final Calendar m_birthDate;

    public BirthDayRemainder(int day, int month, int year)
    {
        //...
        m_birthDate = new GregorianCalendar(year, month - 1, day);
    }

    public BirthDayInfo getBirthDayInfo()
    {
        var today = new GregorianCalendar();

        today = new GregorianCalendar(today.get(YEAR), today.get(MONTH), today.get(DAY_OF_MONTH));

        var birthDay = new GregorianCalendar(today.get(YEAR), m_birthDate.get(MONTH), m_birthDate.get(DAY_OF_MONTH));
        var age = (today.getTimeInMillis() - m_birthDate.getTimeInMillis()) / DIVIDER;
        var status = BirthDayStatus.TODAY;

        if (birthDay.after(today))
            status = BirthDayStatus.BEFORE;
        else if (birthDay.before(today))
            status = BirthDayStatus.AFTER;

        return new BirthDayInfo(m_birthDate.get(DAY_OF_MONTH), m_birthDate.get(MONTH) + 1, m_birthDate.get(YEAR), age, status);
    }

    public int getDay()
    {
        return m_birthDate.get(DAY_OF_MONTH);
    }

    public int getMonthValue()
    {
        return m_birthDate.get(MONTH) + 1;
    }

    public int getYear()
    {
        return m_birthDate.get(YEAR);
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
