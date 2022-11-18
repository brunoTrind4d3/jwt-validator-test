package com.itau.appjwtvalidator.domain.service.validator;

import com.itau.appjwtvalidator.domain.entity.Claim;
import com.itau.appjwtvalidator.util.ValidatingUtils;

import java.util.Optional;

public class NameValidator {
    public boolean validate(Claim claim){

        var name = Optional.ofNullable(claim).map(Claim::getName).orElse(null);
        if(name == null){
            return false;
        }

        return  ValidatingUtils.maxLength(name, 256) && ValidatingUtils.onlyNumbers(name);
    }
}
