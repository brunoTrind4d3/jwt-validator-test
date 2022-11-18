package com.itau.appjwtvalidator.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @SerializedName("Role")
    private String role;
    @SerializedName("Seed")
    private String seed;
    @SerializedName("Name")
    private String name;
}
