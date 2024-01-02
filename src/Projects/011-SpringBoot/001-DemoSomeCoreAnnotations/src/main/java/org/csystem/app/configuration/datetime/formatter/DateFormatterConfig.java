package org.csystem.app.configuration.datetime.formatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateFormatterConfig {
    @Bean("dateFormatter")
    @Lazy
    public DateTimeFormatter create()
    {
        System.out.println("DateTimeFormatterConfig.DateFormatter");

        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
