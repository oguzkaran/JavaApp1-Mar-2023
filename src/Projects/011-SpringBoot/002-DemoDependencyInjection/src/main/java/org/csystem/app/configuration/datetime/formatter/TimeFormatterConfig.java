package org.csystem.app.configuration.datetime.formatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.format.DateTimeFormatter;

@Configuration
public class TimeFormatterConfig {
    @Bean("timeFormatter")
    @Lazy
    public DateTimeFormatter create()
    {
        System.out.println("DateTimeFormatterConfig.TimeFormatter");

        return DateTimeFormatter.ofPattern("kk:mm:ss");
    }
}

