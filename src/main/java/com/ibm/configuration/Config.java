package com.ibm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ibm.mq.spring.boot.MQConfigurationProperties;

@Configuration
public class Config {
    
    @Bean
    public MQConfigurationProperties mqConfigurationProperties(){
        return new MQConfigurationProperties();
    }

}
