package com.olbrys.CarRegistrar.controler;

import com.olbrys.CarRegistrar.dto.VehicleDto;
import com.olbrys.CarRegistrar.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/getbyid")
    public VehicleDto getVehicleById(String id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/checkid")
    public Boolean checkIdInDB(String id){return vehicleService.checkIdInDB(id);}

    @PostMapping("/post")
    public VehicleDto saveVehicle(VehicleDto vehicleDto, Long ownerId){
        return vehicleService.saveVehicle(vehicleDto, ownerId);
    }

    @PutMapping
    public VehicleDto updateVehicle(VehicleDto vehicleDto){
        return vehicleService.updateVehicle(vehicleDto);
    }

    @DeleteMapping
    public void deleteVehicleById(String id){
        vehicleService.deleteVehicle(id);
    }
}