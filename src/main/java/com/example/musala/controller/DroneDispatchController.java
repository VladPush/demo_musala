package com.example.musala.controller;

import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.service.DroneDispatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/drone")
@AllArgsConstructor
public class DroneDispatchController {

    private final DroneDispatchService droneDispatchService;

    @PostMapping("/register")
    public UUID register(final DroneModelDto model, final String serial) {
        return droneDispatchService.register(model, serial);
    }
}
