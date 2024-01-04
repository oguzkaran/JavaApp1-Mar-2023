package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import com.karandev.util.spring.datetime.BeanName;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeDisplay {
    private final LocalDateTime m_now;
    private final DateTimeFormatter m_formatter;

    public DateTimeDisplay(@Qualifier(BeanName.CURRENT_DATE_TIME) LocalDateTime now,
                           @Qualifier(BeanName.DATE_TIME_FORMATTER_TR) DateTimeFormatter formatter) //ctor injection
    {
        m_now = now;
        m_formatter = formatter;
    }

    @PostConstruct
    public void display()
    {
        Console.writeLine("Now:%s", m_formatter.format(m_now));
    }

}
