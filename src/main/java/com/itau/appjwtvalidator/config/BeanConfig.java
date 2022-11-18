package com.itau.appjwtvalidator.config;

import com.itau.appjwtvalidator.domain.service.JwtValidatorService;
import com.itau.appjwtvalidator.domain.service.validator.ClaimValidator;
import com.itau.appjwtvalidator.domain.service.validator.NameValidator;
import com.itau.appjwtvalidator.domain.service.validator.RoleValidator;
import com.itau.appjwtvalidator.domain.service.validator.SeedValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    JwtValidatorService jwtValidatorService(ClaimValidator claimValidator, NameValidator nameValidator,
                                            RoleValidator roleValidator, SeedValidator seedValidator){
        return  new JwtValidatorService(claimValidator, nameValidator, roleValidator, seedValidator);
    }

    @Bean
    ClaimValidator claimValidator(){
        return  new ClaimValidator();
    }
    @Bean
    NameValidator nameValidator(){
        return  new NameValidator();
    }
    @Bean
    RoleValidator roleValidator(){
        return  new RoleValidator();
    }
    @Bean
    SeedValidator seedValidator(){
        return  new SeedValidator();
    }
}
