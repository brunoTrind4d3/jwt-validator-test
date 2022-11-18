package com.itau.appjwtvalidator.rest.v1;

import com.itau.appjwtvalidator.domain.service.JwtValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jwt")
public class JwtValidatorController {

    @Autowired
    private JwtValidatorService jwtValidatorService;

    @PostMapping("/validate")
    public boolean validate(@RequestHeader String jwt){
        return this.jwtValidatorService.validate(jwt);
    }

}
