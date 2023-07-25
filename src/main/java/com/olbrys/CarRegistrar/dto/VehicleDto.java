package com.olbrys.CarRegistrar.dto;

import com.olbrys.CarRegistrar.entity.VehicleEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleDto {

    private final String id;
    private final String model;
    private final String series;
    private final int yearProduction;
    private final int yearRegistration;
    private final boolean valid;

    public VehicleDto(VehicleEntity vehicleEntity) {
        this.id = vehicleEntity.getId();
        this.model = vehicleEntity.getModel();
        this.series = vehicleEntity.getSeries();
        this.yearProduction = vehicleEntity.getYearProduction();
        this.yearRegistration = vehicleEntity.getYearRegistration();
        this.valid = vehicleEntity.isValid();
    }
}
