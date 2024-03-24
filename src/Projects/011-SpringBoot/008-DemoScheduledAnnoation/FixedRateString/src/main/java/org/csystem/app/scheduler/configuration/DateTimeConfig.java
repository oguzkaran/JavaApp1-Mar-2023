package org.csystem.app.scheduler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Configuration
public class DateTimeConfig {
    @Bean
    @Scope("prototype")
    public Temporal createTemporal()
    {
        return LocalDateTime.now();
    }

    @Bean
    public DateTimeFormatter createFormatter()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    }
}
