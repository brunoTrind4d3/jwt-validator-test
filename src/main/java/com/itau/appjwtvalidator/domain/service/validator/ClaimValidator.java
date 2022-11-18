package com.itau.appjwtvalidator.domain.service.validator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ClaimValidator {

    public boolean validate(String jwt){
        var allClaims = getAllClaimsFromToken(jwt);
        System.out.println(allClaims.getAudience());
        return  false;
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
