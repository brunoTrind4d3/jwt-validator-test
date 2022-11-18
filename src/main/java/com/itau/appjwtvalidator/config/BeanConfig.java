package com.itau.appjwtvalidator.config;

import com.itau.appjwtvalidator.domain.service.JwtValidatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    JwtValidatorService jwtValidatorService(){
        return  new JwtValidatorService();
    }
}
