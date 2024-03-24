package org.csystem.app.scheduler.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.concurrent.Executor;

@Configuration
@EnableScheduling
public class DateTimeSchedulerDynamicConfig implements SchedulingConfigurer {
    private final ApplicationContext m_applicationContext;
    private final DateTimeFormatter m_dateTimeFormatter;

    private final Executor m_executor;

    private void displayDateTimeCallback()
    {
        System.out.printf("Current time:%s\r", m_dateTimeFormatter.format(m_applicationContext.getBean(Temporal.class)));
    }

    private Instant triggerCallback(TriggerContext triggerContext)
    {
        //Detaylar şu an önemsiz. Tamamen demo olarak eklendi
        return Instant.now().plusSeconds(1);
    }

    public DateTimeSchedulerDynamicConfig(ApplicationContext applicationContext, DateTimeFormatter dateTimeFormatter,
                                          @Qualifier("createExecutor") Executor executor)
    {
        m_applicationContext = applicationContext;
        m_dateTimeFormatter = dateTimeFormatter;
        m_executor = executor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
    {
        taskRegistrar.setScheduler(m_executor);
        taskRegistrar.addTriggerTask(this::displayDateTimeCallback, this::triggerCallback);
    }
}
