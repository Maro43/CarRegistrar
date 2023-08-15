package com.olbrys.CarRegistrar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;
    private String lastName;
    private boolean validLicence;

    public OwnerEntity(String firstName, String lastName, boolean validLicence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.validLicence = validLicence;
    }
}