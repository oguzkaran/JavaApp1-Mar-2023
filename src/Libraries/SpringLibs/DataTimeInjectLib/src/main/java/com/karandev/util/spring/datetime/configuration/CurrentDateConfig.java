package com.karandev.util.spring.datetime.configuration;

import com.karandev.util.spring.datetime.BeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class CurrentDateConfig {
    @Bean(BeanName.CURRENT_DATE)
    @Scope("prototype")
    public LocalDate create()
    {
        return LocalDate.now();
    }
}
