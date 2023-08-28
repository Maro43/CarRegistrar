package com.olbrys.CarRegistrar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "registration_vehicle")
public class VehicleEntity {

    @Id
    private String id;

    private String model;
    private String series;
    private int yearProduction;
    private int yearRegistration;
    private boolean valid;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerCar;

    public VehicleEntity(String id, String model, String series, int yearProduction, int yearRegistration, boolean valid) {
        this.id = id;
        this.model = model;
        this.series = series;
        this.yearProduction = yearProduction;
        this.yearRegistration = yearRegistration;
        this.valid = valid;
    }
}