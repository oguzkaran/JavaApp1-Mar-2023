package org.csystem.app.clock.component;

import com.karandev.io.util.console.Console;
import com.karandev.util.spring.datetime.BeanName;
import org.csystem.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class ClockRunner implements ApplicationRunner {
    private final DateTimeFormatter m_formatter;
    private final ApplicationContext m_applicationContext;

    public ClockRunner(@Qualifier(BeanName.DATE_TIME_FORMATTER_TR) DateTimeFormatter formatter, ApplicationContext applicationContext)
    {
        m_formatter = formatter;
        m_applicationContext = applicationContext;
    }

    private void clockSchedulerCallback()
    {
        var currentDateTime = m_applicationContext.getBean(BeanName.CURRENT_DATE_TIME, LocalDateTime.class);

        Console.write("%s\r", m_formatter.format(currentDateTime));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        var scheduler = new Scheduler(1, TimeUnit.SECONDS);

        scheduler.schedule(this::clockSchedulerCallback);
    }
}
