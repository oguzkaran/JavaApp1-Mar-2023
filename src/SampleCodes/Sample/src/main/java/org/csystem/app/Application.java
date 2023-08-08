/*----------------------------------------------------------------------------------------------------------------------
    Annotation:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

class Application {
    public static void run(String [] args)
    {
        var employee1 = new Employee("Ümit", "Yasin", "Çoban", LocalDate.of(1997, Month.OCTOBER, 15));
        var employee2 = new Employee("Baturhan", "Şahin", LocalDate.of(1994, Month.OCTOBER, 13));

        Console.writeLine(employee1);
        Console.writeLine(employee2);

        employee1.setMiddleNameEmpty();
        employee2.setMiddleName("Baturhan");

        Console.writeLine(employee1);
        Console.writeLine(employee2);
    }
}

class Employee {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String m_firstName;
    private Optional<String>  m_middleNameOpt;
    private String m_lastName;

    private LocalDate m_birthDate;
    //...


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

    //...

    public double getAge()
    {
        return ChronoUnit.DAYS.between(m_birthDate, LocalDate.now()) / 365.;
    }
    public String getFullName()
    {
        return String.format("%s%s %s", m_firstName, m_middleNameOpt.map(mn -> " " + mn).orElse(""), m_lastName);
    }

    @Override
    public String toString()
    {
        return String.format("Full Name:%s, BirthDate:%s, Age:%.2f", getFullName(), FORMATTER.format(m_birthDate), getAge());
    }
}

@FunctionalInterface
interface IX {
    void foo();

   default void bar()
   {

   }
}