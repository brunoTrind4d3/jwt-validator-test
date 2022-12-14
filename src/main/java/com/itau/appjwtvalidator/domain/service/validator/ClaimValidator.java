package com.itau.appjwtvalidator.domain.service.validator;

import com.google.gson.GsonBuilder;
import com.itau.appjwtvalidator.domain.entity.Claim;

public class ClaimValidator {

    public Claim validate(String jwtBody){
        return this.getClaim(jwtBody);
    }

    private Claim getClaim(String decodeBody){

        if(decodeBody.split(",").length > 3){
            return null;
        }
        try{
            var gsonBuilder = new GsonBuilder();
            var gson = gsonBuilder.create();
            return gson.fromJson(decodeBody, Claim.class);
        }catch (Exception ex){
            return null;
        }
    }

}
