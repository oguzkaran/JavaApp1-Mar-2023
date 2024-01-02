package org.csystem.app.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeDisplay {
    private final LocalDateTime m_now;
    private final DateTimeFormatter m_formatter;

    public DateTimeDisplay(LocalDateTime now, @Qualifier("dateTimeFormatter") DateTimeFormatter formatter) //ctor injection
    {
        m_now = now;
        m_formatter = formatter;
    }

    @PostConstruct
    public void display()
    {
        System.out.printf("Now:%s%n", m_formatter.format(m_now));
    }


}
