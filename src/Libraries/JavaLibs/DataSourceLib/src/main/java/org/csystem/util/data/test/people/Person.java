package org.csystem.util.data.test.people;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Person implements Comparable<Person> {
    private static final DateTimeFormatter ms_dateTimeFormatter;
    private int m_id;
    private String m_name;
    private String m_gender;
    private LocalDate m_birthDate;
    private MaritalStatus m_maritalStatus;

    static {
         ms_dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public Person setId(int id)
    {
        m_id = id;

        return this;
    }

    public Person setName(String name)
    {
        //..
        m_name = name;

        return this;
    }

    public Person setGender(String gender)
    {
        //..
        m_gender = gender;

        return this;
    }

    public Person setBirthDate(String str)
    {
        return setBirthDate(LocalDate.parse(str, ms_dateTimeFormatter));
    }

    public Person setBirthDate(int day, int month, int year)
    {
        return setBirthDate(LocalDate.of(year, month, day));
    }

    public Person setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;

        return this;
    }

    public Person setMaritalStatus(MaritalStatus maritalStatus)
    {
        m_maritalStatus = maritalStatus;

        return this;
    }

    public int getId()
    {
        return m_id;
    }

    public String getName()
    {
        return m_name;
    }

    public String getGender()
    {
        return m_gender;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }

    public MaritalStatus getMaritalStatus()
    {
        return m_maritalStatus;
    }

    @Override
    public int compareTo(Person other)
    {
        return Double.compare(getAge(), other.getAge());
    }

    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person))
            return false;

        return ((Person)obj).m_id == m_id;
    }

    @Override
    public String toString()
    {
        return String.format("[%d]%s:%s(%s->%.2f)\"%s\"", m_id, m_name, m_gender,
                ms_dateTimeFormatter.format(m_birthDate), this.getAge(), m_maritalStatus);
    }

    //...
}
