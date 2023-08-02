package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.olbrys.CarRegistrar.entity.OwnerEntity;
import com.olbrys.CarRegistrar.repository.OwnerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class OwnerServiceImp implements OwnerService {

    private final OwnerJpaRepository ownerRepository;

    @Override
    public OwnerDto findById(Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow();
        return new OwnerDto(ownerEntity.getFirstName(), ownerEntity.getLastName(), ownerEntity.isValidLicence());
    }

    @Override
    public OwnerDto saveOwner(OwnerDto ownerDto) {
        OwnerEntity ownerEntity = new OwnerEntity(ownerDto.getFirstName(),
                ownerDto.getLastName(), ownerDto.isValidLicence());
        OwnerEntity save = ownerRepository.save(ownerEntity);
        return new OwnerDto(save.getFirstName(), save.getLastName(), save.isValidLicence());
    }

    @Override
    public OwnerDto updateOwner(OwnerDto ownerDto) {
        return null;
    }

    @Override
    public void deleteOwner(Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElseThrow();
        ownerRepository.deleteById(id);
    }
}
