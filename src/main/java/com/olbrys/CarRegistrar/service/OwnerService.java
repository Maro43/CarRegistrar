package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.OwnerDto;

public interface OwnerService {

    OwnerDto findById(Long id);

    OwnerDto saveOwner(OwnerDto ownerDto);

    OwnerDto updateOwner(OwnerDto ownerDto);

    void deleteOwner(Long id);
}
