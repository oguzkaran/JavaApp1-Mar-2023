package org.csystem.util.data.test.staff;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StaffInfo {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int m_id;
    private String m_name;
    private LocalDate m_birthDate;
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

    public DayOfWeek getRestDay()
    {
        return m_restDay;
    }

    public StaffInfo setRestDay(DayOfWeek restDay)
    {
        m_restDay = restDay;

        return this;
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
        return String.format("[%d]%s %s %s", m_id, m_name, FORMATTER.format(m_birthDate), m_restDay);
    }
}
