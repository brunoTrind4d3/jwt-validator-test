package com.itau.appjwtvalidator.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Roles {

    ADMIN("Admin"), MEMBER("Member"), EXTERNAL("External");

    private final String description;
}
