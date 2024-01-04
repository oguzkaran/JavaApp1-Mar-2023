package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import com.karandev.util.spring.datetime.BeanName;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateDisplay {
    private LocalDate m_today;
    private DateTimeFormatter m_formatter;

    @Autowired
    public void setToday(@Qualifier(BeanName.CURRENT_DATE) LocalDate today) //property injection
    {
        m_today = today;
    }

    @Autowired
    public void setFormatter(@Qualifier(BeanName.DATE_FORMATTER_TR) DateTimeFormatter formatter) //property injection
    {
        m_formatter = formatter;
    }

    @PostConstruct
    public void display()
    {
        Console.writeLine("Today:%s", m_formatter.format(m_today));
    }
}
