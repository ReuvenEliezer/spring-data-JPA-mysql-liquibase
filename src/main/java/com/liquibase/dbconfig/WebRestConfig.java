package com.liquibase.dbconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebRestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

