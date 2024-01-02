package org.csystem.app.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeDisplay {
    @Autowired
    private LocalTime m_now; //field injection

    @Autowired
    @Qualifier("timeFormatter")
    private DateTimeFormatter m_formatter; //field injection

    @PostConstruct
    public void display()
    {
        System.out.printf("Now:%s%n", m_formatter.format(m_now));
    }
}
