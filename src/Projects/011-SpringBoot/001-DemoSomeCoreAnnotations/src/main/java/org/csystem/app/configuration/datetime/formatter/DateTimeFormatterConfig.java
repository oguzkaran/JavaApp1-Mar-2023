package org.csystem.app.configuration.datetime.formatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean("dateTimeFormatter")
    @Lazy
    public DateTimeFormatter create()
    {
        System.out.println("DateTimeFormatterConfig.DateTimeFormatter");

        return DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss");
    }
}
