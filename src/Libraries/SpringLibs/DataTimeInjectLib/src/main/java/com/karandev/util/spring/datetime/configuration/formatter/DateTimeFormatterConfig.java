package com.karandev.util.spring.datetime.configuration.formatter;

import com.karandev.util.spring.datetime.BeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    @Bean(BeanName.DATE_TIME_FORMATTER_TR)
    @Lazy
    public DateTimeFormatter create()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy kk.mm.ss");
    }
}
