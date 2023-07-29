package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.VehicleDto;

public interface VehicleService {

    VehicleDto getVehicleById(String id);

    VehicleDto saveVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(String id);
}
