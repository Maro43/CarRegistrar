package com.olbrys.CarRegistrar.dto;

import com.olbrys.CarRegistrar.entity.OwnerEntity;
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

    public OwnerDto(OwnerEntity ownerEntity) {
        this.firstName = ownerEntity.getFirstName();
        this.lastName = ownerEntity.getLastName();
        this.validLicence = ownerEntity.isValidLicence();
    }
}