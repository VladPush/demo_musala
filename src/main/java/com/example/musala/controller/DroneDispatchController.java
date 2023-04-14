package com.example.musala.controller;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.goods.Medication;
import com.example.musala.service.DroneDispatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @PostMapping("/load")
    public boolean load(final UUID id, final List<Medication> goods) {
        return droneDispatchService.load(id, goods);
    }

    @GetMapping("/cargo")
    public List<Medication> getCargo(final UUID id) {
        return droneDispatchService.getCargo(id);
    }

    @GetMapping("/available")
    public List<DroneEntity> getCargo() {
        return droneDispatchService.getAvailableDrones();
    }
}
