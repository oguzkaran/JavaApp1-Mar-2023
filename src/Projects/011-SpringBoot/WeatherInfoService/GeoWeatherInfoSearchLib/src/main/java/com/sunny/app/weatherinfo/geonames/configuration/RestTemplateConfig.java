package com.sunny.app.weatherinfo.geonames.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @Scope("prototype")
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}
