package com.itau.appjwtvalidator.domain.service;

import com.itau.appjwtvalidator.domain.service.validator.ClaimValidator;
import com.itau.appjwtvalidator.domain.service.validator.NameValidator;
import com.itau.appjwtvalidator.domain.service.validator.RoleValidator;
import com.itau.appjwtvalidator.domain.service.validator.SeedValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

@RequiredArgsConstructor
@Slf4j
public class JwtValidatorService {

    private final ClaimValidator claimValidator;
    private final NameValidator nameValidator;
    private final RoleValidator roleValidator;
    private final SeedValidator seedValidator;

    public boolean validate(String jwt) {

        var splitToken = jwt.split("\\.");
        if(splitToken.length != 3){
            return false;
        }
        var decoder = Base64.getUrlDecoder();
        var decodeBody = new String(decoder.decode(splitToken[1]));

        log.info("--Claim Validation--");
        var claim = this.claimValidator.validate(decodeBody);

        if(claim == null){
            log.info("Claim: " + null);
            return false;
        }
        log.info("Claim: " + claim);

        log.info("--Name Validation--");
        var isValidName = this.nameValidator.validate(claim);
        log.info("Name: "+ isValidName);

        log.info("--Role Validation--");
        var isValidRole = this.roleValidator.validate(claim);
        log.info("Role: "+ isValidRole);

        log.info("--Seed Validation--");
        var isValidSeed = this.seedValidator.validate(claim);
        log.info("Seed: "+ isValidSeed);

        return (isValidName && isValidSeed && isValidRole);
    }
}
