package com.itau.appjwtvalidator.domain.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itau.appjwtvalidator.domain.entity.Claim;
import com.itau.appjwtvalidator.domain.service.validator.ClaimValidator;
import com.itau.appjwtvalidator.domain.service.validator.NameValidator;
import com.itau.appjwtvalidator.domain.service.validator.RoleValidator;
import com.itau.appjwtvalidator.domain.service.validator.SeedValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.json.GsonJsonParser;

import java.util.Base64;
import java.util.Optional;

@RequiredArgsConstructor
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

        var claim = this.claimValidator.validate(decodeBody);

        if(claim == null){
            return false;
        }

        var isValidName = this.nameValidator.validate(claim);
        var isValidRole = this.roleValidator.validate(claim);
        var isValidSeed = this.seedValidator.validate(claim);

        return (isValidName && isValidSeed && isValidRole);
    }
}
