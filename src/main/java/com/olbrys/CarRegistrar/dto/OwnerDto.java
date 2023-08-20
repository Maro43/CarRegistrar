package com.olbrys.CarRegistrar.dto;

import com.olbrys.CarRegistrar.entity.OwnerEntity;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class OwnerDto {

    @Setter(AccessLevel.NONE)
    private Long id;
    private String firstName;
    private String lastName;
    private boolean validLicence;

    public OwnerDto(String firstName, String lastName, boolean validLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.validLicence = validLicence;
    }

    public OwnerDto(OwnerEntity ownerEntity) {
        this.id=ownerEntity.getId();
        this.firstName = ownerEntity.getFirstName();
        this.lastName = ownerEntity.getLastName();
        this.validLicence = ownerEntity.isValidLicence();
    }
}