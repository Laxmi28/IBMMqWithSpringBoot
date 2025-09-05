package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMqApplication.class,args);
    }
}