package com.olbrys.CarRegistrar.repository;

import com.olbrys.CarRegistrar.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerJpaRepository extends JpaRepository <OwnerEntity,Long> {
}
