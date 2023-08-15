package org.csystem.app.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static org.csystem.util.string.StringUtil.viewFirst;

public class Employee {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String m_firstName;
    private Optional<String>  m_middleNameOpt;
    private String m_lastName;
    private LocalDate m_birthDate;
    //...

    public Employee(String firstName, String lastName, LocalDate birthDate)
    {
        this(firstName, null, lastName, birthDate);
    }

    public Employee(String firstName, String middleName, String lastName, LocalDate birthDate)
    {
        m_firstName = firstName;
        m_middleNameOpt = Optional.ofNullable(middleName);
        m_lastName = lastName;
        m_birthDate = birthDate;
    }


    public String getFirstName()
    {
        return m_firstName;
    }

    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
    }

    public Optional<String> getMiddleNameOpt()
    {
        return m_middleNameOpt;
    }

    public void setMiddleName(String middleName)
    {
        m_middleNameOpt = Optional.of(middleName);
    }

    public void setMiddleNameEmpty()
    {
        m_middleNameOpt = Optional.empty();
    }

    public String getLastName()
    {
        return m_lastName;
    }

    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return m_birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        m_birthDate = birthDate;
    }

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }
    public String getFullName()
    {
        return String.format("%s%s %s", m_firstName, m_middleNameOpt.map(mn -> " " + mn).orElse(""), m_lastName);
    }

    public String getSecretFullName()
    {
        return getSecretFullName('*');
    }

    public String getSecretFullName(char ch)
    {
        return String.format("%s%s %s", viewFirst(m_firstName, ch), m_middleNameOpt.map(mn -> " " + viewFirst(mn, ch)).orElse(""), viewFirst(m_lastName, ch));
    }

    public String toString()
    {
        return String.format("Full Name:%s, BirthDate:%s, Age:%.2f", getFullName(), FORMATTER.format(m_birthDate), getAge());
    }
}
