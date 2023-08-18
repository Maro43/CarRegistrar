package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.olbrys.CarRegistrar.entity.OwnerEntity;
import com.olbrys.CarRegistrar.repository.OwnerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
public class OwnerServiceImp implements OwnerService {

    private final OwnerJpaRepository ownerRepository;

    @Override
    public OwnerDto getOwnerById(Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElse(null);
        return ownerEntity != null ? new OwnerDto(ownerEntity) : null;
    }

    @Override
    public Long getOwnerIdByName(OwnerDto ownerDto) {
        OwnerEntity ownerEntity = ownerRepository.findByFirstNameAndLastName(ownerDto.getFirstName(), ownerDto.getLastName());
        return ownerEntity != null ? ownerEntity.getId() : null;
    }

    @Override
    public OwnerDto saveOwner(OwnerDto ownerDto) {
        OwnerEntity ownerEntity = new OwnerEntity(ownerDto.getFirstName(),
                ownerDto.getLastName(), ownerDto.isValidLicence());
        OwnerEntity save = ownerRepository.save(ownerEntity);
        return new OwnerDto(save);
    }

    @Override
    public OwnerDto updateOwner(OwnerDto ownerDto, Long id) {
        OwnerEntity ownerEntity = ownerRepository.findById(id).orElse(null);
        ownerEntity.setFirstName(ownerDto.getFirstName());
        ownerEntity.setLastName(ownerDto.getLastName());
        ownerEntity.setValidLicence(ownerDto.isValidLicence());
        OwnerEntity save = ownerRepository.save(ownerEntity);
        return new OwnerDto(save);
    }

    @Override
    public void deleteOwner(Long id) {
        Optional<OwnerEntity> ownerOptional = ownerRepository.findById(id);

        if (ownerOptional.isPresent()) {
            ownerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Właściciel o podanym ID nie istnieje");
        }
    }
}