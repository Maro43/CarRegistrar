package com.olbrys.CarRegistrar.service;

import com.olbrys.CarRegistrar.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    OwnerDto getOwnerById(Long id);

    Long getOwnerIdByName(OwnerDto ownerDto);

    List <OwnerDto> getList();

    OwnerDto saveOwner(OwnerDto ownerDto);

    OwnerDto updateOwner(OwnerDto ownerDto, Long id);

    void deleteOwner(Long id);
}