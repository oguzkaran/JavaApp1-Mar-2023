package org.csystem.app.configuration.datetime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class DateConfig {
    @Bean("date.create")
    @Scope("prototype")
    public LocalDate create()
    {
        System.out.println("DateConfig.create");

        return LocalDate.now();
    }
}
