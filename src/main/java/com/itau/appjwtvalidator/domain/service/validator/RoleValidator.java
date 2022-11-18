package com.itau.appjwtvalidator.domain.service.validator;

import com.itau.appjwtvalidator.domain.entity.Claim;
import com.itau.appjwtvalidator.domain.entity.Roles;

import java.util.Optional;

public class RoleValidator {

    public boolean validate(Claim claim){

        var role = Optional.ofNullable(claim).map(Claim::getRole)
                .map(Roles::findByDescription).orElse(null);
        return  role != null;
    }
}
