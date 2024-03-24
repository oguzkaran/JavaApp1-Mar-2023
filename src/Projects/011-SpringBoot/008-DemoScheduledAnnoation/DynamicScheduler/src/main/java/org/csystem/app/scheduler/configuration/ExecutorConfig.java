package org.csystem.app.scheduler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfig {
    @Bean
    public Executor createExecutor()
    {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
