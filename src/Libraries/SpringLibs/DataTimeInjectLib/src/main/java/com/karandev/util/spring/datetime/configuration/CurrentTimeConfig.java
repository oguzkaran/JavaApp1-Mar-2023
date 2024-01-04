package com.karandev.util.spring.datetime.configuration;

import com.karandev.util.spring.datetime.BeanName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalTime;

@Configuration
public class CurrentTimeConfig {
    @Bean(BeanName.CURRENT_TIME)
    @Scope("prototype")
    public LocalTime create()
    {
        return LocalTime.now();
    }
}
