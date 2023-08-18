package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.OwnerDto;

public interface OwnerService {

    OwnerDto getOwnerById(Long id);

    Long getOwnerIdByName(OwnerDto ownerDto);

    OwnerDto saveOwner(OwnerDto ownerDto);

    OwnerDto updateOwner(OwnerDto ownerDto, Long id);

    void deleteOwner(Long id);
}