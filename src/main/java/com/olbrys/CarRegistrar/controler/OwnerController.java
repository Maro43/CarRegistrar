package com.olbrys.CarRegistrar.controler;

import com.olbrys.CarRegistrar.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerService ownerService;
}
