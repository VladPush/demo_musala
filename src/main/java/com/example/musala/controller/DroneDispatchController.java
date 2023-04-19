package com.example.musala.controller;

import com.example.musala.dto.drone.DroneEntity;
import com.example.musala.dto.drone.DroneModelDto;
import com.example.musala.dto.goods.Medication;
import com.example.musala.service.DroneDispatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drone")
@AllArgsConstructor
public class DroneDispatchController {

    private final DroneDispatchService droneDispatchService;

    @PostMapping("/register")
    public long register(@RequestBody final DroneModelDto model) {
        return droneDispatchService.register(model).getId();
    }

    @PostMapping("/load")
    public boolean load(@RequestParam final long id, @RequestBody final List<Medication> goods) {
        return droneDispatchService.load(id, goods);
    }

    @GetMapping("/{id}")
    public DroneEntity register(@PathVariable final long id) {
        return droneDispatchService.get(id);
    }

    @GetMapping("/cargo/{id}")
    public List<Medication> getCargo(@PathVariable final long id) {
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
