package com.itau.appjwtvalidator.domain.service.validator;

import com.itau.appjwtvalidator.domain.entity.Claim;
import com.itau.appjwtvalidator.util.ValidatingUtils;

import java.util.Optional;

public class SeedValidator {
    public boolean validate(Claim claim){
        var seed = Optional.ofNullable(claim).map(Claim::getSeed).orElse(null);
        if(seed == null ){
            return false;
        }
        if(!ValidatingUtils.onlyNumbers(seed)){
            return false;
        }
        return  ValidatingUtils.isPrimeNUmber(seed);
    }
}
