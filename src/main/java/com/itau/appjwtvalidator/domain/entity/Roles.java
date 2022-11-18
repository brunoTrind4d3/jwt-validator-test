package com.itau.appjwtvalidator.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Roles {

    ADMIN("Admin"), MEMBER("Member"), EXTERNAL("External");

    private final String description;

    public static Roles findByDescription(String description){
        if(description == null){
            return null;
        }
        return Arrays.stream(Roles.values()).filter(r -> r.getDescription().equals(description))
                .findFirst()
                .orElse(null);
    }
}
