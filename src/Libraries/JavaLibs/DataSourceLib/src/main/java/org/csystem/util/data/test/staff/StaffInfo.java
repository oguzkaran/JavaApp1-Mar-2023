package org.csystem.util.data.test.staff;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class StaffInfo {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int m_id;
    private String m_name;
    private LocalDate m_birthDate;

    private LocalDate m_entryDate;

    private LocalDate m_systemEntryDate;

    private DayOfWeek m_restDay;

    public int getId()
    {
        return m_id;
    }

    public StaffInfo setId(int id)
    {
        m_id = id;

        return this;
    }

    public String getName()
    {
        return m_name;
    }

    public StaffInfo setName(String name)
    {
        m_name = name;

        return this;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public StaffInfo setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;

        return this;
    }

    public LocalDate getEntryDate()
    {
        return m_entryDate;
    }

    public StaffInfo setEntryDate(LocalDate entryDate)
    {
        m_entryDate = entryDate;

        return this;
    }

    public LocalDate getSystemEntryDate()
    {
        return m_systemEntryDate;
    }

    public StaffInfo setSystemEntryDate(LocalDate systemEntryDate)
    {
        m_systemEntryDate = systemEntryDate;

        return this;
    }

    public DayOfWeek getRestDay()
    {
        return m_restDay;
    }

    public StaffInfo setRestDay(DayOfWeek restDay)
    {
        m_restDay = restDay;

        return this;
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof StaffInfo si && si.m_id == m_id;
    }

    @Override
    public String toString()
    {
        return String.format("[%d]%s %s %s, %s, %s", m_id, m_name, FORMATTER.format(m_birthDate),
                FORMATTER.format(m_entryDate), FORMATTER.format(m_systemEntryDate), m_restDay);
    }
}
