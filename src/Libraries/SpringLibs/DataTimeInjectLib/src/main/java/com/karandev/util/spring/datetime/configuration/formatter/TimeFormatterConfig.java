package com.karandev.util.spring.datetime.configuration.formatter;

import com.karandev.util.spring.datetime.BeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.format.DateTimeFormatter;

@Configuration
public class TimeFormatterConfig {
    @Bean(BeanName.TIME_FORMATTER_TR)
    @Lazy
    public DateTimeFormatter create()
    {
        return DateTimeFormatter.ofPattern("kk.mm.ss");
    }
}

