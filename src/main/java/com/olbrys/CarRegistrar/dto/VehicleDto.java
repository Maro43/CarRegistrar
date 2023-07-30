package com.olbrys.CarRegistrar.dto;

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

    public VehicleDto(String id, String model, String series, int yearProduction, int yearRegistration, boolean valid) {
        this.id = id;
        this.model = model;
        this.series = series;
        this.yearProduction = yearProduction;
        this.yearRegistration = yearRegistration;
        this.valid = valid;
    }
}
