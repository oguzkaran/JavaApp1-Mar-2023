package org.csystem.app.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component
public class DateTimeScheduler {
    private final ApplicationContext m_applicationContext;
    private final DateTimeFormatter m_dateTimeFormatter;

    public DateTimeScheduler(ApplicationContext applicationContext, DateTimeFormatter dateTimeFormatter)
    {
        m_applicationContext = applicationContext;
        m_dateTimeFormatter = dateTimeFormatter;
    }

    @Scheduled(cron = "0 0 23 * * *")
    public void displayCurrentDateTime()
    {
        System.out.printf("Current Date Time:%s\r", m_dateTimeFormatter.format(m_applicationContext.getBean(Temporal.class)));
    }
}

