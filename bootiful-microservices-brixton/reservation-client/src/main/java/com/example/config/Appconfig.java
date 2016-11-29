package com.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sudhir
 *         Date:27/11/16
 *         Time:8:23 PM
 *         Project:reservation-client
 */
@Configuration
public class Appconfig {

    @LoadBalanced
    @Bean
    public RestTemplate resttemplate(){
        return new RestTemplate();
    }
}
