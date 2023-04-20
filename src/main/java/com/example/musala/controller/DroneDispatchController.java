package com.example.musala.controller;

import com.example.musala.dto.DroneCreateDto;
import com.example.musala.dto.MedicationDto;
import com.example.musala.entity.drone.DroneEntity;
import com.example.musala.service.DroneDispatchService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drone")
@AllArgsConstructor
public class DroneDispatchController {

    private final DroneDispatchService droneDispatchService;

    @PostMapping("/register")
    public long register(@RequestBody @Valid final DroneCreateDto model) {
        return droneDispatchService.register(model).getId();
    }

    @PostMapping("/load")
    public boolean load(@RequestParam final long id, @RequestBody final List<MedicationDto> goods) {
        return droneDispatchService.load(id, goods);
    }

    @GetMapping("/{id}")
    public DroneEntity get(@PathVariable final long id) {
        return droneDispatchService.get(id);
    }

    @GetMapping("/cargo/{id}")
    public List<MedicationDto> getCargo(@PathVariable final long id) {
        return droneDispatchService.getCargo(id);
    }

    @GetMapping("/available")
    public List<DroneEntity> getAvailableDrones() {
        return droneDispatchService.getAvailableDrones();
    }

    @GetMapping("/battery/{id}")
    public float getBatteryLevel(@PathVariable final long id) {
        return droneDispatchService.getBatteryLevel(id);
    }
}
