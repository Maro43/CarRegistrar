package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.VehicleDto;
import com.olbrys.CarRegistrar.entity.VehicleEntity;
import com.olbrys.CarRegistrar.repository.VehicleJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<VehicleEntity> existingVehicle = vehicleRepository.findById(vehicleDto.getId());
        if (existingVehicle.isPresent()) {
            throw new IllegalArgumentException("Pojazd o podanym identyfikatorze już istnieje w bazie danych.");
        }
        VehicleEntity vehicleEntity = new VehicleEntity(vehicleDto.getId(),
                vehicleDto.getSeries(), vehicleDto.getModel(),
                vehicleDto.getYearProduction(), vehicleDto.getYearRegistration(),
                vehicleDto.isValid());
        VehicleEntity save = vehicleRepository.save(vehicleEntity);
        return new VehicleDto(save.getId(), save.getModel(), save.getSeries(),
                save.getYearProduction(), save.getYearRegistration(), save.isValid());
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(vehicleDto.getId()).orElseThrow();
        vehicleEntity.setSeries(vehicleDto.getSeries());
        vehicleEntity.setModel(vehicleDto.getModel());
        vehicleEntity.setYearProduction(vehicleDto.getYearProduction());
        vehicleEntity.setYearRegistration(vehicleDto.getYearRegistration());
        vehicleEntity.setValid(vehicleDto.isValid());
        VehicleEntity save = vehicleRepository.save(vehicleEntity);
        return new VehicleDto(save.getId(), save.getModel(), save.getSeries(),
                save.getYearProduction(), save.getYearRegistration(), save.isValid());
    }

    @Override
    public void deleteVehicle(String id) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id).orElseThrow();
        vehicleRepository.deleteById(id);

    }
}
