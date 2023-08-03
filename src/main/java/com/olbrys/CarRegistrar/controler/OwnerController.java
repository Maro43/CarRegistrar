package com.olbrys.CarRegistrar.controler;

import com.olbrys.CarRegistrar.dto.OwnerDto;
import com.olbrys.CarRegistrar.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public OwnerDto getOwnerById(Long id){
        return ownerService.findById(id);
    }

    @PostMapping
    public OwnerDto saveOwner(OwnerDto ownerDto){
        return ownerService.saveOwner(ownerDto);
    }

    @PutMapping
    public OwnerDto updateOwner(OwnerDto ownerDto){
        return ownerService.updateOwner(ownerDto);
    }

    @DeleteMapping
    public void deleteOwner(Long id){
        ownerService.deleteOwner(id);
    }
}
