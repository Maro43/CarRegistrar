package com.olbrys.CarRegistrar.repository;

import com.olbrys.CarRegistrar.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerJpaRepository extends JpaRepository <OwnerEntity,Long> {
    OwnerEntity findByFirstNameAndLastName(String firstName, String lastName);
}