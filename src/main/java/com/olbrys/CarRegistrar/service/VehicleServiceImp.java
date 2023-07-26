package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.VehicleDto;
import com.olbrys.CarRegistrar.entity.VehicleEntity;
import com.olbrys.CarRegistrar.repository.VehicleJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class VehicleServiceImp implements VehicleService {

    private final VehicleJpaRepository vehicleRepository;

    @Override
    public VehicleDto getVehicleById(String id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow();
        return new VehicleDto(vehicleEntity.getId(), vehicleEntity.getModel(), vehicleEntity.getSeries(),
                vehicleEntity.getYearProduction(), vehicleEntity.getYearRegistration(), vehicleEntity.isValid());
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity = new VehicleEntity(vehicleDto.getId(),
                vehicleDto.getSeries(), vehicleDto.getModel(),
                vehicleDto.getYearProduction(), vehicleDto.getYearRegistration(),
                vehicleDto.isValid());
        VehicleEntity save = vehicleRepository.save(vehicleEntity);
        return new VehicleDto(vehicleDto.getId(), vehicleDto.getModel(), vehicleDto.getSeries(),
                vehicleDto.getYearProduction(), vehicleDto.getYearRegistration(), vehicleDto.isValid());
    }
}
