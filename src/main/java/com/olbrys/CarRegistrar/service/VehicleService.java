package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.VehicleDto;

public interface VehicleService {

    VehicleDto getVehicleById(String id);

    VehicleDto saveVehicle(VehicleDto vehicleDto, Long ownerId);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(String id);
}