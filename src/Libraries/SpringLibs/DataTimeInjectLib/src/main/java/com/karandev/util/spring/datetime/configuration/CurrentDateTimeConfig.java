package com.karandev.util.spring.datetime.configuration;

import com.karandev.util.spring.datetime.BeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class CurrentDateTimeConfig {
    @Bean(BeanName.CURRENT_DATE_TIME)
    @Scope("prototype")
    public LocalDateTime create()
    {
        return LocalDateTime.now();
    }
}
