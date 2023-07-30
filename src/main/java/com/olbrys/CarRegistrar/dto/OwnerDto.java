package com.olbrys.CarRegistrar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OwnerDto {

    private String firstName;
    private String lastName;
    private boolean validLicence;

    public OwnerDto(String firstName, String lastName, boolean validLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.validLicence = validLicence;
    }
}
