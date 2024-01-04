package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import com.karandev.util.spring.datetime.BeanName;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeDisplay {
    @Autowired
    @Qualifier(BeanName.CURRENT_TIME)
    private LocalTime m_now; //field injection

    @Autowired
    @Qualifier(BeanName.TIME_FORMATTER_TR)
    private DateTimeFormatter m_formatter; //field injection

    @PostConstruct
    public void display()
    {
        Console.writeLine("Now:%s", m_formatter.format(m_now));
    }
}
