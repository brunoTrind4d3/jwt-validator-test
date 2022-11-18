package com.itau.appjwtvalidator.domain.service;

import com.itau.appjwtvalidator.domain.service.validator.ClaimValidator;
import com.itau.appjwtvalidator.domain.service.validator.NameValidator;
import com.itau.appjwtvalidator.domain.service.validator.RoleValidator;
import com.itau.appjwtvalidator.domain.service.validator.SeedValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

@RequiredArgsConstructor
public class JwtValidatorService {

    private final ClaimValidator claimValidator;
    private final NameValidator nameValidator;
    private final RoleValidator roleValidator;
    private final SeedValidator seedValidator;

    public boolean validate(String jwt) {



        var isValidClaim = this.claimValidator.validate(jwt);
        var isValidName = this.nameValidator.validate(jwt);
        var isValidRole = this.roleValidator.validate(jwt);
        var isValidSeed = this.seedValidator.validate(jwt);

        return (isValidClaim && isValidName && isValidSeed && isValidRole);
    }
}
