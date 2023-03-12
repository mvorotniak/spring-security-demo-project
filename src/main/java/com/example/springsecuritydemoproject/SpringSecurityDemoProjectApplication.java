package com.example.springsecuritydemoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class SpringSecurityDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoProjectApplication.class, args);
    }

}
