package com.olbrys.CarRegistrar.repository;

import com.olbrys.CarRegistrar.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleJpaRepository extends JpaRepository <VehicleEntity, String> {
}
